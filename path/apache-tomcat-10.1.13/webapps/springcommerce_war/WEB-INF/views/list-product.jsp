<%--
  Created by IntelliJ IDEA.
  User: huytr
  Date: 07/11/2023
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Product</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
            type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>CRM - Customer Relationship Manager</h2>
        <hr />

        <input type="button" value="Add Product"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Product List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Brand</th>
                        <th>Color</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempPRoduct" items="${products}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink">
                            <value>/product/updateForm</value>
                            <c:param name="customerId" value="${tempProduct.id}" />
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink">
                            <value>/product/delete</value>
                            <c:param name="customerId" value="${tempProduct.id}" />
                        </c:url>

                        <tr>
                            <td>${tempProduct.name}</td>
                            <td>${tempProduct.category}</td>
                            <td>${tempProduct.price}</td>
                            <td>${tempProduct.brand}</td>
                            <td>${tempProduct.color}</td>

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this product ?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>
