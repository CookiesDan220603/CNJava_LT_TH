<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <%
       String username = request.getAttribute("username") != null ? request.getAttribute("username").toString() : "";
         String password = request.getAttribute("password") != null ? request.getAttribute("password").toString() : "";
    %>
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">Login Page</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" type="text" class="form-control" placeholder="Username" name="username" required value="<%= username %>">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" placeholder="Password" name="password" required value="<%= password%>">
                </div>
                <div class="form-group">
                    <input id="remember" type="checkbox" name="remember">
                    <label for="remember">Remember username & password</label>
                </div>
                <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-warning" role="alert">
                    <strong>
                        <%
                            out.print(request.getAttribute("error"));
                        %>
                    </strong>
                </div>
                <% } %>
                <div class="form-group">
                    <label for="remember">Create new account</label>
                    <a href="register" class="text-primary ms-3">Register</a>
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5" type="submit">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>