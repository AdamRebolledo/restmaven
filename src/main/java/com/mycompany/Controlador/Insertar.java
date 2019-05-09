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
import static java.lang.System.out;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Parser;

/**
 *
 * @author 56974
 */
@WebServlet(name = "Insertar", urlPatterns = {"/Insertar"})
public class Insertar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar = "listar.jsp";
    String add = "add.jsp";
    String edit = "edit.jsp";
    String list = "listar.jsp";
    String index = "index.jsp";

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
            out.println("<title>Servlet Insertar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Insertar at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

        String usuarioRut = request.getParameter("usuario_rut");
        String usuarioNombre = request.getParameter("usuario_nombre");
        String usuarioApellido = request.getParameter("usuario_apellido");
        String usuarioTelefono = request.getParameter("usuario_telefono");
        String usuarioCorreo = request.getParameter("usuario_correo");
        String usuarioPass = request.getParameter("usuario_pass");
        String fechaNacimiento = request.getParameter("usuario_fecha_nacimiento");
        int usuarioEstatus = Integer.parseInt(request.getParameter("usuario_estatus"));
        int usuarioRol = Integer.parseInt(request.getParameter("usuario_rol"));
        
        
        System.out.println("controlador insertar para analizar rol = "+usuarioRol);
   
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date ts = null;
        try {
          ts = df.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (usuarioRut != null) {

            p.setUsuario_rut(usuarioRut);
            p.setUsuario_nombre(usuarioNombre);
            p.setUsuario_apellido(usuarioApellido);
            p.setUsuario_telefono(usuarioTelefono);
            p.setUsuario_correo(usuarioCorreo);
            p.setUsuario_pass(usuarioPass);
            p.setUsuario_fecha_nacimiento(ts);
            p.setUsuario_estatus(usuarioEstatus);
            p.setUsuario_rol(usuarioRol);

            dao.add(p);
            
            
            response.sendRedirect(index);

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
