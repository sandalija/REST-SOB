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
        String sort = request.getParameter("sort");
        String location = request.getParameter("location");
        System.out.println(location);
        System.out.println(sort);      
        
        Response res;
        
        if (location != null && location.equals("")) {
                res = c.findByLocation(null, sort);
        } else  res = c.findByLocation(location, sort);

        
        
        System.out.println("STATUS (): " + res.getStatus());

                
        if(res.getStatus() == 200) {       
            List<Room> roomList;
            roomList = res.readEntity(
                new GenericType<List<Room>>() {});
            /* request.setAttribute("lista", RoomList);
            Room tmp;
            for(int i = 0; i < RoomList.size(); i++){
                tmp = RoomList.get(i);
                System.out.println(tmp.toString());
            } */
            
            // Hasta aqui, la lista está OK
            request.setAttribute("list-room", roomList);
            request.setCharacterEncoding("UTF-8");

            request.getRequestDispatcher("/list-room-view.jsp").forward(request, response);
            //Room first = RoomList.get(0);
            //System.out.println(first.getLocation());
        } else {
            System.out.println(res.getAllowedMethods());
        }
    }
    
}
