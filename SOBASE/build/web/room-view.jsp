<%@page import="cat.urv.deim.sob.Room"%>
<%@page import="cat.urv.deim.sob.Requeriments"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- https://github.com/JamieMcGibbon/TechnicalCafe/blob/master/Misc%20Tutorials/Basic%20Bootstrap%20Profile/index.html -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
        <title>Room in ${room.location}</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./styles.css" type="text/css" />
    </head>
    <body>
        <%
            
        %>
        <%@ include file="/navbar.jsp"  %>

        <div class="container-fluid">

    <!--First row (only row)-->
    <div class="row extra_margin">

      <!-- First column (smaller of the two). Will appear on the left on desktop and on the top on mobile. -->
      <div class="col-md-4 col-sm-12 col-xs-12">

          <!-- Div to center the header image/name/social buttons -->
          <div class="text-center">

              <!-- Placeholder image using Placeholder.com -->
              <img src=${room.img} class="img-rounded"/>

              <!-- Header text (Person's name) -->
              <h2>Room in ${room.adreca}, ${room.location}</h2>

              <!-- Social buttons using anchor elements and btn-primary class to style -->
              <p>
                <a class="btn btn-primary btn-xs" href="book.do" role="button">Book it</a>
              </p>

          </div>

      </div> <!-- End Col 1 -->

      <!-- Second column - for small and extra-small screens, will use whatever # cols is available -->
      <div class="col-md-8>

        <!-- "Lead" text at top of column. -->
        <h5 class="lead"><b>Adress: </b> ${room.adreca}</h5><br>
        <h5 class="lead"><b>City: </b> ${room.location}</h5><br>
        <h3 class="lead"><b>Rent: </b>${room.preu} €/mo</h3><br>

        <!-- Horizontal rule to add some spacing between the "lead" and body text -->
        <hr />
        <p class="lead">${room.description}</p>
        
        <hr />
        <% 
            Room r = (Room) request.getAttribute("room");
            Requeriments requerim = r.getRequeriments();          
        %>
        <!-- PETS -->
        <h3 class="lead"><b>Pets: </b>
        <% if (requerim.getMascotes() != 0) {
            out.println("Allowed"); }
        else {
          out.println("Not allowed");
                } %>
        </h3><br>
        
        <!-- SMOKE -->
        <h3 class="lead"><b>Smoking: </b>
        <% if (requerim.getMascotes() != 0) {
            out.println("Allowed"); }
        else {
          out.println("Not allowed");
                } %>
        </h3><br>
        
        <!-- AGE -->
        <h3 class="lead"><b>Age: </b> 
        <% 
            out.println(requerim.getMinEdat());
        %>
        -
        <% 
            out.println(requerim.getMaxEdat());
        %>
        
        
        </h3><br>


        
      </div> <!-- End column 2 -->

    </div> <!-- End row 1 -->

  </div> <!-- End main container -->
    </body>
</html>
