<%-- 
    Document   : changeEvents
    Created on : 10-05-2019, 16:30:29
    Author     : 56974
--%>

<%@page import="com.mycompany.ModeloDAO.vacacionesDAO"%>
<%@page import="com.mycompany.Modelo.Vacaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>


<%
    Vacaciones vac = new Vacaciones();
    vacacionesDAO dao = new vacacionesDAO();
    int idVac = Integer.parseInt(request.getParameter("idVac"));

    vac = dao.list(idVac);
    out.print(vac.getVacaciones_className());
%>
<div class="container p-5">
    <h1>Añadir solicitud de dias libres</h1>
    <div class="row">
        <div class="col-md-8">

            <div class="card card-body bg-light ">
                <form action="editEvento" method="POST" >

                    <div class="form-group">
                        <% int id = Integer.parseInt(request.getParameter("id"));%>
                        <input type="hidden" id="run" name="id" class="form-control" value="<%= id%>" autofocus >
                    </div>
                    <div class="form-group">
                        <input type="hidden" id="run" name="idVac" class="form-control" value="<%= idVac%>" autofocus >
                    </div>
                    <div class="form-group">
                        <input type="text" id="run" name="titulo" onblur="vacio(this);
                                validateTextField(this);" class="form-control" value="<%= vac.getVacaciones_titulo()%>" autofocus >
                        <div class="invalid-feedback">
                            Formato del Titulo invalido o vacio(solo catacteres de texto).
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="date" id="name" name="inicio" onblur="vacio(this); validateDateCurrent(this);"  class="form-control" value="<%= vac.getVacaciones_inicio()%>" autofocus >
                        <div class="invalid-feedback">
                            La fecha ingresada debe ser menor a la fecha actual.
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="date" id="name" name="fin" onblur="vacio(this);
                                compareDates(this.form, this);" class="form-control" value="<%= vac.getVacaciones_fin()%>" autofocus >
                        <div class="invalid-feedback">
                            La fecha ingresada debe ser mayor a la fecha ingresada en el campo anterior.
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="text" id="cell" name="url" onblur="vacio(this);
                                validateTextField(this);"  class="form-control" value="<%= vac.getVacaciones_url()%>" autofocus >
                        <div class="invalid-feedback">
                            Formato del Correo invalido o vacio.
                        </div>
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="className">
                            <option value="1" <% if (vac.getVacaciones_className() == 1) {
                                    out.print("selected='selected'");
                                }%>  >Aprovado</option>
                            <option value="2" <%  if (vac.getVacaciones_className() == 2) {
                                    out.print("selected='selected'");
                                }%> >Rechazado</option>

                        </select>
                    </div>

                    <button type="button" onclick="subEvents(this.form)" class="btn btn-success btn-block"  >Editar Evento</button>

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
