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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.config.Validate;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 56974
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //link
    String menuPrincipal = "menuprincipal.jsp";
    String add = "add.jsp";
    //modelo
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
    Validate validate = new Validate();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add at " + request.getContextPath() + "</h1>");
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

        System.out.println("controlador insertar para analizar rol = " + usuarioRol);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ts = null;
        try {
            ts = df.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean rut = validate.validateRut(usuarioRut);
        boolean name = validate.validateText(usuarioNombre);
        boolean lastName = validate.validateText(usuarioApellido);
        boolean phone = validate.validateNumPhone(usuarioTelefono);
        boolean email = validate.validateEmail(usuarioCorreo);
        boolean Birthdate = validate.validateBirthdate(fechaNacimiento);
        boolean emailUnique = false;
        try {
            emailUnique = dao.duplicateEmail(usuarioCorreo);
        } catch (SQLException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(":::::::::::::::::::::::::::::::::::::" + emailUnique);
        //aviso de error
        if (rut == false
                || name == false
                || lastName == false
                || phone == false
                || email == false
                || Birthdate == false
                || emailUnique == false) {

            StringBuilder errors = new StringBuilder();
            if (rut == false) {
                errors.append("Rut invalido\\n");
            }
            if (name == false) {
                errors.append("Nombre invalido\\n");
            }
            if (lastName == false) {
                errors.append("Apellido invalido\\n");
            }
            if (phone == false) {
                errors.append("Telefono invalido\\n");
            }
            if (email == false) {
                errors.append("Correo invalido\\n");
            }
            if (Birthdate == false) {
                errors.append("Fecha invalida\\n");
            }
            if (emailUnique == false) {
                errors.append("El email ingresado ya existe en nuestros registros\\n");
            }

            if (errors.toString().isEmpty()) {

            } else {

                request.setAttribute("errors", errors);
                RequestDispatcher rd = request.getRequestDispatcher(add);
                rd.forward(request, response);
            }

        }

        if (rut == true
                && name == true
                && lastName == true
                && phone == true
                && email == true
                && Birthdate == true
                && emailUnique == true) {

            System.out.println("datos exitentes ::::::::");
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

            response.sendRedirect(menuPrincipal);
        }
        processRequest(request, response);
    }
}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
