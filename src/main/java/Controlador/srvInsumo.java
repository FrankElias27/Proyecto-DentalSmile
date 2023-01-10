/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAOINSUMO;
import Modelo.insumo;
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
@WebServlet(name = "srvInsumo", urlPatterns = {"/srvInsumo"})
public class srvInsumo extends HttpServlet {

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
                    case "listarInsumos":
                        listarInsumos(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarInsumo(request, response);
                        break;
                    case "eliminarInsumo":
                        eliminarInsumo(request, response);
                        break;
                    case "leerInsumo":
                        presentarInsumo(request, response);
                        break;
                    case "actualizarInsumo":
                        actualizarInsumo(request, response);
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

    private void listarInsumos(HttpServletRequest request, HttpServletResponse response) {
        DAOINSUMO dao = new DAOINSUMO();
        List<insumo> in = null;
        try {
            in = dao.listarInsumos();
            request.setAttribute("insumo", in);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los insumos" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Insumos/insumos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
       try {  
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Insumos/nuevoInsumo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }

    private void registrarInsumo(HttpServletRequest request, HttpServletResponse response) {
        DAOINSUMO daoIn;
        insumo in = null;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtStock") != null) {

            in = new insumo();
            in.setNombre(request.getParameter("txtNombre"));
            in.setStock(Integer.parseInt(request.getParameter("txtStock")));
            
            if (request.getParameter("chkEstadoIn") != null) {
                in.setEstado("ACTIVO");
            } else {
                in.setEstado("INACTIVO");
            }
            daoIn = new DAOINSUMO();
            try {
                daoIn.registrarInsumos(in);
                response.sendRedirect("srvInsumo?accion=listarInsumos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", in);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarInsumo(HttpServletRequest request, HttpServletResponse response) {
        DAOINSUMO dao = new DAOINSUMO();
        insumo in = new insumo();
        if (request.getParameter("cod") != null) {
            in.setId_insumo(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarInsumo(in);
                response.sendRedirect("srvInsumo?accion=listarInsumos");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarInsumo(HttpServletRequest request, HttpServletResponse response) {
        DAOINSUMO daoin;
        insumo insu;
        if (request.getParameter("cod1") != null) {
            insu = new insumo();
            insu.setId_insumo(Integer.parseInt(request.getParameter("cod1")));

            daoin = new DAOINSUMO();
            try {
                insu = daoin.leerInsumo(insu);
                if (insu != null) {
                    request.setAttribute("insumo",insu);
                } else {
                    request.setAttribute("msje", "No se encontró el Insumo");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Insumos/actualizarInsumo.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarInsumo(HttpServletRequest request, HttpServletResponse response) {
        DAOINSUMO daoin;
        insumo in = null;

        if (request.getParameter("hCodigo") != null
                &&request.getParameter("txtNombre") != null
                && request.getParameter("txtStock") != null) {

            in = new insumo();
            in.setId_insumo(Integer.parseInt(request.getParameter("hCodigo")));
            in.setNombre(request.getParameter("txtNombre"));
            in.setStock(Integer.parseInt(request.getParameter("txtStock")));
            if (request.getParameter("chkEstadoIn") != null) {
                in.setEstado("ACTIVO");
            } else {
                in.setEstado("INACTIVO");
            }
            
            daoin = new DAOINSUMO();
            try {
                daoin.actualizarInsumo(in);
                response.sendRedirect("srvInsumo?accion=listarInsumos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el insumo" + e.getMessage());
                request.setAttribute("paciente", in);

            }
            try {
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Insumos/actualizarInsumo.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }

}
