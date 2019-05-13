/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controlador;

import com.mycompany.Modelo.Vacaciones;
import com.mycompany.ModeloDAO.vacacionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 56974
 */
@WebServlet(name = "editEvento", urlPatterns = {"/editEvento"})
public class editEvento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Vacaciones p = new Vacaciones();
    vacacionesDAO dao = new vacacionesDAO();
    String menuPrincipal = "menuprincipal.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editEvento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editEvento at " + request.getContextPath() + "</h1>");
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

        int id = Integer.parseInt(request.getParameter("id"));
        int idVac = Integer.parseInt(request.getParameter("idVac"));
        String titulo = request.getParameter("titulo");
        String inicio = request.getParameter("inicio");
        String fin = request.getParameter("fin");
        String url = request.getParameter("url");
        int className = Integer.parseInt(request.getParameter("className"));
        
        System.out.println("holaaaa"+idVac);
        System.out.println("chaoo"+id);

        if (titulo != null) {
            p.setVacaciones_id(idVac);
            p.setUsuario_id(id);
            p.setVacaciones_titulo(titulo);
            p.setVacaciones_inicio(inicio);
            p.setVacaciones_fin(fin);
            p.setVacaciones_url(url);
            p.setVacaciones_className(className);

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
