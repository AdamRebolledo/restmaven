<%-- 
    Document   : navbar
    Created on : 10-05-2019, 10:20:31
    Author     : 56974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"/>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <style>
        .inline{
           display: inline-block;
        }
    </style>
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