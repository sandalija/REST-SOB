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
        <div class="center-login">
            <form class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal order-label">Please sign in</h1>
                <label for="inputEmail" class="sr-only">Username</label>
                <input type="email" id="inputEmail" class="form-control order-label" placeholder="Username" required autofocus>
                <input type="password" id="inputPassword" class="form-control order-label" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block order-label" type="submit">Sign in</button>
                <lr />
                <p class="order-label">Still not register?</p>
                <button class="btn btn-lg btn-primary btn-block order-label" type="submit">Register</button>
            </form>
        </div>
    </body>
</html>