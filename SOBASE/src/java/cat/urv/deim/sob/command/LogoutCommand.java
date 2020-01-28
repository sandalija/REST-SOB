/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sergi
 */
public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html");  
        //PrintWriter out=response.getWriter();  
                            
        HttpSession session = request.getSession();  
        session.invalidate();  
              
        System.out.print("You are successfully logged out!"); 
        
        response.sendRedirect("/SOBASE/list-room.do?sort=asc");  

  
    }
    
}
