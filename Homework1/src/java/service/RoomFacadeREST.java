/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Practica1.Room;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mikel
 */
@Stateless
@Path("room")
public class RoomFacadeREST extends AbstractFacade<Room> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public RoomFacadeREST() {
        super(Room.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Room entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, Room entity) {
        if (super.find(id) == null)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("ROOM no trobada").build();
        }
        super.edit(entity);
        return Response.status(Response.Status.OK).entity(super.find(id)).build();
        
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        if (super.find(id) != null){
            super.remove(super.find(id));
            return Response.status(Response.Status.OK).build();

        }
        return Response.status(Response.Status.NOT_FOUND).entity("ROOM no trobada").build();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room find(@PathParam("id") Integer id) {
        Room room = super.find(id);
        System.out.println("IMG: "+room.getImg());
        return room;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByLocation(
            @QueryParam("location") String location, 
            @QueryParam("sort") String sort){
       List<Room> RoomList;
       GenericEntity<List<Room>> generic;

       
       String newLocation; 


       if (sort == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
       }
       if (location != null) {
           newLocation = location.substring(0, 1).toUpperCase() + location.substring(1).toLowerCase();
           location = newLocation;
       }
       
       switch (sort) {
           case "asc": 
               if (location == null) {
                   RoomList = em.createNamedQuery("Room.orderByASC").getResultList();
               } else {
                    RoomList = em.createNamedQuery("Room.findByLocationASC", Room.class).setParameter("location", location).getResultList();
               }
               generic = new GenericEntity<List<Room>>(RoomList){};
               break;
           case "desc": 
               if (location == null) {
                   RoomList = em.createNamedQuery("Room.orderByDESC").getResultList();
               } else {
                   RoomList = em.createNamedQuery("Room.findByLocationDESC", Room.class).setParameter("location", location).getResultList();
               }
               generic = new GenericEntity<List<Room>>(RoomList){};
               break;//.entity(em.createNamedQuery("Room.OrderByDESC").getResultList()).build();
           default:
               return Response.status(Response.Status.BAD_REQUEST).build();
       }
       
       return Response.status(Response.Status.OK).entity(generic).build();
    }
    
    @GET
    @Path("{id}/rent")
    public Response rent(@PathParam("roomId") int roomId, 
            @HeaderParam("tenantId") int tenantId){
        Room room = super.find(roomId);
        if (room == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        Tenant tenant = em.createNamedQuery("Usuari.login")
        if (room == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        

        
        
    }
    
    
}
