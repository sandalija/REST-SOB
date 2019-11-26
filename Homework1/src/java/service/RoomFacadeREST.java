/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
        return Response.status(Response.Status.OK).build();
        
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    /*@GET
    @Path("{sort}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> findWithPrice(){
        /*List<Room> lista = super.findAll();
        if (sequence.equals("asc")) {
            Collections.sort(lista);
        }
        else {
            Collections.reverse(lista);
        }
        return lista;
        return super.findAll();
    }*/
    /*
    @GET
    @Override
    @Produces( MediaType.APPLICATION_JSON)
    public List<Room> findAll(@QueryParam("sort") String sort) {
        List<Room> roomList = super.findAll();
        if (sort == null) sort = "asc";
        
        if (sort ==)
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("sort") String sort)
    {
        List<Room> RoomList;
        RoomList = super.findAll();
        List<Room> RoomList_Ordered = new ArrayList<>();

        switch (sort)
        {
            case "asc":
                //RoomList_Ordered = RoomList.stream().sorted((Room_A, Room_B);
                Collections.sort(RoomList, new RoomComparator());
                break;
            case "desc":
                Collections.sort(RoomList, new RoomComparator());
                break;
        }
        GenericEntity<List<Room>> generic = new GenericEntity<List<Room>>(RoomList_Ordered){};
        return Response.status(Response.Status.OK).entity(generic).build();
        //return RoomList;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Room> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
    
}
