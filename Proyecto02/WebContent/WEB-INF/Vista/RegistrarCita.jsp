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
		<h2 class="text-left">Register appointment</h2>
		<form class=form-horizontal action=patient?action=enterapp method="post">
			
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
					<select class="form-control" id="estado" name= estado>
						<option value="RE">Registered</option>
						<option value="CAP">Cancelled by patient</option>
						<option value="CECA">Cancelada por centro médico</option>
						<option value="ASIG">Asignada</option>
						<option value="REA">Realizada</option>
					</select>
				</div>
			</div>
			<div class=form-group>
				<label class="control-label col-sm-2" for=code>Center:</label>
				<div class=col-sm-6>
				<select class="form-control" name="center" id="center" >
					<c:forEach var="articulo" items="${list}">
					8/+
				    <option value="${articulo.getId()}">${articulo.getName()}</option>
				
				    </c:forEach>
				  </select>
			</div>
			<div class=form-group>
				<div class="col-sm-offset-2 col-sm-10">
					<button type=Guardar class="btn btn-lg btn-primary">Submit</button>
				</div>
			</div>
			</div>
		</form>
	</div>
</body>
</html>