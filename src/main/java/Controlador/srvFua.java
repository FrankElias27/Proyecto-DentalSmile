/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAOCONSULTA;
import Modelo.DAOFUA;
import Modelo.DAOPACIENTE;
import Modelo.consulta;
import Modelo.fua;
import Modelo.paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ellis
 */
@WebServlet(name = "srvFua", urlPatterns = {"/srvFua"})
public class srvFua extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarDiagnosticos":
                        listarDiagnosticos(request, response);
                        break;
                    case "eliminarFua":
                        eliminarFua(request, response);
                        break;
                    
                    default:
                        response.sendRedirect("identificar.jsp");
                }
           
            } else {
                response.sendRedirect("identificar.jsp");
            }
        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }
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

    private void listarDiagnosticos(HttpServletRequest request, HttpServletResponse response) {
        DAOFUA dao = new DAOFUA();
        List<paciente> pa = null;
        paciente p= new paciente();
            p.setId_paciente(Integer.parseInt(request.getParameter("cod1")));

            dao = new DAOFUA();
            try {
                pa = dao.listarDiagnosticos(p);
            request.setAttribute("paciente1", pa);
            }  catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar las citas" + e.getMessage());
        } finally {
            dao = null;
        }
        
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/HistorialesClinicos/diagnosticos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }

    }

    private void eliminarFua(HttpServletRequest request, HttpServletResponse response) {
        DAOFUA dao = new DAOFUA();
        fua f = new fua();
        if (request.getParameter("cod") != null) {
            f.setId_fua(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarFua(f);
                response.sendRedirect("srvHistorial?accion=listarHistoriales");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }



    

}
