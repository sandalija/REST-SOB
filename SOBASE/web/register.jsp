<%-- 
    Document   : login-register
    Created on : 19-ene-2020, 12:48:11
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="/navbar.jsp"  %>
        <% if (request.getAttribute("signin") != null) {
                            if (request.getAttribute("signin").equals("failed")) {
                        %> <p class="btn-warning">Sign in failed</p> <%
                            }
                        }
        %>
        <div class="d-flex justify-content-between">
            <div class="center-login">
                <div>
                    <form class="form-signin" action="register.do" method="post">
                        <h1 class="h3 mb-3 font-weight-normal order-label">Please sign in</h1>
                        
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" id="email" name ="email" class="form-control order-label" placeholder="email" required>
                        <input type="text" id="username" name ="username" class="form-control order-label" placeholder="username" required>
                        <input type="text" id="inputPassword" name ="password" class="form-control order-label" placeholder="Password" required>
                        <input type="text" id="tlf" name ="tlf" class="form-control order-label" placeholder="Telephone" required>                       
                          <label class="order-label">
                            <input type="radio" name="sex" value="male">Male
                        </label>
                        <label class="order-label">
                            <input type="radio" name="sex" value="female"> Female  
                        </label>
                        </br>
                         <label class="order-label">
                            <input type="radio" name="sex" value="unisex"> You don't care  
                        </label>
                        <label>
                           <input type="number" id="age" name="age" min="18" max="99"> Age:
                        </label>
                         <label class="order-label">
                            <input type="radio" name="smoke" value="false"> No smoke 
                        </label>
                        <label class="order-label">
                            <input type="radio" name="smoke" value="yes"> Smoke 
                        </label>
                         <label class="order-label">
                            <input type="radio" name="pets" value="false"> No pets  
                        </label>
                        <label class="order-label">
                            <input type="radio" name="pets" value="yes"> Pets 
                        </label>
                        <button class="btn btn-lg btn-primary btn-block order-label" type="submit">Register</button>
                    </form>
                </div>
             </div>
        </div>
    </body>
</html>
