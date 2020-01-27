
package service;

import Practica1.Room;
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
@Path("user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@HeaderParam("username") String username,
            @HeaderParam("password") String password) {
        
        System.out.println("METHOD /login\n"
                +"USERNAME: " + username + "\nPASSWORD: " + password);

        
        List<User> usernameList = em.createNamedQuery("Usuari.findByUsername")
                .setParameter("username", username).getResultList();
        
        if (usernameList != null && username != null && password != null) {
            GenericEntity<User> generic;
            User u;
            //System.out.println("\n\n\nHOLA\n\n\n");
            List<User> userList;
            try {
                userList = em.createNamedQuery("Usuari.login")
                    .setParameter("username", username)
                    .setParameter("password", password).getResultList();
                u = userList.get(0);
            } catch (Exception e){
                System.out.println("Not correct credentials");
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
            
            // System.out.println("REGISTED USER: " +  u.toString());
            
            if (u == null ){
                return Response.status(Response.Status.UNAUTHORIZED).build();

            } else {
                generic = new GenericEntity<User>(u){};
                return Response.status(Response.Status.OK).entity(generic).build();
            }
        } else {
            return Response.status(Response.Status.MOVED_PERMANENTLY).build();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
