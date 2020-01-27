/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.UserClient;
import cat.urv.deim.sob.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergi
 */
public class LoginCommand implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("USER in command: " +request.getParameter("username"));
        System.out.println("PASSWORD in command: " +request.getParameter("password"));

        String u = request.getParameter("username");
        String p = request.getParameter("password");
        
        UserClient c = new UserClient();
        Response res = c.login(u,p);    
        
     
        
        System.out.println("STATUS: " + res.getStatus());

                
        switch (res.getStatus()) {
            case 200:
                User user = res.readEntity(User.class);
                //System.out.println("username A BUSCAR: " + user.getUsername());
                String username = user.getUsername();
                request.setAttribute("username", username);
                //System.out.println("Capturo el username: " + user.getUsername());
                HttpSession session = request.getSession();  
                session.setAttribute("username", username); 
                request.getRequestDispatcher("/list-room.do?sort=asc").forward(request, response);
                break;
            case 401:
                request.setAttribute("auth", "false");
                request.getRequestDispatcher("/login-register.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("/login-register.jsp");
                break;
        }

      
    }
}
