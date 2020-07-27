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
  <h2 class="text-left">Registrar: Centro de atenci�n</h2>
  <form class=form-horizontal action=/action_page.php>
    <div class=form-group>
      <label class="control-label col-sm-2" for=codigo_centro>C�digo del centro:</label>
      <div class=col-sm-6>
        <input type="text" class=form-control id=codigo_centro placeholder="C�digo" name=codigo_centro>
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=nombre>Nombre:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=nombre placeholder="Nombre del centro" name=nombre>
      </div>
      </div>
      <div class=form-group>
      <label class="control-label col-sm-2" for=ubicacion>Ubicaci�n:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=ubicacion placeholder="Lugar donde est� ubicado" name=ubicacion>
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=capacidad>Capacidad:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=capacidad placeholder="Capacidad m�xima" name=capacidad>
      </div>
    </div>
    <div class=form-group>
      <label class="control-label col-sm-2" for=tipo>Tipo:</label>
      <div class=col-sm-6>          
        <input type="text" class=form-control id=tipo placeholder="Tipo de centro(Hospital, Cl�nica, Ebais...)" name=tipo>
      </div>
    </div>  
    <div class=form-group>        
      <div class="col-sm-offset-2 col-sm-10">
        <button type=Guardar class="btn btn-lg btn-primary">Guardar</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>