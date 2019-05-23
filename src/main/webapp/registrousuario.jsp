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
        <script src="js/validate.js"></script>
    </head>

    <body>
        <%@include file="header.jsp" %>

        <div class="container p-5">
            <h1>Registro de Usuario</h1>

            <% if (request.getAttribute("errors") != null) {%>
            <script>
                swal("Lamentable!", "<%= request.getAttribute("errors")%>", "error");
            </script>
            <% }%>

            <div class="row">
                <div class="col-md-8">

                    <div class="card card-body bg-light ">

                        <form action="Insertar" method="POST"  id="myForm" name="UserForm">

                            <div class="form-group ">

                                <input type="text" id="run" name="usuario_rut" class="form-control" onblur="vacio(this);
                                        checkRut(this);" placeholder="Ingresa tu Rut" autofocus >
                                <div class="invalid-feedback">
                                    Formato de rut invalido o vacio.
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" id="name" name="usuario_nombre" class="form-control" placeholder="Ingresa tu Nombre"  onblur="vacio(this);
                                        validateTextField(this); " autofocus >
                                <div class="invalid-feedback">
                                    Formato del Nombre invalido o vacio.
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" id="name" name="usuario_apellido" class="form-control" placeholder="Ingresa tu Apellido" onblur="vacio(this);
                                        validateTextField(this);
                                        " autofocus >
                                <div class="invalid-feedback">
                                    Formato del Apellido invalido o vacio.
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon3">+(56) </span>
                                    <input type="text" id="cell" name="usuario_telefono" class="form-control" onblur=" vacio(this);
                                            validateNumPhone(this);"  placeholder="Ingresa tu numero telefonico" autofocus aria-describedby="basic-addon3" >
                                    <div class="invalid-feedback">
                                        Telefono invalido.
                                    </div>
                                </div> 
                            </div>

                            <div class="form-group">
                                <input type="email" id="email" name="usuario_correo" onblur="vacio(this); validateEmail(this);" class="form-control" placeholder="Ingresa tu Correo Electronico" autofocus >
                             <div class="invalid-feedback">
                                        Formato del Correo invalido o vacio.
                                    </div>
                            </div>
                            <div class="form-group">
                                <input type="password" id="pass" onblur="vacio(this);" name="usuario_pass" class="form-control" placeholder="Ingresa tu Contraseña" autofocus >
                                    <div class="invalid-feedback">
                                        Formato del Password invalido o vacio.
                                    </div>
                            </div>
                            <div class="form-group">
                                <input type="date" onblur="vacio(this); validateBirthdate(this);" name="usuario_fecha_nacimiento" class="form-control"  >
                             <div class="invalid-feedback">
                                        La Fecha debe ser menor a la fecha actual.
                                    </div>
                            </div>
                            <input type="submit" onclick="sub(this.form);" class="btn btn-success" value="Registrar">
                            <a href="index.jsp"> Regresar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
