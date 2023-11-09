<%@ page import="entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        tr, th, td {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
    %>
    <div class="row">
        <div class="col-12">
            <div class="header d-flex justify-content-between align-items-center">
                <h2>Product Management</h2>
                <div class="info">
            <span class="h3">
                Xin chào <span style="color: red"><%= session.getAttribute("username")%></span>,
            <a href="/lab05_war_exploded/logout">Đăng xuất</a>
            </span>
                </div>
            </div>
        </div>
    </div>

    <div class="row content pe-3 mt-3" style="margin-top: 150px">
        <div class="col-12 col-sm-4 control card">
            <form action="product" method="post" class="card-body p-3">
                <h3 class="text-secondary text-center mb-3">
                    Add Product
                </h3>

                <div class="form-group">
                    <label for="name">Product's Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
                </div>

                <div class="form-group">
                    <label for="price">Product's Price</label>
                    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
                </div>

                <button type="submit" class="btn btn-success mt-3">Add Product</button>
                <% if (request.getAttribute("message") != null) { %>
                <div class='<%= "alert mt-3 " + "alert-" + request.getAttribute("type") %>' role="alert">
                    <%= request.getAttribute("message") %>
                </div>
                <% } %>
            </form>
        </div>

        <div class="col-12 col-sm-8">
            <div class="card">
                <h3 class="card-header text-success " style="background-color: transparent">Product Available</h3>
                <table class="w-100">

                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <%
                        if (products != null) {
                            for (Product product : products) { %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td class="text-primary"><%= product.getName() %></td>
                        <td><%= "$" + product.getPrice() %></td>
                        <td>
                            <a href="product?action=del&id=<%= product.getId() %>" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>