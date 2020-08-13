<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<h2 class="text-left">Register diagnostic</h2>
		<form class=form-horizontal action=worker?action=attendapp3 method="post">
			<div class=form-group>
				<label class="control-label col-sm-2" for=residencia>Level:</label>
				<div class=col-sm-6>
					<select class="form-control" id="estado" name= estado>
						<option value="Mild">Mild</option>
						<option value="Moderate">Moderate</option>
						<option value="Serious">Serious</option>
				
					</select>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=code>Catalogue:</label>
				<div class=col-sm-6>
				<select class="form-control" name="catalogue" id="catalogue" >
					<c:forEach var="articulo" items="${list}">
					
				    <option value="${articulo.getId()}">${articulo.getName()}</option>
				
				    </c:forEach>
				  </select>
			</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=paciente>Patient
					id:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=paciente name=paciente value ="${patientid}">
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=observacion>Observation:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=observacion
						name=observacion>
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