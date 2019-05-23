<%-- 
    Document   : add_event
    Created on : Jul 10, 2018, 8:52:10 PM
    Author     : Saroj
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.mycompany.ModeloDAO.PersonaDAO"%>
<%@page import="com.mycompany.Modelo.Persona"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="navbar.jsp" %>

<div class="container p-5">

    <div class="row">
        <div class="col-md-7">
            <h3>Añadir solicitud de dias libres</h3>
         
            <div class="card card-body bg-light ">
                <form action="vacaciones" method="POST" >

                    <div class="form-group">
                        <% int id = Integer.parseInt(request.getParameter("id"));%>
                        <input type="hidden" id="run" name="id" class="form-control" value="<%= id%>" autofocus >
                    </div>

                    <div class="form-group">
                        <input type="text" id="run"onblur="vacio(this);
                                validateTextField(this);"  name="titulo" class="form-control" placeholder="Ingresa el titulo de la solicitud" autofocus >
                        <div class="invalid-feedback">
                            Formato del Titulo invalido o vacio(solo catacteres de texto).
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="date" id="name" onblur=" vacio(this); validateDateCurrent(this)" name="inicio" class="form-control" autofocus >
                        <div class="invalid-feedback">
                            La fecha ingresada debe ser menor a la fecha actual.
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="date" id="name" onblur=" vacio(this); compareDates(this.form, this)" name="fin" class="form-control" autofocus >
                        <div class="invalid-feedback">
                           La fecha ingresada debe ser mayor a la fecha ingresada en el campo anterior.
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="text" id="cell" name="url" onblur="vacio(this);
                                validateTextField(this);"class="form-control" placeholder="Ingresa algun link de tu evento" autofocus >
                        <div class="invalid-feedback">
                            Formato del Correo invalido o vacio.
                        </div>
                    </div>

                    <button type="button" onclick="subEvents(this.form )" class="btn btn-success btn-block" >Agregar Evento</button>

                </form>
            </div>
        </div>


        <div class="col-md-4">
            <h3>Mi Info!</h3>
            <div class="card card-default">
                <div class="card-body bg-light">
                    <%
                        Persona p = new Persona();
                        PersonaDAO dao = new PersonaDAO();
                        int idss = Integer.parseInt(request.getParameter("id"));
                        p = dao.list(idss);

                        if (p.getUsuario_fecha_ingreso() != null) {

                            String ingreso = p.getUsuario_fecha_ingreso().toString();

                            Date fechaFinal = new Date();

                            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

                            formateador.format(fechaFinal);

                            int dias = (int) ((fechaFinal.getTime() - p.getUsuario_fecha_ingreso().getTime()) / 86400000);

                            int meses = dias / 30;

                            int cobrados = (Integer) request.getAttribute("cobrado");

                            double diasDisponibles = (meses * 1.25) - cobrados;


                    %>
                    <h6>FECHA DEL CONTRATO: <%= ingreso%></h6>
                    <h6>DIAS COBRADOS: <%= cobrados%></h6>
                    <h6>DIAS DISPONIBLES :<%= diasDisponibles%> </h6>
                    <% } else {%>
                    <h6>NO TIENES CONTRATO PARA SOLICITAR DIAS</h6>
                    <%  }%>

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
