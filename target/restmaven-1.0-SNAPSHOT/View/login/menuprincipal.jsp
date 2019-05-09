<%-- 
    Document   : menuprincipal
    Created on : 29-04-2019, 14:34:25
    Author     : 56974
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
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
    
    <li><a href="#" class="text-white text-decoration-none">VER PERFIL</a></li>
    <li><a href="../../Login?accion=regresar" class="text-white text-decoration-none">CERRAR SESSION</a></li>
  </ul>
</div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img src="../../asset/javaname.png">
                    <br><h1>ROL: ${userTipoRol}</h1>
                </div>

                <div class="col-md-8">


                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">

                                <h1 class="m-3 mb-5">Integrantes del equipo</h1>

                                <table border="1" class="table table-striped table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>ID</th>
                                            <th>RUT</th>
                                            <th>NOMBRES</th>
                                            <th>CORREO</th>
                                            <th>ACCIONES</th>
                                        </tr>
                                    </thead>

                                    <%
                                        PersonaDAO dao = new PersonaDAO();
                                        List<Persona> list = dao.listar();
                                        Iterator<Persona> iter = list.iterator();
                                        Persona per = null;
                                        while (iter.hasNext()) {
                                            per = iter.next();

                                    %>

                                    <tbody>
                                        <tr>
                                            <td><%= per.getUsuario_id()%></td>
                                            <td><%= per.getUsuario_rut()%></td>
                                            <td><%= per.getUsuario_nombre()%> <%= per.getUsuario_apellido()%></td>
                                            <td><%= per.getUsuario_correo()%></td>
                                            <td >

                                                <div style="width: 200px">
                                                <div style="display: inline-block">  <a  href="../../Login?accion=editar&id=<%= per.getUsuario_id()%>" class="btn btn-warning  m-1" ><i  class="fas fa-edit text-white"></i></a> </div>
                                                       <div style="display: inline-block"> <a  href="../../Login?accion=eliminar&id=<%= per.getUsuario_id()%>" class="btn btn-danger m-1" ><i  class="fas fa-trash-alt text-white"></i></a> </div>
                                                       <div style="display: inline-block"> <a  href="../../Login?accion=visualizar&id=<%= per.getUsuario_id()%>" class="btn btn-info m-1" ><i  class="fas fa-user text-white"></i></a>   </div>
                                            </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>

                                <a href="Controlador?accion=add" class="btn btn-info">Agregar Persona</a>

                            </div>

                        </div>
                    </div>


                </div>

            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
