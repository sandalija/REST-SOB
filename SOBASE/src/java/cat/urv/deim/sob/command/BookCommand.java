/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Room;
import cat.urv.deim.sob.RoomClient;
import cat.urv.deim.sob.User;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergi
 */
public class BookCommand implements Command {
    
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession(); 
       //System.out.println("Session: " + session);
            
        if (session.getAttribute("username") == null) {
            request.setAttribute("auth", "needed");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            
            // COMPROBAR QUE LA RESERVA ÉS VÀLIDA
            
            
            // System.out.println("URL: " + request.getHeader("id");
           /* RoomClient c = new RoomClient();
            Response res = c.find(id);
            Room room;
            room = res.readEntity(Room.class);
            System.out.println("Room a reserver: "+ room.toString());
            
            

            
            
            /*
            Boolean compatible = true;
            // fumador
            compatible = request.getParameter("smoke").equals(request);
            String p = request.getParameter("password");
            
            System.out.println("Ya registrado");
            */
           //room = res.getEntity(Room.class);
        } 
    }
}
