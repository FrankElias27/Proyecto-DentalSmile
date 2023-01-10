
package Controlador;

import Modelo.DAOCITA;
import Modelo.DAOESTADOCITA;
import Modelo.DAOODONTOLOGO;
import Modelo.DAOPACIENTE;
import Modelo.cita;
import Modelo.estadocita;
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


@WebServlet(name = "srvCita", urlPatterns = {"/srvCita"})
public class srvCita extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarCitas":
                        listarCitas(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarCita(request, response);
                        break;
                    case "registrar2":
                        registrarCita2(request, response);
                        break;
                    case "eliminarCita":
                        eliminarCita(request, response);
                        break;
                    case "leerCita":
                        presentarCita(request, response);
                        break;
                    case "actualizarCita":
                        actualizarCita(request, response);
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

    private void listarCitas(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA dao = new DAOCITA();
        List<cita> ci = null;
        try {
            ci = dao.listarCitas();
            request.setAttribute("citas", ci);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar las citas" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Citas/Citas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
       try {
            this.cargarPacientes(request);
            this.cargarOdontologos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Citas/nuevaCita.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }
    private void cargarPacientes(HttpServletRequest request) {
        DAOPACIENTE dao = new DAOPACIENTE();
        List<paciente> pac = null;
        try {
            pac = dao.listarPacientes();
            request.setAttribute("pacientes", pac);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            pac = null;
            dao = null;
        }
    }
    private void cargarOdontologos(HttpServletRequest request) {
        DAOODONTOLOGO dao = new DAOODONTOLOGO();
        List<odontologo> odo = null;
        try {
            odo = dao.listarOdontolgos();
            request.setAttribute("odontologos", odo);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            odo = null;
            dao = null;
        }
    }
    
    private void cargarEstados(HttpServletRequest request) {
        DAOESTADOCITA dao = new DAOESTADOCITA();
        List<estadocita> est = null;
        try {
            est = dao.listarEstados();
            request.setAttribute("estados", est);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            est = null;
            dao = null;
        }
    }

    private void registrarCita(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA daoCi;
        cita ci = null;
        estadocita est;
        paciente pa;
        odontologo odo;
        if (request.getParameter("txtDate") != null
                && request.getParameter("txtTime") != null
                && request.getParameter("txtdescripcion") != null
                && request.getParameter("cboPaciente") != null
                && request.getParameter("cboOdontologo") != null) {

            ci = new cita();
            ci.setFecha(request.getParameter("txtDate"));
            ci.setHora(request.getParameter("txtTime"));
            ci.setDescripcion(request.getParameter("txtdescripcion"));
            est = new estadocita();
            est.setId_estado(1);
            ci.setEstadocita(est);
            pa = new paciente();
            pa.setId_paciente(Integer.parseInt(request.getParameter("cboPaciente")));
            ci.setPaciente(pa);
            odo = new odontologo();
            odo.setId_doctor(Integer.parseInt(request.getParameter("cboOdontologo")));
            ci.setOdontologo(odo);
            
            daoCi = new DAOCITA();
            try {
                daoCi.registrarCitas(ci);
                response.sendRedirect("srvCita?accion=listarCitas");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el odontologo" + e.getMessage());
                request.setAttribute("odontologo", ci);
                this.presentarFormulario(request, response);
            }
        }
    }
    private void registrarCita2(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA daoCi;
        cita ci = null;
        estadocita est;
        paciente pa;
        odontologo odo;
        if (request.getParameter("txtDate") != null
                && request.getParameter("txtTime") != null
                && request.getParameter("txtdescripcion") != null
                && request.getParameter("cboPaciente") != null
                && request.getParameter("cboOdontologo") != null) {

            ci = new cita();
            ci.setFecha(request.getParameter("txtDate"));
            ci.setHora(request.getParameter("txtTime"));
            ci.setDescripcion(request.getParameter("txtdescripcion"));
            est = new estadocita();
            est.setId_estado(6);
            ci.setEstadocita(est);
            pa = new paciente();
            pa.setId_paciente(Integer.parseInt(request.getParameter("cboPaciente")));
            ci.setPaciente(pa);
            odo = new odontologo();
            odo.setId_doctor(Integer.parseInt(request.getParameter("cboOdontologo")));
            ci.setOdontologo(odo);
            
            daoCi = new DAOCITA();
            try {
                daoCi.registrarCitas(ci);
                response.sendRedirect("srvCita?accion=listarCitas");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el odontologo" + e.getMessage());
                request.setAttribute("odontologo", ci);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarCita(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA dao = new DAOCITA();
        cita ci = new cita();
        if (request.getParameter("cod") != null) {
            ci.setId_cita(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarCita(ci);
                response.sendRedirect("srvCita?accion=listarCitas");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarCita(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA dao;
        cita ci;
        if (request.getParameter("cod1") != null) {
            ci= new cita();
            ci.setId_cita(Integer.parseInt(request.getParameter("cod1")));

            dao = new DAOCITA();
            try {
                ci = dao.leerCitas(ci);
                if (ci != null) {
                    request.setAttribute("cita", ci);
                } else {
                    request.setAttribute("msje", "No se encontró la cita");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.cargarEstados(request);
            this.cargarOdontologos(request);
            this.cargarPacientes(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Citas/actualizarCita.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarCita(HttpServletRequest request, HttpServletResponse response) {
        DAOCITA daoCi;
        cita ci = null;
        estadocita est;
        paciente pa;
        odontologo od;
        
        if (request.getParameter("hCodigo") != null
                &&request.getParameter("cboPaciente") != null
                && request.getParameter("cboOdontologo") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtTime") != null
                && request.getParameter("cboEstado") != null
                && request.getParameter("txtdescripcion") != null) {

            ci = new cita();
            ci.setId_cita(Integer.parseInt(request.getParameter("hCodigo")));
            ci.setFecha(request.getParameter("txtDate"));
            ci.setHora(request.getParameter("txtTime"));
            ci.setDescripcion(request.getParameter("txtdescripcion"));
            est = new estadocita();
            est.setId_estado(Integer.parseInt(request.getParameter("cboEstado")));
            ci.setEstadocita(est);
            pa = new paciente();
            pa.setId_paciente(Integer.parseInt(request.getParameter("cboPaciente")));
            ci.setPaciente(pa);
            od = new odontologo();
            od.setId_doctor(Integer.parseInt(request.getParameter("cboOdontologo")));
            ci.setOdontologo(od);
           
            daoCi = new DAOCITA();
            try {
                daoCi.actualizarCita(ci);
                response.sendRedirect("srvCita?accion=listarCitas");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el odontologo" + e.getMessage());
                request.setAttribute("usuario", ci);

            }
            try {
                this.cargarEstados(request);
            this.cargarOdontologos(request);
            this.cargarPacientes(request);
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Citas/actualizarCita.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }
    

}
