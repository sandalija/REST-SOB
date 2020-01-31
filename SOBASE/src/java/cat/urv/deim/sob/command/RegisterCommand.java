/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Tenant;
import cat.urv.deim.sob.User;
import cat.urv.deim.sob.UserClient;
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
public class RegisterCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("USER in command: " +request.getParameter("username"));
        System.out.println("PASSWORD in command: " +request.getParameter("password"));

        String u = request.getParameter("username");
        String p = request.getParameter("password");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String tlf = request.getParameter("tlf");
        String email = request.getParameter("email");
        int pets, smoke;
        if (request.getParameter("smoke").equals("true")) {
            smoke = 1;
        } else smoke = 0;
        if (request.getParameter("pets").equals("true")) {
            pets = 1;
        } else pets = 0;
        
        
        Tenant tenant = new Tenant (u, email, tlf,
                Integer.parseInt(age), sex, pets, smoke);
        
        User user = new User(u, p, tenant);

        
        user.setTenant(tenant);

        
        System.out.println("USET TO CREATE: " + user.toString());
        
        
        UserClient c = new UserClient();
        // Response res = c.edit(user);
        Response res = c.signin(user);    
        
   
        
       System.out.println("STATUS: " + res.getStatus());
        
        HttpSession session; 
       
        if (res.getStatus() == 200) {
            session = request.getSession();  
            session.setAttribute("username", u);
            request.getRequestDispatcher("/list-room.do?sort=asc").forward(request, response);

        } else {
            request.setAttribute("sigin", "failed");
            response.sendRedirect("/SOBASE/register.jsp");
        }
        
    }
    
}

