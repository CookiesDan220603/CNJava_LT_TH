<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Free Bootstrap 4 Ecommerce Template</title>
<!-- CSS -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
<link href="<c:url value ="/templates/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

	<!-- header -->
	<%@ include file="header.jsp"%>
	<!-- end header -->

	<!-- content -->
	<div class="container">
		<div class="row">
			<div class="col">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100"
								src="https://dummyimage.com/855x365/55595c/fff"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="https://dummyimage.com/855x365/a30ca3/fff"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="https://dummyimage.com/855x365/1443ff/fff"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-12 col-md-3">
				<div class="card">
					<div class="card-header bg-success text-white text-uppercase">
						<i class="fa fa-heart"></i> Top product
					</div>
					
					<c:forEach items = "${listTop1BestSellerAndNew}" var = "p">
					<img class="img-fluid border-0"
						src="${p.imageLink} }"
						alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title text-center">
							<a href="product.html" title="View Product"> ${p.productName}</a>
						</h4>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${p.price} $</p>
							</div>
							<div class="col">
								<a href="product.html" class="btn btn-success btn-block">View</a>
							</div>
						</div>
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-3">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-star"></i> Last products
					</div>
					<div class="card-body">
						<div class="row">

							<c:forEach items = "${listTop4Product}" var = "p">
								<div class="col-sm">
									<div class="card">
										<img class="card-img-top"
											src="${p.imageLink}"
											alt="Card image cap">
										<div class="card-body">
											<h4 class="card-title">
												<a href="product.html" title="View Product">${p.productName}</a>
											</h4>
											<p class="card-text">${p.description}</p>
											<div class="row">
												<div class="col">
													<p class="btn btn-danger btn-block"> ${p.price} $</p>
												</div>
												<div class="col">
													<a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
														
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-3 mb-4">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-trophy"></i> Best products
					</div>
					<div class="card-body">
						<div class="row">
						
							<c:forEach items = "${listTop4BestSeller}" var = "p">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top"
										src="${p.imageLink}"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">
											<a href="product.html" title="View Product">${p.productName}</a>
										</h4>
										<p class="card-text">${p.description}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${p.price} $</p>
											</div>
											<div class="col">
												<a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>	
																		
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end content -->

	<!-- footer -->
	<%@ include file="footer.jsp"%>
	<!-- end footer -->

	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>
