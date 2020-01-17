<%-- 
    Document   : list-room
    Created on : 05-dic-2019, 18:46:53
    Author     : sergi
--%>

<%@page import="java.util.List"%>
<%@page import="cat.urv.deim.sob.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Bla</p>
        <%
            /*List<Room> searchResults = (List<Room>) request.getAttribute("room");
                for (Room r : searchResults) {

                    out.print(r.getPreu());
                } */
            Room rm = new Room();
            rm.setAdreca("aqui");
            out.println(rm.getAdreca());
        %>
    </body>
</html>
