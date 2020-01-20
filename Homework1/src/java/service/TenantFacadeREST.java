/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Practica1.Room;
import Practica1.Tenant;
import Practica1.auth.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mikel
 */
@Stateless
@Path("tenant")
public class TenantFacadeREST extends AbstractFacade<Tenant> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public TenantFacadeREST() {
        super(Tenant.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tenant entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, Tenant entity, 
            @HeaderParam("name") String name, @HeaderParam("pswd") String pswd) {
        if (super.find(id) == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Tenant no trobat").build();
        }
        super.edit(entity);
        return Response.status(Response.Status.OK).build();
        
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        if (super.find(id) == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Tenant no trobat").build();
        }
        super.remove(super.find(id));
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        if (super.find(id) == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Tenant no trobat").build();
        }
        return Response.status(Response.Status.OK).entity(super.find(id)).build();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tenant> findAll() {
        return super.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("username") String username, @PathParam("password") String password) {
        GenericEntity<List<User>> generic;
        System.out.println("USER: "+ username);
        List<User> userList = em.createNamedQuery("Usuari.login")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        generic = new GenericEntity<List<User>>(userList.subList(0, 1)) {
        };
        return Response.status(Response.Status.OK).entity(generic).build();
    }
    
    
}
