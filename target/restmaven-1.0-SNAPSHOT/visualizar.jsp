<%-- 
    Document   : visualizar
    Created on : 02-05-2019, 9:45:22
    Author     : 56974
--%>

<%@page import="com.mycompany.ModeloDAO.PersonaDAO"%>
<%@page import="com.mycompany.Modelo.Persona"%>
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
                    
                      <%
    Persona p= new Persona();
    PersonaDAO dao = new PersonaDAO();
    int id = Integer.parseInt(request.getParameter("id"));
    p = dao.list(id);
        %>
                    
                     <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img style="width:60%;" src="asset/perfil2.png">
                    <br><h1>ROL: ${userTipoRol}</h1>
                </div>

                <div class="col-md-8">


                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">

                                <h1 class="m-3 mb-5">ID: <%= p.getUsuario_id()%></h1>
                                 <h1 class="m-3 mb-5">RUT: <%= p.getUsuario_rut()%></h1>
                                  <h1 class="m-3 mb-5">NOMBRE: <%= p.getUsuario_nombre()%></h1>
                                   <h1 class="m-3 mb-5">APELLIDO: <%= p.getUsuario_apellido()%></h1>
                                    <h1 class="m-3 mb-5">TELEFONO: <%= p.getUsuario_telefono()%></h1>
                                     <h1 class="m-3 mb-5">CORREO: <%= p.getUsuario_correo()%></h1>
                                         <h1 class="m-3 mb-5">FECHA DE NACIMIENTO: <%= p.getUsuario_fecha_nacimiento()%></h1>
                                         

                                


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
