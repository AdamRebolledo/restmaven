/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controlador;

import com.google.gson.Gson;
import com.mycompany.Modelo.CalendarDTO;

import com.mycompany.Modelo.Vacaciones;


import com.mycompany.ModeloDAO.vacacionesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;
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
@WebServlet(name = "vacaciones", urlPatterns = {"/vacaciones"})
public class vacaciones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String addEvent = "addEvents.jsp";
    String viewEvents = "viewEvents.jsp";
    String listaJson = "listaJson";
    String editEvents = "editEvents.jsp";
    String menuPrincipal = "menuprincipal.jsp";
    String changeEvents ="changeEvents.jsp";

    vacacionesDAO dao = new vacacionesDAO();
    Vacaciones vac = new Vacaciones();
    
   
    
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vacaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vacaciones at " + request.getContextPath() + "</h1>");
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

        if (action.equalsIgnoreCase("addEvents")) {
            
            int usuario_id = Integer.parseInt(request.getParameter("id"));
            ArrayList<Integer> listaCobrados = dao.cobrados(usuario_id);
            int totalCobrados = 0;
            for (int x = 0; x < listaCobrados.size(); x++) {
                   totalCobrados +=  listaCobrados.get(x);
                }
       
            request.setAttribute("cobrado", totalCobrados);
            acceso = addEvent;

        } else if (action.equalsIgnoreCase("eliminar")) {
            int usuarioId = Integer.parseInt(request.getParameter("id"));
            int idVac = Integer.parseInt(request.getParameter("idVac"));
            dao.eliminar(usuarioId, idVac);
            acceso = editEvents;
        } else if (action.equalsIgnoreCase("editEvents")) {
            acceso = editEvents;
        } else if (action.equalsIgnoreCase("changeEvents")) {
            acceso = changeEvents;
        } else if (action.equalsIgnoreCase("viewEvents")) {

            int usuarioId = Integer.parseInt(request.getParameter("id"));
            vacacionesDAO dao = new vacacionesDAO();

            Gson gson = new Gson();

            List listaCalendarioVista = new ArrayList();

            for (Vacaciones pc : dao.listar(usuarioId)) {
                // System.out.println("->" + pc.getVacaciones_fin());
                CalendarDTO oc = new CalendarDTO();

                oc.setId(pc.getVacaciones_id());
                oc.setTitle(pc.getVacaciones_titulo());
                oc.setStart(pc.getVacaciones_inicio());
                oc.setEnd(pc.getVacaciones_fin());
                oc.setUrl(pc.getVacaciones_url());
                if(pc.getVacaciones_className() == 1){
                oc.setClassName("aprovado");
                }else{
                oc.setClassName("rechazado");
                }
                System.out.println(oc.getClassName());
                oc.setEditable(pc.isVacaciones_editable());

                listaCalendarioVista.add(oc);
            }
            String lis = new Gson().toJson(listaCalendarioVista);
            System.out.println(lis);
            String equipo = "El trabajo en equipo hace que los sueños se cumplan";
            request.setAttribute("trabajo", equipo);
            request.setAttribute("vacaciones", lis);

            acceso = viewEvents;
        }

        RequestDispatcher rd = request.getRequestDispatcher(acceso);
        rd.forward(request, response);

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

        int usuario_id = Integer.parseInt(request.getParameter("id"));
        String vacaciones_titulo = request.getParameter("titulo");
        String vacaciones_inicio = request.getParameter("inicio");
        String vacaciones_fin = request.getParameter("fin");
        String vacaciones_url = request.getParameter("url");
        if (request.getParameter("url") == null) {
            vacaciones_url = "#";
        }
        
       

        if (vacaciones_titulo != null) {

            vac.setUsuario_id(usuario_id);
            vac.setVacaciones_titulo(vacaciones_titulo);
            vac.setVacaciones_inicio(vacaciones_inicio);
            vac.setVacaciones_fin(vacaciones_fin);
            vac.setVacaciones_url(vacaciones_url);
            
            
         
            dao.add(vac);
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
