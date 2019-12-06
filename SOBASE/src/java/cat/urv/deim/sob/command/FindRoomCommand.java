/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Room;
import cat.urv.deim.sob.RoomClient;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergi
 */
public class FindRoomCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomClient c = new RoomClient();
        Response res = c.findByLocation("desc", null);
        
        System.out.println("STATUS: " + res.getStatus());

                
        if(res.getStatus() == 200) {
            List<Room> RoomList;
            RoomList = res.readEntity(
                new GenericType<List<Room>>() {});
            request.setAttribute("lista", RoomList);
            request.getRequestDispatcher("/list-room-view.jsp").forward(request, response);
        }
    }
    
}