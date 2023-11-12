<%--
  Created by IntelliJ IDEA.
  User: huytr
  Date: 07/11/2023
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product form</title>
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
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Spring MVC 5 + Hibernate 5 + JSP + MySQL
            Example</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Customer</div>
            </div>
            <div class="panel-body">
                <form:form action="saveProduct" cssClass="form-horizontal"
                           method="post" modelAttribute="product">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Product name</label>
                        <div class="col-md-9">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-md-3 control-label">Category</label>
                        <div class="col-md-9">
                            <form:select path="category" cssClass="form-control">
                                <form:option value="shoes" label="Shoes" />
                                <form:option value="sandals" label="Sandals" />
                                <form:option value="accessories" label="Accessories" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-md-3 control-label">Price (VND)</label>
                        <div class="col-md-9">
                            <form:input path="price" cssClass="form-control" pattern="[0-9]+(\.[0-9]+)?" title="Please enter a positive number" />
                            VND
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="brand" class="col-md-3 control-label">Brand</label>
                        <div class="col-md-9">
                            <form:input path="brand" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="color" class="col-md-3 control-label">Color</label>
                        <div class="col-md-9">
                            <form:input path="color" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
