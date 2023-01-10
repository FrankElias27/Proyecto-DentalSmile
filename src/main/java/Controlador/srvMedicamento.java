/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAOMEDICAMENTO;
import Modelo.medicamento;
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
@WebServlet(name = "srvMedicamento", urlPatterns = {"/srvMedicamento"})
public class srvMedicamento extends HttpServlet {

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
                    case "listarMedicamentos":
                        listarMedicamentos(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarMedicamento(request, response);
                        break;
                    case "eliminarMedicamento":
                        eliminarMedicamento(request, response);
                        break;
                    case "leerMedicamento":
                        presentarMedicamento(request, response);
                        break;
                    case "actualizarMedicamento":
                        actualizarMedicamento(request, response);
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

    private void listarMedicamentos(HttpServletRequest request, HttpServletResponse response) {
        DAOMEDICAMENTO dao = new DAOMEDICAMENTO();
        List<medicamento> me = null;
        try {
            me = dao.listarMedicamentos();
            request.setAttribute("medicamento", me);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los medicamentos" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Medicamentos/medicamentos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
       try {  
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Medicamentos/nuevoMedicamento.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }

    private void registrarMedicamento(HttpServletRequest request, HttpServletResponse response) {
        DAOMEDICAMENTO daoMe;
        medicamento me = null;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtAlias") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtStock") != null) {

            me = new medicamento();
            me.setNombre(request.getParameter("txtNombre"));
            me.setAlias(request.getParameter("txtAlias"));
            me.setFecvenc(request.getParameter("txtDate"));
            me.setStock(Integer.parseInt(request.getParameter("txtStock")));
            
            if (request.getParameter("chkEstadoMe") != null) {
                me.setEstado("ACTIVO");
            } else {
                me.setEstado("INACTIVO");
            }
            daoMe = new DAOMEDICAMENTO();
            try {
                daoMe.registrarMedicamentos(me);
                response.sendRedirect("srvMedicamento?accion=listarMedicamentos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el medicamento" + e.getMessage());
                request.setAttribute("usuario", me);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarMedicamento(HttpServletRequest request, HttpServletResponse response) {
        DAOMEDICAMENTO dao = new DAOMEDICAMENTO();
        medicamento me = new medicamento();
        if (request.getParameter("cod") != null) {
            me.setId_medicamento(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarMedicamento(me);
                response.sendRedirect("srvMedicamento?accion=listarMedicamentos");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarMedicamento(HttpServletRequest request, HttpServletResponse response) {
        DAOMEDICAMENTO daoMe;
        medicamento me;
        if (request.getParameter("cod1") != null) {
            me = new medicamento();
            me.setId_medicamento(Integer.parseInt(request.getParameter("cod1")));

            daoMe = new DAOMEDICAMENTO();
            try {
                me = daoMe.leerMedicamento(me);
                if (me != null) {
                    request.setAttribute("medicamento",me);
                } else {
                    request.setAttribute("msje", "No se encontró el Medicamento");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Medicamentos/actualizarMedicamento.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarMedicamento(HttpServletRequest request, HttpServletResponse response) {
        DAOMEDICAMENTO daoMe;
        medicamento me = null;

        if (request.getParameter("hCodigo") != null
                &&request.getParameter("txtNombre") != null
                && request.getParameter("txtAlias") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtStock") != null) {

            me = new medicamento();
            me.setId_medicamento(Integer.parseInt(request.getParameter("hCodigo")));
            me.setNombre(request.getParameter("txtNombre"));
            me.setAlias(request.getParameter("txtAlias"));
            me.setFecvenc(request.getParameter("txtDate"));
            me.setStock(Integer.parseInt(request.getParameter("txtStock")));
            if (request.getParameter("chkEstadoMe") != null) {
                me.setEstado("ACTIVO");
            } else {
                me.setEstado("INACTIVO");
            }
            
            daoMe = new DAOMEDICAMENTO();
            try {
                daoMe.actualizarMedicamento(me);
                response.sendRedirect("srvMedicamento?accion=listarMedicamentos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el medicamento" + e.getMessage());
                request.setAttribute("medicamento", me);

            }
            try {
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Medicamentos/actualizarMedicamento.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }

}
