
package Controlador;

import Modelo.DAOCONSULTA;
import Modelo.DAOFUA;
import Modelo.DAOHISTORIAL;
import Modelo.DAOINSUMO;
import Modelo.DAOMEDICAMENTO;
import Modelo.DAOPROCEDIMIENTO;
import Modelo.cita;
import Modelo.consulta;
import Modelo.fua;
import Modelo.historial;
import Modelo.insumo;
import Modelo.medicamento;
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
@WebServlet(name = "srvHistorial", urlPatterns = {"/srvHistorial"})
public class srvHistorialClinico extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarHistoriales":
                        listarHistoriales(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "leer":
                        presentarConsulta(request, response);
                        break;
                    case "registrar":
                        registrarConsulta(request, response);
                        break;
                    case "eliminarHistorial":
                        eliminarHistorial(request, response);
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

    private void listarHistoriales(HttpServletRequest request, HttpServletResponse response) {
        DAOHISTORIAL dao = new DAOHISTORIAL();
        List<historial> co = null;
        try {
            co = dao.listarHistorial();
            request.setAttribute("historial", co);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los Historiales" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/HistorialesClinicos/historial.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.cargarConsultas(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/HistorialesClinicos/nuevoHistorial.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }
    private void cargarConsultas(HttpServletRequest request) {
        DAOCONSULTA dao = new DAOCONSULTA();
        List<consulta> con = null;
        try {
            con = dao.listarConsultas2();
            request.setAttribute("consulta", con);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar las consultas :( " + e.getMessage());
        } finally {
            con = null;
            dao = null;
        }
    }
    
     
    private void registrarConsulta(HttpServletRequest request, HttpServletResponse response) {
        DAOHISTORIAL daoHI;
        fua fo=null;
        consulta co;
        historial hi;
        if (request.getParameter("txtidConsulta") != null
                &&request.getParameter("txtidHistorial") != null
                && request.getParameter("txtmotivoHI") != null
                && request.getParameter("txtdescripcionHI") != null
                && request.getParameter("txtidCita") != null) {

            fo = new fua();
            
            co = new consulta();
            co.setId_consulta(Integer.parseInt(request.getParameter("txtidConsulta")));
            co.setId_cita(Integer.parseInt(request.getParameter("txtidCita")));
            fo.setConsulta(co);
            hi = new historial();
            hi.setId_historial(Integer.parseInt(request.getParameter("txtidHistorial")));
            fo.setHistorial(hi);
            daoHI = new DAOHISTORIAL();
            try {
                daoHI.registrarFua(fo);
                response.sendRedirect("srvHistorial?accion=listarHistoriales");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el historial" + e.getMessage());
                request.setAttribute("odontologo", fo);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarHistorial(HttpServletRequest request, HttpServletResponse response) {
        DAOHISTORIAL dao = new DAOHISTORIAL();
        historial hi = new historial();
        if (request.getParameter("cod") != null) {
            hi.setId_historial(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarHistorial(hi);
                response.sendRedirect("srvHistorial?accion=listarHistoriales");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }
    private void presentarConsulta(HttpServletRequest request, HttpServletResponse response) {
        DAOHISTORIAL dao;
        consulta co = null;
         if (request.getParameter("cod1") != null) {

            co = new consulta();
            co.setId_consulta(Integer.parseInt(request.getParameter("cod1")));

            dao = new DAOHISTORIAL();
            try {
                co = dao.leerConsultas(co);
                if (co != null) {
                    request.setAttribute("consul", co);
                } else {
                    request.setAttribute("msje", "No se encontró la consulta");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        }else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        } 
        try {
            this.cargarConsultas(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/HistorialesClinicos/nuevoHistorial.jsp"
                    ).forward(request, response);
           
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

}
