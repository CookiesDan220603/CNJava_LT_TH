<%@ page import="entity.Product"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<h1 style="text-align: center">
		Xin chào <b class="text-primary mt-3"><%=request.getSession().getAttribute("username")%></b>
	</h1>
	<h3 style="text-align: center">
		<a href="/lab5_war_exploded/logout">Logout</a>
	</h3>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="form-horizontal w-100">
					<h2>Thêm sản phẩm</h2>
					<form id="product-form" action="/Lab05/home" method="post">
						<div class="form-group">
							<label for="product-name">Tên sản phẩm:</label> <input
								type="text" id="product-name" name="name" required>
						</div>

						<div class="form-group">
							<label for="product-price">Giá sản phẩm:</label> <input
								type="number" id="product-price" name="price" required>
							<br>
							<p style="color: red; font-size: 12px"><%=request.getAttribute("errorMessage") != null ? (String) request.getAttribute("errorMessage") : ""%></p>
							<br>
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-warning disabled">Thêm</button>
						</div>
					</form>
				</div>
			</div>
			<!-- Col 1 -->
			<div class="col-md-9 mt-2">
				<div class="list-container">
					<h2>Danh sách sản phẩm</h2>
					<table id="product-list" class="table table-hover mt-4">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên sản phẩm</th>
								<th>Giá sản phẩm</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody id="product-table-body">
							<%
							List<Product> list = (List<Product>) request.getAttribute("list");
							if (list != null) {
								for (Product p : list) {
							%>
							<tr>
								<td><%=p.getId()%></td>
								<td><%=p.getName()%></td>
								<td><%=p.getPrice()%></td>
								<td><a class="btn btn-sm btn-primary" href="?action=del&id=<%=p.getId()%>">Xóa</a></td>
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<!-- col 2-->
		</div>
	</div>
</body>
</html>