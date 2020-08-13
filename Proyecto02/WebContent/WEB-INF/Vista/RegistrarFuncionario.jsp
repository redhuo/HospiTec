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
		<h2 class="text-left">Register worker</h2>
		<form class=form-horizontal action=worker?action=enterworker method=post>
			<div class=form-group>
				<label class="control-label col-sm-2" for=ide>Id:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=id name=id>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=nombre>Name:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=nombre name=nombre>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=apellido1>first
					last name:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=apellido1 name=apellido1>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=apellido2>second
					last name:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=apellido2 name=apellido2>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=fecha>Entry date:</label>
				<div class=col-sm-6>
					<input type="date" class=form-control id=fecha name=fecha value=""
						min="1900-01-01" max="2020-12-31">
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=residencia>Worker Type:</label>
				<div class=col-sm-6>
					<select class="form-control" id="type" name= type>
						<option value="Doctor">Doctor</option>
						<option value="Secretary">Secretary</option>
						<option value="Nurse">Nurse</option>
					</select>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=code>Center:</label>
				<div class=col-sm-6>
				<select class="form-control" name="center" id="center" >
					<c:forEach var="articulo" items="${list}">
					
				    <option value="${articulo.getId()}">${articulo.getName()}</option>
				
				    </c:forEach>
				  </select>
			</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=area>Area:</label>
				<div class=col-sm-6>
				<select class="form-control" name="area" id="area" >
					<c:forEach var="articulo2" items="${list2}">
				    <option value="${articulo2.getCode()}">${articulo2.getName()}</option>
				
				    </c:forEach>
				  </select>
			</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=usuario>Username:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=usuario name=usuario>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=usuario>Password:</label>
				<div class=col-sm-6>
					<input type="text" class=form-control id=password name=password>
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