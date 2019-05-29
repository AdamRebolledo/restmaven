<%-- 
    Document   : index
    Created on : 26-04-2019, 17:27:42
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

            <h1>Ingresar al listado de tareas</h1>
            
            <% if (request.getAttribute("errors") != null) {%>
            <script>
                swal("Lamentable!", "<%= request.getAttribute("errors")%>", "error");
            </script>
            <% }%>
            
            <div class="row">
                <div class="col-md-8">

                    <div class="card card-body bg-light ">
                        <form action="Login" method="POST" >
                            <div class="form-group">
                                <input type="text" id="email" onblur="vacio(this); validateEmail(this);" name="usuario_correo" class="form-control" placeholder="Ingresa tu Correo Electronico" autofocus >
                            </div>
                            <div class="form-group">
                                <input type="password" id="pass" onblur="vacio(this);" name="usuario_pass" class="form-control" placeholder="Ingresa tu Contraseña" autofocus >
                            </div>

                            <input type="submit" class="btn btn-info"  value="Ingresar"><a href="Login?accion=registro"> Ir al Registro</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
