/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Tenant;
import cat.urv.deim.sob.Room;
import cat.urv.deim.sob.RoomClient;
import cat.urv.deim.sob.TenantClient;
import cat.urv.deim.sob.User;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergi
 */
public class LoginCommand implements Command{
    
    public LoginCommand() {
        super();
    }
    
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("USER: " +request.getParameter("username"));
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        
        TenantClient c = new TenantClient();
        Response res = c.find(null, "213");      
        
        System.out.println("STATUS: " + res.getStatus());
        System.out.println("username A BUSCAR: " + u);

                
        if(res.getStatus() == 200) {
            User user = res.readEntity(User.class);
            request.setAttribute("username", user.getUsername());
            System.out.println("Capturo el username: " + user.getUsername());
            request.getRequestDispatcher("/room-view.jsp").forward(request, response);
        }

       /*
        
        
// 1. process the request
        User user = new User();

        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        request.setAttribute("user", user);
*/      
       System.out.println("-------------");

       // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/list-room.do?sort=asc.jsp").forward(request, response);
    }
}
