/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "TimeServer")
@Stateless()
public class TimeServer {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getTimeAsSTring")
    public String getTimeAsString() { 
        return new Date().toString();
    }
    @WebMethod(operationName = "getTimeAsElapsed")
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}
