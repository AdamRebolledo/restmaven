<%-- 
    Document   : index
    Created on : Jul 10, 2018, 7:31:05 PM
    Author     : Saroj
--%>


<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.Modelo.Vacaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ModeloDAO.vacacionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>Menu Principal</title>
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"/>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link href='css/fullcalendar.min.css' rel='stylesheet' />
        <link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
        <script src='js/moment.min.js'></script>
        <script src='js/jquery.min.js'></script>
        <script src='js/fullcalendar.min.js'></script>
        <script src="js/idiomaCalendar.js"></script>
        
        <style>
            .aprovado {background-color:#218838; color:#ffffff;}
            .rechazado {background-color: #c82333 ; color:#ffffff;}
            .espera{background-color: #138496 ; color:#ffffff;}
        </style>
        <script>


            $(document).ready(function() {

                $('#calendar').fullCalendar({
                    defaultDate: $('#calendar').fullCalendar('today'),
                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events:${vacaciones}

                });
            });
        </script>


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

        <div class="container"> 
            <div class="row">
                <div id="calendar"  class="col-md-6 m-5" ></div>
                <div class="col-md-4 mt-5">
                    <h3>Estado de solicitud</h3>
                    <div class="card card-default">
                        <div class="card-body bg-light">
                            <a href="#" class="btn btn-danger">Rechazado</a>
                             <a href="#" class="btn btn-info">En espera</a>
                              <a href="#" class="btn btn-success">Aprovado</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                    




            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
