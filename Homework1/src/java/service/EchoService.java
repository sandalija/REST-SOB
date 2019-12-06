package service;

import Practica1.auth.AuthHTTPHeaders;
import Practica1.auth.Authenticator;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.security.auth.login.LoginException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class EchoService {
    static final String STATUS_KEY = "status";
    
    @POST
    @Path("/login")
    @Produces( MediaType.APPLICATION_JSON )
    public Response login(
        @Context HttpHeaders httpHeaders,
        @FormParam( "username" ) String username,
        @FormParam( "password" ) String password ) {

        Authenticator auth = Authenticator.getInstance();
        String serviceKey = httpHeaders.getHeaderString( AuthHTTPHeaders.SERVICE_KEY );

        try {
            String authToken = auth.login( serviceKey, username, password );

            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            jsonObjBuilder.add( "auth_token", authToken );
            JsonObject jsonObj = jsonObjBuilder.build();

            return getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();

        } catch ( final LoginException ex ) {
            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            jsonObjBuilder.add( "message", "Problem matching service key, username and password" );
            JsonObject jsonObj = jsonObjBuilder.build();

            return getNoCacheResponseBuilder( Response.Status.UNAUTHORIZED ).entity( jsonObj.toString() ).build();
        }
    }
    @POST
    @Path("/logout")
    public Response logout(
        @Context HttpHeaders httpHeaders ) {
        try {
            Authenticator auth = Authenticator.getInstance();
            String serviceKey = httpHeaders.getHeaderString( AuthHTTPHeaders.SERVICE_KEY );
            String authToken = httpHeaders.getHeaderString( AuthHTTPHeaders.AUTH_TOKEN );

            auth.logout( serviceKey, authToken );

            return getNoCacheResponseBuilder( Response.Status.NO_CONTENT ).build();
        } catch ( final GeneralSecurityException ex ) {
            return getNoCacheResponseBuilder( Response.Status.INTERNAL_SERVER_ERROR ).build();
        }
    }
    
    @POST
    @Path("/echo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response echo(InputStream data) {
        JsonObject obj = Json.createObjectBuilder().build();
	try {
            JsonReader jsonReader = Json.createReader(new InputStreamReader(data));
            obj = jsonReader.readObject();
            jsonReader.close();
            
            JsonObjectBuilder builder = Json.createObjectBuilder();
            obj.entrySet().forEach(e -> builder.add(e.getKey(), e.getValue()));
            builder.add(STATUS_KEY, "Successful");
            obj = builder.build();
            
        } catch (Exception e) {
            System.out.println("Error Parsing: - " + e);
	}
	return Response.status(200).entity(obj.toString()).build();
    }
 
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verify(InputStream data) {
	String result = "RESTService Successfully started..";
 	return Response.status(200).entity(result).build();
    }
    
        
    private Response.ResponseBuilder getNoCacheResponseBuilder( Response.Status status ) {
        CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );

        return Response.status( status ).cacheControl( cc );
    }
 
}
