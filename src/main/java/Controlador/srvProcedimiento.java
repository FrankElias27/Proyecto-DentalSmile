/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAOPROCEDIMIENTO;
import Modelo.procedimiento;
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
@WebServlet(name = "srvProcedimiento", urlPatterns = {"/srvProcedimiento"})
public class srvProcedimiento extends HttpServlet {

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
                    case "listarProcedimientos":
                        listarProcedimientos(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarProcedimiento(request, response);
                        break;
                    case "eliminarProcedimiento":
                        eliminarProcedimiento(request, response);
                        break;
                    case "leerProcedimiento":
                        presentarProcedimiento(request, response);
                        break;
                    case "actualizarProcedimiento":
                        actualizarProcedimiento(request, response);
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

    private void listarProcedimientos(HttpServletRequest request, HttpServletResponse response) {
        DAOPROCEDIMIENTO dao = new DAOPROCEDIMIENTO();
        List<procedimiento> pro = null;
        try {
            pro = dao.listarProcedimientos();
            request.setAttribute("procedimiento", pro);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los procedimientos" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Procedimientos/procedimientos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {  
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Procedimientos/nuevoProcedimiento.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }

    private void registrarProcedimiento(HttpServletRequest request, HttpServletResponse response) {
        DAOPROCEDIMIENTO daoPRO;
        procedimiento pro = null;
        if (request.getParameter("txtNombre") != null) {

            pro = new procedimiento();
            pro.setNombre(request.getParameter("txtNombre"));
            
            if (request.getParameter("chkEstadoIn") != null) {
                pro.setEstado("ACTIVO");
            } else {
                pro.setEstado("INACTIVO");
            }
            daoPRO = new DAOPROCEDIMIENTO();
            try {
                daoPRO.registrarProcedimientos(pro);
                response.sendRedirect("srvProcedimiento?accion=listarProcedimientos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el procedimiento" + e.getMessage());
                request.setAttribute("usuario", pro);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarProcedimiento(HttpServletRequest request, HttpServletResponse response) {
        DAOPROCEDIMIENTO dao = new DAOPROCEDIMIENTO();
        procedimiento pro = new procedimiento();
        if (request.getParameter("cod") != null) {
            pro.setId_procedimiento(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarProcedimiento(pro);
                response.sendRedirect("srvProcedimiento?accion=listarProcedimientos");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarProcedimiento(HttpServletRequest request, HttpServletResponse response) {
        DAOPROCEDIMIENTO daopro;
        procedimiento proc;
        if (request.getParameter("cod1") != null) {
            proc = new procedimiento();
            proc.setId_procedimiento(Integer.parseInt(request.getParameter("cod1")));

            daopro = new DAOPROCEDIMIENTO();
            try {
                proc = daopro.leerProcedimiento(proc);
                if (proc != null) {
                    request.setAttribute("proce",proc);
                } else {
                    request.setAttribute("msje", "No se encontró el Procedimiento");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Procedimientos/actualizarProcedimiento.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarProcedimiento(HttpServletRequest request, HttpServletResponse response) {
        DAOPROCEDIMIENTO daopro;
        procedimiento pro = null;

        if (request.getParameter("hCodigo") != null
                &&request.getParameter("txtNombre") != null) {

            pro = new procedimiento();
            pro.setId_procedimiento(Integer.parseInt(request.getParameter("hCodigo")));
            pro.setNombre(request.getParameter("txtNombre"));
            if (request.getParameter("chkEstadoIn") != null) {
                pro.setEstado("ACTIVO");
            } else {
                pro.setEstado("INACTIVO");
            }
            
            daopro = new DAOPROCEDIMIENTO();
            try {
                daopro.actualizarProcedimiento(pro);
                response.sendRedirect("srvProcedimiento?accion=listarProcedimientos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el procedimiento" + e.getMessage());
                request.setAttribute("paciente", pro);

            }
            try {
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Procedimientos/actualizarProcedimiento.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }

}
