/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.*;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergi
 */
public class RoomCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException {
        
        // Room r = new Room();
        int id = Integer.parseInt(request.getParameter("id"));
        RoomClient c = new RoomClient();
        Response res = c.find(id);
        
        System.out.println("STATUS: " + res.getStatus());
        System.out.println("ID A BUSCAR: " + id);

                
        if(res.getStatus() == 200) {
            Room room = res.readEntity(Room.class);
            request.setAttribute("room", room);
            System.out.println("BUSCO A LA BD: " + room.getRoomId());
            request.getRequestDispatcher("/room-view.jsp").forward(request, response);
        }
    
    }
}
