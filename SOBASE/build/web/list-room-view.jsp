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
        <script type="text/javascript">
            document.getElementById("myButton").onclick = function () {
                location.href = "http://localhost:8080/SOBASE/list-room.do?sort=asc";
            };
        </script>
        <style> 
            .order-label {
               margin: 4px;
               padding: 4px;
            }
            .button-left-down {
                margin: left;
            }
        </style>
        <title>Rooms</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="http://localhost:8080/SOBASE/list-room.do?sort=asc">RoomFinder</a>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="#">Future login</a>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="http://localhost:8080/SOBASE/list-room.do?sort=asc" method="get">
                <input class="form-control mr-sm-2" name="location" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-dark" type="submit">Search</button>
                <label class="order-label">
                    <input type="radio" name="sort" value="asc" checked> Asc  
                </label>
                <label class="order-label">
                    <input type="radio" name="sort" value="desc"> Desc  
                </label>
            </form>
          </div>
        </nav>
        <%
            List<Room> searchResults = (List<Room>) request.getAttribute("list-room");
            String sort = request.getParameter("sort");
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
                                  } %>
                                  <a class="btn button-left-down" href="http://localhost:8080/SOBASE/room?=${r.roomId}" role="button">View</a>
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
