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
<body>
	<div class="container register-form">
		<h2 class="text-left">Register appointment</h2>
		<form class=form-horizontal action=/action_page.php>
			<div class=form-group>
				<label class="control-label col-sm-2" for=ide>Id:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=ide name=ide>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=area>Area:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=area name=area>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=fecha>Date:</label>
				<div class=col-sm-6>
					<input type="date" class=form-control id=fecha name=fecha value=""
						min="1900-01-01" max="2020-12-31">
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=hora>Hour:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=hora name=hora>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=residencia>Status:</label>
				<div class=col-sm-6>
					<select class="form-control" id="estado">
						<option value="RE">Registrada</option>
						<option value="CAP">Cancelada por paciente</option>
						<option value="CECA">Cancelada por centro m�dico</option>
						<option value="ASIG">Asignada</option>
						<option value="REA">Realizada</option>
					</select>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=code>Center code:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=code name=code>
				</div>
			</div>
			<div class=form-group>
				<div class="col-sm-offset-2 col-sm-10">
					<button type=Guardar class="btn btn-lg btn-primary">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>