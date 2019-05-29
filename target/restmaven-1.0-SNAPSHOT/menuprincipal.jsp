<%-- 
    Document   : menuprincipal
    Created on : 29-04-2019, 14:34:25
    Author     : 56974
--%>


<%@page import="com.mycompany.config.Encript"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ModeloDAO.PersonaDAO"%>
<%@page import="com.mycompany.Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <img src="asset/javaname.png">
            <br><h5>ROL: ${userTipoRol}</h5>

        </div>

        <div class="col-md-8">


            <div class="container">
                <div class="row">
                    <div class="col-md-9">

                        <h1 class="m-3 mb-5">Integrantes del equipo</h1>
                        <table border="1" class="table table-striped table-hover text-nowrap" id="example">
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
                               Encript claves =  new Encript();
                               String add = "add";
                                String accionURL = claves.Encriptar(add);
                                if (session.getAttribute("userTipoRol") == "Administrador"
                                        || session.getAttribute("userTipoRol") == "Ejecutivo") {

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

                                        <!-- div style="width: 220px" -->
                                        <div>
                                            <div class="inline">  <a  href="Login?accion=editar&id=<%= per.getUsuario_id()%>" class="btn btn-warning  m-1" ><i  class="fas fa-edit text-white"></i></a> </div>

                                            <%
                                                if (session.getAttribute("userTipoRol") == "Administrador") {
                                            %>
                                            <div class="inline"> <a  href="Login?accion=eliminar&id=<%= per.getUsuario_id()%>" class="btn btn-danger m-1" ><i  class="fas fa-trash-alt text-white"></i></a> </div>
                                                    <% }%>

                                            <div class="inline"> <a  href="Login?accion=visualizar&id=<%= per.getUsuario_id()%>" class="btn btn-info m-1" ><i  class="fas fa-user text-white"></i></a>   </div>
                                            <div class="inline"> <a  href="vacaciones?accion=viewEvents&id=<%= per.getUsuario_id()%>" class="btn btn-dark m-1" ><i  class<i class="fas fa-calendar-alt text-white"></i></a>   </div>
                                            <div class="inline"> <a  href="vacaciones?accion=addEvents&id=<%= per.getUsuario_id()%>" class="btn btn-secondary  m-1" ><i  class<i class="far fa-paper-plane text-white"></i></a>   </div>

                                            <%
                                                if (session.getAttribute("userTipoRol") == "Administrador" || session.getAttribute("userTipoRol") == "Ejecutivo") {
                                            %>
                                            <div class="inline"> <a  href="vacaciones?accion=editEvents&id=<%= per.getUsuario_id()%>" class="btn btn-primary  m-1" ><i  class<i class="fas fa-edit text-white"></i></a>   </div>
                                                    <% } %>
                                        </div>
                                    </td>
                                </tr>
                                <%} %>
                            </tbody>
                        </table>
                        <%
                            if (session.getAttribute("userTipoRol") == "Administrador" || session.getAttribute("userTipoRol") == "Ejecutivo") {
                        %>

                        <a href="Login?accion=add" class="btn btn-info">Agregar Persona</a>
                        <% }%>
                        <% } else { %>

                        <%
                            PersonaDAO dao = new PersonaDAO();
                            int userid = (Integer) session.getAttribute("userId");
                            Persona per = dao.list(userid);
                        %>

                        <tbody>
                            <tr>
                                <td><%= per.getUsuario_id()%></td>
                                <td><%= per.getUsuario_rut()%></td>
                                <td><%= per.getUsuario_nombre()%> <%= per.getUsuario_apellido()%></td>
                                <td><%= per.getUsuario_correo()%></td>
                                <td >

                                    <!-- div style="width: 220px" -->
                                    <div>
                                        <div class="inline">  <a  href="Login?accion=editar&id=<%= per.getUsuario_id()%>" class="btn btn-warning  m-1" ><i  class="fas fa-edit text-white"></i></a> </div>

                                        <%
                                            if (session.getAttribute("userTipoRol") == "Administrador") {
                                        %>
                                        <div class="inline"> <a  href="Login?accion=eliminar&id=<%= per.getUsuario_id()%>" class="btn btn-danger m-1" ><i  class="fas fa-trash-alt text-white"></i></a> </div>
                                                <% }%>

                                        <div class="inline"> <a  href="Login?accion=visualizar&id=<%= per.getUsuario_id()%>" class="btn btn-info m-1" ><i  class="fas fa-user text-white"></i></a>   </div>
                                        <div class="inline"> <a  href="vacaciones?accion=viewEvents&id=<%= per.getUsuario_id()%>" class="btn btn-dark m-1" ><i  class<i class="fas fa-calendar-alt text-white"></i></a>   </div>
                                        <div class="inline"> <a  href="vacaciones?accion=addEvents&id=<%= per.getUsuario_id()%>" class="btn btn-secondary  m-1" ><i  class<i class="far fa-paper-plane text-white"></i></a>   </div>

                                        <%
                                            if (session.getAttribute("userTipoRol") == "Administrador" || session.getAttribute("userTipoRol") == "Ejecutivo") {
                                        %>
                                        <div class="inline"> <a  href="vacaciones?accion=editEvents&id=<%= per.getUsuario_id()%>" class="btn btn-primary  m-1" ><i  class<i class="fas fa-edit text-white"></i></a>   </div>
                                                <% } %>
                                    </div>
                                </td>
                            </tr>

                        </tbody>
                        </table>
                        <%

                            if (session.getAttribute(
                                    "userTipoRol") == "Administrador" || session.getAttribute("userTipoRol") == "Ejecutivo") {
                        %>

                        <a href="Login?accion=<%= accionURL %>" class="btn btn-info">Agregar Persona</a>
                        <% }%>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
