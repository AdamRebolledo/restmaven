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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 56974
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // links
    String registro = "registrousuario.jsp";
    String menuPrincipal = "menuprincipal.jsp";
    String usuarioinvalido = "usuarioinvalido.jsp";
    String index = "index.jsp";
    String edit = "edit.jsp";
    String volverIndex = "index.jsp";
    String visualizar = "visualizar.jsp";
    String perfil = "perfil.jsp";
    String add = "add.jsp";
    String menuUser = "menuser.jsp";
    //modelaje
    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();

//session
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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

        if (action.equalsIgnoreCase("registro")) {
            acceso = registro;
        }
        if (action.equalsIgnoreCase("index")) {
            acceso = index;
        }
        if (action.equalsIgnoreCase("editar")) {
            acceso = edit;
        }
        if (action.equalsIgnoreCase("visualizar")) {
            acceso = visualizar;
        }
        if (action.equalsIgnoreCase("perfil")) {
            acceso = perfil;
        }
        if (action.equalsIgnoreCase("add")) {
            acceso = add;
        }
        if (action.equalsIgnoreCase("regresar")) {
            HttpSession session = request.getSession(false);
            acceso = index;
        }

        if (action.equalsIgnoreCase("eliminar")) {
            int usuarioId = Integer.parseInt(request.getParameter("id"));
            p.setUsuario_id(usuarioId);
            dao.eliminar(usuarioId);
            acceso = menuPrincipal;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        System.out.println(request.getContextPath());
        System.out.println();
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
        //recepcion de variables para autenticar

        String usuarioCorreo = request.getParameter("usuario_correo");
        String usuarioPass = request.getParameter("usuario_pass");
        HttpSession session = request.getSession(true);
        p = dao.autenticar(usuarioCorreo, usuarioPass);

        System.out.println(p.getUsuario_correo() + " base" + p.getUsuario_pass() + "rol= " + p.getUsuario_rol());

        if (p.getUsuario_pass() != null) {
            System.out.println("autorizado");
            session.setAttribute("userId", p.getUsuario_id());
            session.setAttribute("userDni", p.getUsuario_rut());
            session.setAttribute("userName", p.getUsuario_nombre());
            session.setAttribute("userLastname", p.getUsuario_apellido());
            session.setAttribute("userPhone", p.getUsuario_telefono());
            session.setAttribute("userEmail", p.getUsuario_correo());
            session.setAttribute("userPass", p.getUsuario_pass());
            session.setAttribute("userBirthday", p.getUsuario_fecha_nacimiento());
            session.setAttribute("userStatus", p.getUsuario_estatus());
            session.setAttribute("userRol", p.getUsuario_rol());

            if (p.getUsuario_rol() == 1) {
                session.setAttribute("userTipoRol", "Usuario");
            } else if (p.getUsuario_rol() == 2) {
                session.setAttribute("userTipoRol", "Ejecutivo");
            } else if (p.getUsuario_rol() == 3) {
                session.setAttribute("userTipoRol", "Administrador");
            }
               
           response.sendRedirect(menuPrincipal);
 
        } else {
            System.out.println("no autorizado");
            response.sendRedirect(usuarioinvalido);

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
