/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controlador;

import com.mycompany.Modelo.Solicitud;
import com.mycompany.Modelo.Vacaciones;

import com.mycompany.ModeloDAO.vacacionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
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

    Solicitud sol = new Solicitud();

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

        if (titulo != null) {
            p.setVacaciones_id(idVac);
            p.setUsuario_id(id);
            p.setVacaciones_titulo(titulo);
            p.setVacaciones_inicio(inicio);
            p.setVacaciones_fin(fin);
            p.setVacaciones_url(url);
            p.setVacaciones_className(className);
            
            dao.edit(p);
            
            if(className == 1){           
//fecha en se aprueba la solicitud
            Date fechaActual = new Date();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(fechaActual);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaWindows = null;
            try {
                fechaWindows = df.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("::::::::::" + fechaWindows);
            
            
//cantidad de dias cobrados esta dado por el delta de fecha final - fecha inicial en dias 

            //cambiar el formato a la fecha inicial
            Date fechaInicial = null;
            try {
                fechaInicial = df.parse(inicio);
            } catch (ParseException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("fecha inicial de cobrados: "+ fechaInicial);
            
            
            //cambiar el formato a fecha final
            Date fechaFinal = null;
            try {
                fechaFinal = df.parse(fin);
            } catch (ParseException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("fecha final de cobrados: "+ fechaFinal);

            
            //generar el delta entre fechas para obtener los dias cobrados en esta aprovacion de solicitud
            int diasCobrados = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
            System.out.println("Dias cobrados: : : : : " + diasCobrados);
            
            sol.setUsuario_id(id);
            sol.setSolicitud_fecha(fechaWindows); //fecha actual en que se realiza la aprovacion 
            sol.setSolicitud_dias_cobrados(diasCobrados);
            
            dao.addSolicitud(sol);
            }   
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
