<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-5">
				<h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
				<form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light"
					method="post" action="LoginServlert">
					<div class="form-group">
						<label for="username">Username</label> <input id="username"
							type="text" class="form-control" placeholder="Username"
							name="username">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input id="password"
							type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
					<div class="form-group">
						<button class="btn btn-success px-5">Login</button>
					</div>
					<div class="form-group">
						<p>
							Forgot password? <a href="#">Click here</a>
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>