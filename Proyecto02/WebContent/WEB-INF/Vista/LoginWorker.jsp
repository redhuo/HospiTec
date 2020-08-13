<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap-3.3.7/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/bootstrap-responsive.css" rel="stylesheet">
</head>
<title>HospiTec</title>
</head>

<link
	href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="login?action=patient">Patient</a>
</nav>
<body>

	<div class="container register-form">
		<h2 class="text-left">Please sign in</h2>
		<form class=form-horizontal action=/action_page.php>
			<div class=form-group>
				<label for="inputEmail" class="control-label col-sm-2">Email
					address</label>
				<div class=col-sm-6>
					<input type="email" id="inputEmail" class="form-control">
				</div>
			</div>
			<div class=form-group>
				<label for="inputPassword" class="control-label col-sm-2">Password</label>
				<div class=col-sm-6>
					<input type="password" id="inputPassword" class="form-control">
				</div>
			</div>
			<div class=form-group>
				<label for=tipo class="control-label col-sm-2">Type</label>
				<div class=col-sm-6>
					<input type="password" id="tipo" class="form-control">
				</div>
			</div>
			<div class="checkbox">

				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<div class = "row">
			<button class="btn btn-lg btn-primary type="submit">Sign in</button>
			<a href="worker?action=worker" class="btn btn-primary stretched-link">Register</a>
			</div>
		</form>

	</div>
	<!-- /container -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap-3.3.7/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>