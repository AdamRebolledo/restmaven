/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controlador;

import com.mycompany.Modelo.Persona;
import com.mycompany.ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 56974
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar = "View/Persona/listar.jsp";
    String add = "View/Persona/add.jsp";
    String edit = "View/Persona/edit.jsp";
    String list = "View/Persona/listar.jsp";
    String index = "index.jsp";
    String menuPrincipal = "menuprincipal.jsp";
    String addEvent = "addEvents.jsp";
    String viewEvents = "viewEvents.jsp";

    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("listar")) {
            acceso = list;
        } else if (action.equalsIgnoreCase("editar")) {

            acceso = edit;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));
            dao.eliminar(usuarioId);
            acceso = list;
        } else if (action.equalsIgnoreCase("addEvent")) {
            acceso = addEvent;
        } else if (action.equalsIgnoreCase("viewEvents")) {

            acceso = viewEvents;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("controlador editar");
        int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));

        System.out.println(usuarioId);

        String usuarioRut = request.getParameter("usuario_rut");
        String usuarioNombre = request.getParameter("usuario_nombre");

        System.out.println(usuarioNombre);
        String usuarioApellido = request.getParameter("usuario_apellido");
        String usuarioTelefono = request.getParameter("usuario_telefono");
        String usuarioCorreo = request.getParameter("usuario_correo");
        String usuarioPass = request.getParameter("usuario_pass");
        String fechaNacimiento = request.getParameter("usuario_fecha_nacimiento");
        String fechaIngreso = request.getParameter("usuario_fecha_ingreso");
        int usuarioEstatus = Integer.parseInt(request.getParameter("usuario_estatus"));
        int usuarioRol = Integer.parseInt(request.getParameter("usuario_rol"));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ts = null;
        try {
            ts = df.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }

        DateFormat dfI = new SimpleDateFormat("yyyy-MM-dd");
        Date tsI = null;
        try {
            tsI = dfI.parse(fechaIngreso);
        } catch (ParseException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (usuarioRut != null) {

            p.setUsuario_id(usuarioId);
            p.setUsuario_rut(usuarioRut);
            p.setUsuario_nombre(usuarioNombre);
            p.setUsuario_apellido(usuarioApellido);
            p.setUsuario_telefono(usuarioTelefono);
            p.setUsuario_correo(usuarioCorreo);
            p.setUsuario_pass(usuarioPass);
            p.setUsuario_fecha_nacimiento(ts);
            p.setUsuario_fecha_ingreso(tsI);
            p.setUsuario_estatus(usuarioEstatus);
            p.setUsuario_rol(usuarioRol);

            dao.edit(p);

            response.sendRedirect(menuPrincipal);

        }

        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
