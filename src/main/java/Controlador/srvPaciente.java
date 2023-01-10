
package Controlador;

import Modelo.DAOPACIENTE;
import Modelo.paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "srvPaciente", urlPatterns = {"/srvPaciente"})
public class srvPaciente extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarPacientes":
                        listarPacientes(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarPaciente(request, response);
                        break;
                    case "eliminarPaciente":
                        eliminarPaciente(request, response);
                        break;
                    case "leerPaciente":
                        presentarPaciente(request, response);
                        break;
                    case "actualizarPaciente":
                        actualizarPaciente(request, response);
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

    private void listarPacientes(HttpServletRequest request, HttpServletResponse response) {
        DAOPACIENTE dao = new DAOPACIENTE();
        List<paciente> pa = null;
        try {
            pa = dao.listarPacientes();
            request.setAttribute("pacientes", pa);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los pacientes" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Pacientes/pacientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {  
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Pacientes/nuevoPaciente.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }

    private void registrarPaciente(HttpServletRequest request, HttpServletResponse response) {
        DAOPACIENTE daopa;
        paciente pa = null;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtApellido") != null
                && request.getParameter("cboSexo") != null
                && request.getParameter("txtTele") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("txtDireccion") != null) {

            pa = new paciente();
            pa.setNombre(request.getParameter("txtNombre"));
            pa.setApellidos(request.getParameter("txtApellido"));
            pa.setSexo(request.getParameter("cboSexo"));
            pa.setTelefono(request.getParameter("txtTele"));
            pa.setFechanac(request.getParameter("txtDate"));
            pa.setDni(request.getParameter("txtDni"));
            pa.setDomicilio(request.getParameter("txtDireccion"));
            
            daopa = new DAOPACIENTE();
            try {
                daopa.registrarPacientes(pa);
                response.sendRedirect("srvPaciente?accion=listarPacientes");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el paciente" + e.getMessage());
                request.setAttribute("odontologo", pa);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) {
        DAOPACIENTE dao = new DAOPACIENTE();
        paciente pa = new paciente();
        if (request.getParameter("cod") != null) {
            pa.setId_paciente(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarPaciente(pa);
                response.sendRedirect("srvPaciente?accion=listarPacientes");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarPaciente(HttpServletRequest request, HttpServletResponse response) {
    DAOPACIENTE daopac;
        paciente pac;
        if (request.getParameter("cod1") != null) {
            pac = new paciente();
            pac.setId_paciente(Integer.parseInt(request.getParameter("cod1")));

            daopac = new DAOPACIENTE();
            try {
                pac = daopac.leerPaciente(pac);
                if (pac != null) {
                    request.setAttribute("paciente",pac);
                } else {
                    request.setAttribute("msje", "No se encontró el Paciente");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Pacientes/actualizarPaciente.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) {
        DAOPACIENTE daoPa;
        paciente pa = null;

        if (request.getParameter("hCodigo") != null
                &&request.getParameter("txtNombre") != null
                && request.getParameter("txtApellido") != null
                && request.getParameter("cboSexo") != null
                && request.getParameter("txtTele") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("txtDireccion") != null) {

            pa = new paciente();
            pa.setId_paciente(Integer.parseInt(request.getParameter("hCodigo")));
            pa.setNombre(request.getParameter("txtNombre"));
            pa.setApellidos(request.getParameter("txtApellido"));
            pa.setSexo(request.getParameter("cboSexo"));
            pa.setTelefono(request.getParameter("txtTele"));
            pa.setFechanac(request.getParameter("txtDate"));
            pa.setDni(request.getParameter("txtDni"));
            pa.setDomicilio(request.getParameter("txtDireccion"));
            
            daoPa = new DAOPACIENTE();
            try {
                daoPa.actualizarPaciente(pa);
                response.sendRedirect("srvPaciente?accion=listarPacientes");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el paciente" + e.getMessage());
                request.setAttribute("paciente", pa);

            }
            try {
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Pacientes/actualizarPaciente.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }
    

}
