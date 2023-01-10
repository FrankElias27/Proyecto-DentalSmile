
package Controlador;

import Modelo.DAOCITA;
import Modelo.DAOCONSULTA;
import Modelo.DAOODONTOLOGO;
import Modelo.DAOPACIENTE;
import Modelo.cita;
import Modelo.consulta;
import Modelo.odontologo;
import Modelo.paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "srvConsulta", urlPatterns = {"/srvConsulta"})
public class srvConsulta extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarConsultas":
                        listarConsultas(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarConsulta(request, response);
                        break;
                    case "eliminarConsulta":
                        eliminarConsulta(request, response);
                        break;
                    case "leerConsulta":
                        presentarConsulta(request, response);
                        break;
                    case "actualizarConsulta":
                        actualizarConsulta(request, response);
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

    private void listarConsultas(HttpServletRequest request, HttpServletResponse response) {
        DAOCONSULTA dao = new DAOCONSULTA();
        List<consulta> co = null;
        try {
            co = dao.listarConsultas();
            request.setAttribute("consulta", co);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar las citas" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Consultas/consultas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.cargarCitas(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Consultas/nuevaConsulta.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }
    private void cargarCitas(HttpServletRequest request) {
        DAOCITA dao = new DAOCITA();
        List<cita> cit = null;
        try {
            cit = dao.listarCitas2();
            request.setAttribute("cita", cit);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            cit = null;
            dao = null;
        }
    }
    private void cargarCitas2(HttpServletRequest request) {
        DAOCITA dao = new DAOCITA();
        List<cita> cit = null;
        try {
            cit = dao.listarCitas3();
            request.setAttribute("cita", cit);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            cit = null;
            dao = null;
        }
    }
   

    private void registrarConsulta(HttpServletRequest request, HttpServletResponse response) {
        DAOCONSULTA daoCo;
        consulta co = null;
        cita ci;
        if (request.getParameter("cboCita") != null
                && request.getParameter("txtdescripcion") != null
                && request.getParameter("txtdiagnostico") != null) {

            co = new consulta();
            co.setDescripcion(request.getParameter("txtdescripcion"));
            co.setDiagnostico(request.getParameter("txtdiagnostico"));
            ci = new cita();
            ci.setId_cita(Integer.parseInt(request.getParameter("cboCita")));
            co.setCita(ci);
            
            daoCo = new DAOCONSULTA();
            try {
                daoCo.registrarConsulta(co);
                response.sendRedirect("srvConsulta?accion=listarConsultas");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el odontologo" + e.getMessage());
                request.setAttribute("odontologo", ci);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarConsulta(HttpServletRequest request, HttpServletResponse response) {
       DAOCONSULTA dao = new DAOCONSULTA();
        consulta co = new consulta();
        if (request.getParameter("cod") != null) {
            co.setId_consulta(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarConsulta(co);
                response.sendRedirect("srvConsulta?accion=listarConsultas");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarConsulta(HttpServletRequest request, HttpServletResponse response) {
        DAOCONSULTA dao;
        consulta co;
        if (request.getParameter("cod1") != null) {
            co= new consulta();
            co.setId_consulta(Integer.parseInt(request.getParameter("cod1")));

            dao = new DAOCONSULTA();
            try {
                co = dao.leerConsultas(co);
                if (co != null) {
                    request.setAttribute("consulta", co);
                } else {
                    request.setAttribute("msje", "No se encontró la consulta");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.cargarCitas2(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Consultas/actualizarConsulta.jsp"
                    ).forward(request, response);
           
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarConsulta(HttpServletRequest request, HttpServletResponse response) {
        DAOCONSULTA daoCo;
        consulta co = null;
        
        if (request.getParameter("hCodigo") != null
                && request.getParameter("txtdescripcion") != null
                && request.getParameter("txtdiagnostico") != null) {

            co = new consulta();
            co.setId_consulta(Integer.parseInt(request.getParameter("hCodigo")));
            co.setDescripcion(request.getParameter("txtdescripcion"));
            co.setDiagnostico(request.getParameter("txtdiagnostico"));
            
           
            daoCo = new DAOCONSULTA();
            try {
                daoCo.actualizarConsulta(co);
                response.sendRedirect("srvConsulta?accion=listarConsultas");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar la consulta" + e.getMessage());
                request.setAttribute("usuario", co);

            }
            try {
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Consultas/actualizarConsulta.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }

}
