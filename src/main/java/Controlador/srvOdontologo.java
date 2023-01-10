

package Controlador;

import Modelo.DAOODONTOLOGO;
import Modelo.DAOUSUARIO;
import Modelo.odontologo;
import Modelo.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "srvOdontologo", urlPatterns = {"/srvOdontologo"})
public class srvOdontologo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
                try {
            if (accion != null) {
                switch (accion) {
                    case "listarOdontologos":
                        listarOdontologos(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;
                    case "registrar":
                        registrarOdontologo(request, response);
                        break;
                    case "eliminarOdontologo":
                        eliminarOdontologo(request, response);
                        break;
                    case "leerOdontologo":
                        presentarOdontologo(request, response);
                        break;
                    case "actualizarOdontologo":
                        actualizarOdontologo(request, response);
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

    private void listarOdontologos(HttpServletRequest request, HttpServletResponse response) {
        DAOODONTOLOGO dao = new DAOODONTOLOGO();
        List<odontologo> odont = null;
        try {
            odont = dao.listarOdontolgos();
            request.setAttribute("odontologos", odont);

        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los odontologos" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Odontologos/odontologos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void registrarOdontologo(HttpServletRequest request, HttpServletResponse response) {
        DAOODONTOLOGO daoOdo;
        odontologo odont = null;
        usuario user;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtApellido") != null
                && request.getParameter("cboSexo") != null
                && request.getParameter("txtTele") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("cboUsuario") != null) {

            odont = new odontologo();
            odont.setNombre(request.getParameter("txtNombre"));
            odont.setApellidos(request.getParameter("txtApellido"));
            odont.setSexo(request.getParameter("cboSexo"));
            odont.setTelefono(request.getParameter("txtTele"));
            odont.setFechanac(request.getParameter("txtDate"));
            odont.setDni(request.getParameter("txtDni"));
            user = new usuario();
            user.setId_usuario(Integer.parseInt(request.getParameter("cboUsuario")));
            odont.setUsuario(user);
            
            daoOdo = new DAOODONTOLOGO();
            try {
                daoOdo.registrarOdontologos(odont);
                response.sendRedirect("srvOdontologo?accion=listarOdontologos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el odontologo" + e.getMessage());
                request.setAttribute("odontologo", odont);
                this.presentarFormulario(request, response);
            }
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
         try {
            this.cargarUsuarios(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/Odontologos/nuevoOdontologo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }
    }

    private void cargarUsuarios(HttpServletRequest request) {
        DAOUSUARIO dao = new DAOUSUARIO();
        List<usuario> usus = null;
        try {
            usus = dao.listarUsuarios();
            request.setAttribute("usuarios", usus);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios :( " + e.getMessage());
        } finally {
            usus = null;
            dao = null;
        }
    }

  
    private void eliminarOdontologo(HttpServletRequest request, HttpServletResponse response) {
        DAOODONTOLOGO dao = new DAOODONTOLOGO();
        odontologo odon = new odontologo();
        if (request.getParameter("cod") != null) {
            odon.setId_doctor(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarOdontologo(odon);
                response.sendRedirect("srvOdontologo?accion=listarOdontologos");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void presentarOdontologo(HttpServletRequest request, HttpServletResponse response) {
        DAOODONTOLOGO daodoc;
        odontologo doc;
        if (request.getParameter("cod1") != null) {
            doc = new odontologo();
            doc.setId_doctor(Integer.parseInt(request.getParameter("cod1")));

            daodoc = new DAOODONTOLOGO();
            try {
                doc = daodoc.leerOdontologo(doc);
                if (doc != null) {
                    request.setAttribute("doctor", doc);
                } else {
                    request.setAttribute("msje", "No se encontró el odontologo");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.cargarUsuarios(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/vistas/Odontologos/actualizarOdontologo.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarOdontologo(HttpServletRequest request, HttpServletResponse response) {
        DAOODONTOLOGO daoUsu;
        odontologo usus = null;
        usuario car;

        if (request.getParameter("hCodigo") != null
                &&request.getParameter("txtNombre") != null
                && request.getParameter("txtApellido") != null
                && request.getParameter("cboSexo") != null
                && request.getParameter("txtTele") != null
                && request.getParameter("txtDate") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("cboUsuario") != null) {

            usus = new odontologo();
            usus.setId_doctor(Integer.parseInt(request.getParameter("hCodigo")));
            usus.setNombre(request.getParameter("txtNombre"));
            usus.setApellidos(request.getParameter("txtApellido"));
            usus.setSexo(request.getParameter("cboSexo"));
            usus.setTelefono(request.getParameter("txtTele"));
            usus.setFechanac(request.getParameter("txtDate"));
            usus.setDni(request.getParameter("txtDni"));
            car = new usuario();
            car.setId_usuario(Integer.parseInt(request.getParameter("cboUsuario")));
            usus.setUsuario(car);
           
            daoUsu = new DAOODONTOLOGO();
            try {
                daoUsu.actualizarOdontologo(usus);
                response.sendRedirect("srvOdontologo?accion=listarOdontologos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el odontologo" + e.getMessage());
                request.setAttribute("usuario", usus);

            }
            try {
                this.cargarUsuarios(request);
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/Odontologos/actualizarOdontologo.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }
    
  

}
