<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<%
    if(session.getAttribute("isLogin")!=null)
        if(session.getAttribute("isLogin").equals("123")){
            response.sendRedirect("product");
        }
%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" type="text" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group" hidden="hidden">
                    <label for="remUser"></label><input type="text" id="remUser" value="${cookie['username'].value}" />
                    <label for="remPassword"></label><input type="text" id="remPassword"
                                                            value="${cookie['password'].value}">
                </div>
                <div class="form-group">
                    <p style="color: red">
                        <c:if test="${not empty messageErr}">
                            ${messageErr}
                        </c:if>
                    </p>
                </div>
                <div class="form-group">
                    <input type="checkbox" id="remember"> Remember username & password
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5" type="submit">Login</button>
                </div>
                <div class="form-group">
                    <p>Don't have account? <a href="register.jsp">Click here</a></p>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $("#remember").change(function() {
        if(this.checked) {
            $("#username").val($("#remUser").val())
            $("#password").val($("#remPassword").val())
        }
    });
</script>
</body>
</html>
