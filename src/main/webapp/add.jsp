<%-- 
    Document   : add
    Created on : 02-05-2019, 10:55:09
    Author     : 56974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"/>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand p-3" href="#">My App in Java</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">


                    <li class="nav-item active">
                        <a class="nav-link" href="#">Control de vacaciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Vacaciones </a>
                    </li>

                    <li class="nav-item ml-4">
                        <a class="nav-link" href="#">Welcome: ${userName} ${userLastname}</a>
                    </li>
                </ul>

            </div>
                    <div class="dropdown mx-auto" style="width: 200px;">
  <button class="btn btn-secondary dropdown-toggle mr-5" type="button" data-toggle="dropdown"><i  class="fas fa-bars text-white"></i>
  <span class="caret"></span></button>
  <ul class="dropdown-menu bg-dark mx-auto p-2 ">
    
    <li><a href="Login?accion=perfil" class="text-white text-decoration-none">VER PERFIL</a></li>
    <li><a href="Login?accion=index" class="text-white text-decoration-none">CERRAR SESSION</a></li>
  </ul>
</div>
        </nav>
        
           <div class="container p-5">
            <h1>Registro de Usuario</h1>
            <div class="row">
                <div class="col-md-8">

                    <div class="card card-body bg-light ">
                        <form action="add" method="POST" >
                            <div class="form-group">
                                <input type="text" id="run" name="usuario_rut" class="form-control" placeholder="Ingresa tu Rut" autofocus >
                            </div>
                            <div class="form-group">
                                <input type="text" id="name" name="usuario_nombre" class="form-control" placeholder="Ingresa tu Nombre" autofocus >
                            </div>
                            <div class="form-group">
                                <input type="text" id="name" name="usuario_apellido" class="form-control" placeholder="Ingresa tu Apellido" autofocus >
                            </div>

                            <div class="form-group">
                                <input type="text" id="cell" name="usuario_telefono" class="form-control" placeholder="Ingresa tu numero telefonico" autofocus >
                            </div>

                            <div class="form-group">
                                <input type="text" id="email" name="usuario_correo" class="form-control" placeholder="Ingresa tu Correo Electronico" autofocus >
                            </div>
                            <div class="form-group">
                                <input type="password" id="pass" name="usuario_pass" class="form-control" placeholder="Ingresa tu Contraseña" autofocus >
                            </div>
                            <div class="form-group">
                                <input type="date" name="usuario_fecha_nacimiento" class="form-control"  >
                            </div>
                            <div class="form-group">
                            <input type="checkbox" id="" name="usuario_estatus" value="1"> Activo
                            </div>
                            <div class="form-group">
                                    <select class="form-control" name="usuario_rol">
                                         <option value="1" selected>Usuario</option>
                                         <option value="2">Ejecutivo</option>
                                         <option value="3">Administrador</option>
                                    </select>
                            </div>
                            <input type="submit" class="btn btn-success"  value="Registrar">
                            <a href="index.jsp"> Regresar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
