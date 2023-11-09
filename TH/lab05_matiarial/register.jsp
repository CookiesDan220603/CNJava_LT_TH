<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <title>Register Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">Register</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="register" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" type="text" class="form-control" placeholder="Username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" type="text" class="form-control" placeholder="Email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" placeholder="Password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="password_confirm">Confirm Password</label>
                    <input id="password_confirm" type="password" class="form-control" placeholder="Confirm Password" name="password_confirm" required>
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
                    <button class="btn btn-success px-5" type="submit">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>