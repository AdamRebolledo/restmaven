<%-- 
    Document   : registrousuario
    Created on : 26-04-2019, 17:52:33
    Author     : 56974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    
    <body>
            <%@include file="header.jsp" %>

        <div class="container p-5">
            <h1>Registro de Usuario</h1>
            <div class="row">
                <div class="col-md-8">

                    <div class="card card-body bg-light ">
                        <form action="Insertar" method="POST" >
                          
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
                            
                            <input type="submit" class="btn btn-success"  value="Registrar">
                            <a href="index.jsp"> Regresar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
