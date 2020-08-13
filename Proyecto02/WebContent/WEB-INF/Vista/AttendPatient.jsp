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
<body>
<link
	href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hospitec</a>
    </div>
    <ul class="nav navbar-nav">

       <li><a href="#">Attend Apointment</a></li>
      <li><a href="#">View Appointments</a></li>
      <li><a href="#">Schedule Appointment</a></li>
        <li><a href="#">Sign out</a></li>
    </ul>
  </div>
</nav>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<table border="1" width="100%">
		<tr>
		 <td> ID</td>
		 <td> DAY</td>
		 <td> Status</td>
		
		 <td colspan=2>Actions</td>
		</tr>
		<c:forEach var="articulo" items="${list}">
			<tr>
				<td><c:out value="${articulo.getId()}"/></td>
				<td><c:out value="${articulo.getDay()}"/></td>
				<td><c:out value="${articulo.getStatus()}"/></td>
				<td><form action="worker?action=attendapp2" method="post">
    			<button type="submit" class="btn-link" value="${articulo.getId()}" name=attend >Attend</button>
				</form></td>
				
				
				
						
			</tr>
		</c:forEach>
	</table>


</body>
</html>