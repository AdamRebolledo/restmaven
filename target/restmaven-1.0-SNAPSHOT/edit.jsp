<%-- 
    Document   : edit
    Created on : 30-04-2019, 13:08:07
    Author     : 56974
--%>

<%@page import="com.mycompany.ModeloDAO.PersonaDAO"%>
<%@page import="com.mycompany.Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="js/validate.js"></script>
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

                    <li><a href="#" class="text-white text-decoration-none">VER PERFIL</a></li>
                    <li><a href="../../Login?accion=regresar" class="text-white text-decoration-none">CERRAR SESSION</a></li>
                </ul>
            </div>
        </nav>



        <%
            Persona p = new Persona();
            PersonaDAO dao = new PersonaDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            p = dao.list(id);
        %>


        <div class="container p-5">
            <h1>Editar Usuario</h1>
            <% if (request.getAttribute("errors") != null) {%>
            <script>
                swal("Lamentable!", "<%= request.getAttribute("errors")%>", "error");
            </script>
            <% }%>

            <div class="row">
                <div class="col-md-8">

                    <div class="card card-body bg-light ">
                        <form action="Controlador" method="POST" >

                            <div class="form-group">
                                <input type="hidden" id="run" name="usuario_id" class="form-control"  value="<%= p.getUsuario_id()%>" autofocus >
                            </div>
                            <div class="form-group">
                                <label>RUT:</label>
                                <input type="text" onblur="vacio(this);
                                        checkRut(this);" id="run" name="usuario_rut" class="form-control"  value="<%= p.getUsuario_rut()%>" autofocus >
                            </div>
                            <div class="form-group">
                                <label>Nombre:</label>
                                <input type="text" id="name" onblur="vacio(this);
                                        validateTextField(this);" name="usuario_nombre" class="form-control" value="<%= p.getUsuario_nombre()%>" autofocus >
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                <input type="text" id="name" onblur="vacio(this);
                                        validateTextField(this);" name="usuario_apellido" class="form-control" value="<%= p.getUsuario_apellido()%>" autofocus >
                            </div>

                            <div class="form-group">
                                <label>Telefono</label>
                                <input type="text" id="cell" onblur=" vacio(this);
                                        validateNumPhone(this);" name="usuario_telefono" class="form-control" value="<%= p.getUsuario_telefono()%>" autofocus >
                            </div>

                            <div class="form-group">
                                <label>Correo</label>
                                <input type="text" id="email" onblur="vacio(this);
                                        validateEmail(this);" name="usuario_correo" class="form-control" value="<%= p.getUsuario_correo()%>" autofocus >
                            </div>
                            <div class="form-group">
                                <label>Contraseña</label>
                                <input type="password" onblur="vacio(this);" id="pass" name="usuario_pass" class="form-control" value="<%= p.getUsuario_pass()%>" autofocus >
                            </div>
                            <div class="form-group">
                                <label>Fecha de Nacimiento:</label>
                                <input type="date" onblur="vacio(this);
                                        validateBirthdate(this);" name="usuario_fecha_nacimiento" value="<%= p.getUsuario_fecha_nacimiento()%>"class="form-control"  >
                            </div>
                            <%
                                int disabled = 0;
                                if (session.getAttribute("userTipoRol") == "Usuario") {
                                    disabled = 1;
                                } else {
                                    disabled = 0;
                                }
                            %>
                            <div class="form-group">
                                <label>Fecha de Contrato</label>
                                <input type="date" onblur="vacio(this);validateContract(this);" name="usuario_fecha_ingreso" value="<%= p.getUsuario_fecha_ingreso()%>" class="form-control"  <% if (disabled == 1) {
                                        out.print("disabled='disabled'");
                                    } %> >
                            </div>  
                            <div class="form-group">
                                <input type="checkbox" id="" name="usuario_estatus" value="1" <% if (p.getUsuario_estatus() == 1) {
                                        out.print("checked='checked'");
                                    } %>   <% if (disabled == 1) {
                                            out.print("disabled='disabled'");
                                        } %>> Activo
                            </div>

                            <div class="form-group">
                                <select class="form-control" name="usuario_rol" <% if (disabled == 1) {
                                        out.print("disabled='disabled'");
                                    } %>>
                                    <option value="1" <% if (p.getUsuario_rol() == 1) {
                                            out.print("selected='selected'");
                                        }%>  >Usuario</option>
                                    <option value="2" <% if (p.getUsuario_rol() == 2) {
                                            out.print("selected='selected'");
                                        }%>  >Ejecutivo</option>
                                    <option value="3" <% if (p.getUsuario_rol() == 3) {
                                            out.print("selected='selected'");
                                        }%>  >Administrador</option>
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
