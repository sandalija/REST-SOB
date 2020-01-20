<%-- 
    Document   : list-room
    Created on : 05-dic-2019, 18:46:53
    Author     : sergi
--%>

<%@page import="cat.urv.deim.sob.Requeriments"%>
<%@page import="java.util.List"%>
<%@page import="cat.urv.deim.sob.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles.css" type="text/css" />
        <script type="text/javascript">
            document.getElementById("myButton").onclick = function () {
                location.href = "http://localhost:8080/SOBASE/list-room.do?sort=asc";
            };
        </script>

        <title>Rooms</title>
    </head>
    <body>
        <%@ include file="/navbar.jsp"  %>
        <%
            List<Room> searchResults = (List<Room>) request.getAttribute("list-room");
            String sort = request.getParameter("sort");
            String base = "/SOBASE/room.do?id=";
            if (sort != null && searchResults != null) {
                %> 
                <ul class="list-group"> 

                    <%
                    
                    for (Room r: searchResults) {
                        %>
                            <li class="list-group-item card">
                                <div class="card bg-info text-white">
                                    <h3> <% out.println("Room in " + r.getAdreca()); %> </h3>
                                </div>
                                <div class="card-body">
                                    <p><b>City: </b> <% out.println(r.getLocation()); %> <p>
                                    <p><b>Price: </b> <% out.println(r.getPreu()); %> </p>
                                

                                <%
                                  Requeriments requerim = r.getRequeriments();
                                  if (requerim.getMascotes() == 1 && requerim.getFumador() == 1) { 
                                    %> <p> <% out.print("Pets are OK, Smoke is OK"); %> </p> <%
                                  } else if (requerim.getMascotes() == 1) { 
                                    %> <p> <% out.print("Pets OK"); %> </p> <%
                                  }else if (requerim.getFumador() == 1) { 
                                    %> <p> <% out.print("Smoke OK"); %> </p> <%
                                  } 
                                  
                                  String url = base + r.getRoomId();
                                  String img = r.getImg();
                                  %>
                                  <img src="<%=img %>" class="resize" />
                                  <a class="btn btn-info button-left-down" href="<%=url%>" role="button">View</a>
                                </div>
                            </li>      
                    <% }
                      %> 
                    </ul>
                  <%
            } else {
                %> 
                    <button onclick="redirect()">Go home</button> 
                <%
            }
        %>
    </body>
</html>
