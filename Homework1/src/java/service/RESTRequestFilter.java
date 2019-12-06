package service;

import Practica1.auth.AuthHTTPHeaders;
import Practica1.auth.Authenticator;
import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RESTRequestFilter implements ContainerRequestFilter {

    private final static Logger log = Logger.getLogger( RESTRequestFilter.class.getName() );

    @Override
    public void filter( ContainerRequestContext requestCtx ) throws IOException {

        String path = requestCtx.getUriInfo().getPath();
        log.info( "Filtering request path: " + path );
        if ( requestCtx.getRequest().getMethod().equals( "OPTIONS" ) ) {
            requestCtx.abortWith( Response.status( Response.Status.OK ).build() );

            return;
        }

        // Then check is the service key exists and is valid.
        Authenticator auth = Authenticator.getInstance();
        String serviceKey = requestCtx.getHeaderString( AuthHTTPHeaders.SERVICE_KEY );

        if ( !auth.isServiceKeyValid( serviceKey ) ) {
            // Kick anyone without a valid service key
            requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );

            return;
        }

        // For any pther methods besides login, the authToken must be verified
        if ( !path.startsWith( "login" ) ) {
            String authToken = requestCtx.getHeaderString( AuthHTTPHeaders.AUTH_TOKEN );

            // if it isn't valid, just kick them out.
            if ( !auth.isAuthTokenValid( serviceKey, authToken ) ) {
                requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
            }
        }
    }
}