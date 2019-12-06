/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Practica1.Room;
import Practica1.Tenant;
import Practica1.auth.Users;
import java.util.LinkedList;
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
    public Response create(Tenant entity) {
        if (entity.getSexe().equals("HOME") || entity.getSexe().equals("DONA") || entity.getSexe().equals("UNISEX")){
                super.create(entity);
                return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Sexe no válid").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, Tenant entity, 
            @HeaderParam("name") String name, @HeaderParam("pswd") String pswd) {
        if (super.find(id) == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("ROOM no trobada").build();
        }
        super.edit(entity);
        return Response.status(Response.Status.OK).build();
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tenant find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tenant> findAll() {
        return super.findAll();
    }

    @POST
    @Path("{id}/rent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, Room room){
        
        /*
        // Autentification
        if (!auten(user)) {
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
        }
        */
        
        Tenant tenant = super.find(id);
        if (tenant == null) return Response.status(Response.Status.NOT_FOUND).build();
        // comprovar si satisfà les condicions7
        if (room.getRequeriments().getFumador() == 1 && tenant.getFumador() == 0){
            return Response.status(Response.Status.BAD_REQUEST).entity("No s'accepten fumadors").build();
        }
        if (room.getRequeriments().getMascotes() == 1 && tenant.getMascotes() == 0){
            return Response.status(Response.Status.BAD_REQUEST).entity("No s'accepten mascotes").build();
        }
        if (tenant.getEdat() < room.getRequeriments().getMinEdat() || tenant.getEdat() > room.getRequeriments().getMaxEdat()){
            return Response.status(Response.Status.BAD_REQUEST).entity("Edat no vàlida").build();
        }
        if (tenant.getSexe().equals("HOME") && room.getRequeriments().getSexe().equals("DONA")){
            return Response.status(Response.Status.BAD_REQUEST).entity("Només per a dones").build();

        }
        if (tenant.getSexe().equals("DONA") && room.getRequeriments().getSexe().equals("HOME")){
            return Response.status(Response.Status.BAD_REQUEST).entity("Només per a homes").build();
        }
        // comprovar si no té una habitació ja reservada
        if (tenant.getId_rent()!=0){
            return Response.status(Response.Status.BAD_REQUEST).entity("Ja tens una habitació").build();
        }
        tenant.setId_rent(room.getRoomId());
        return Response.status(Response.Status.OK).entity(room.getLandlord()).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /*
    public boolean auten(Users u){
        Users tmp = em.createNamedQuery("Users.findUser", Users.class).setParameter("username", u.getUsername()).getSingleResult();
        if (tmp.getHashCode().equals(u.getHashCode())) return true;
        else return false;
        
    }*/
    
    
   

    
    
}
