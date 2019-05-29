<%-- 
    Document   : editEvents
    Created on : 10-05-2019, 11:55:32
    Author     : 56974
--%>

<%@page import="com.mycompany.Modelo.Persona"%>
<%@page import="com.mycompany.ModeloDAO.PersonaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.Modelo.Vacaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ModeloDAO.vacacionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-9">

            <h1 class="m-3 mb-5">Control de dias libres </h1>

            <table border="1" class="table table-striped table-hover text-nowrap" id="example">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>TITULO</th>
                        <th>INICIO</th>
                        <th>FIN</th>
                        <th>USUARIO</th>
                        <th>GESTIONAR</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO daoP = new PersonaDAO();
                    int idP = Integer.parseInt(request.getParameter("id"));
                    Persona per = daoP.list(idP);
                %>



                <%                   
                    vacacionesDAO dao = new vacacionesDAO();
                    List<Vacaciones> list = dao.listar(idP);
                    Iterator<Vacaciones> iter = list.iterator();
                    Vacaciones vac = null;
                    while (iter.hasNext()) {
                        vac = iter.next();
                %>

                <tbody>
                    <tr>
                        <td><%=  vac.getVacaciones_id()%></td>
                        <td><%=  vac.getVacaciones_titulo()%></td>
                        <td><%=  vac.getVacaciones_inicio()%></td>
                        <td><%=  vac.getVacaciones_fin()%></td>




                        <td><%  out.print(per.getUsuario_nombre() + per.getUsuario_apellido()); %></td>


                        <td>
                            <div class="inline"> <a  href="vacaciones?accion=eliminar&id=<%= idP%>&idVac=<%=vac.getVacaciones_id() %>" class="btn btn-danger m-1" ><i  class="fas fa-trash-alt text-white"></i></a>   </div>
                            <div class="inline"> <a  href="vacaciones?accion=changeEvents&id=<%=idP%>&idVac=<%=vac.getVacaciones_id() %>" class="btn btn-warning m-1" ><i  class<i class="fas fa-edit text-white"></i></a>   </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

    </div>
</div>


</div>

</div>

</div>

</body>
</html>