<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap-3.3.7/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
</head>
    <title>HospiTec</title>
  </head>
  <link href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="container register-form">
  <h2 class="text-left">Register patient</h2>
  <form class=form-horizontal action=/action_page.php>
    <div class=form-group>
      <label class="control-label col-sm-2" for=ide>Id:</label>
      <div class=col-sm-6>
        <input type="text" class=form-control id=ide name=ide>
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=nombre>Name:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=nombre name=nombre>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=apellido1>first last name:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=apellido1 name=apellido1>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=apellido2>Second last name:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=apellido2 name=apellido2>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=correo>Email:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=correo name=correo>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=fecha>Date of birth:</label>
      <div class=col-sm-6>          
        <input type="date" class=form-control id=fecha name=fecha value=""  min="1900-01-01" max="2020-12-31"> 
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=tipo_sangre>Blood type:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=tipo_sangre name=tipo_sangre>
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=nacionalidad>Nationality:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=nacionalidad name=nacionalidad>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=residencia>State:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=residencia name=residencia>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=usuario>Username:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=usuario name=usuario>
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