/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Tenant;
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
        
       HttpSession session = request.getSession();  
        
        if (session.getAttribute("username") != null) {
            request.getRequestDispatcher("/user-view.jsp").forward(request, response);
        } else {
            switch (res.getStatus()) {
            case 200:
                User user = res.readEntity(User.class);
                //System.out.println("username A BUSCAR: " + user.getUsername());
                String username = user.getUsername();
                request.setAttribute("username", username);
                //System.out.println("Capturo el username: " + user.getUsername());
                session = request.getSession();  
                session.setAttribute("username", username); 
                Tenant tenant = user.getTenant();
                session.setAttribute("age", tenant.getEdat());
                session.setAttribute("smoke", tenant.getFumador());
                session.setAttribute("pets", tenant.getMascotes());
                session.setAttribute("sex", tenant.getFumador());
                session.setAttribute("auth", "true");
                request.getRequestDispatcher("/list-room.do?sort=asc").forward(request, response);
                break;
            case 401:
                request.setAttribute("auth", "false");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/login.jsp").forward(request, response);;
                //response.sendRedirect("/SOBASE/login.do");
                break;
        }
        }

                
        

      
    }
}
