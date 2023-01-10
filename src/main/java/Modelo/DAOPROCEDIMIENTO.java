/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ellis
 */
public class DAOPROCEDIMIENTO extends Conexion {
    public List<procedimiento> listarProcedimientos() throws Exception {
        List<procedimiento> procedimiento;
        procedimiento pro;
        ResultSet rs = null;
        String sql = "SELECT * FROM procedimiento;";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            procedimiento = new ArrayList<>();
            while (rs.next() == true) {
                pro = new procedimiento();
                pro.setId_procedimiento(rs.getInt("IDPROCEDIMIENTO"));
                pro.setNombre(rs.getString("NOMBRE"));
                pro.setFecregis(rs.getString("FECHAREGISTRO"));
                pro.setEstado(rs.getString("ESTADO"));
                procedimiento.add(pro);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return procedimiento;
    }
    public List<procedimiento> listarProcedimientos2() throws Exception {
        List<procedimiento> procedimiento;
        procedimiento pro;
        ResultSet rs = null;
        String sql = "SELECT * FROM procedimiento WHERE ESTADO = 'ACTIVO' ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            procedimiento = new ArrayList<>();
            while (rs.next() == true) {
                pro = new procedimiento();
                pro.setId_procedimiento(rs.getInt("IDPROCEDIMIENTO"));
                pro.setNombre(rs.getString("NOMBRE"));
                pro.setFecregis(rs.getString("FECHAREGISTRO"));
                pro.setEstado(rs.getString("ESTADO"));
                procedimiento.add(pro);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return procedimiento;
    }
    public void registrarProcedimientos(procedimiento pro) throws Exception {
        String sql;
        sql = "INSERT INTO procedimiento (NOMBRE, FECHAREGISTRO, ESTADO) "
                + "VALUES ('" + pro.getNombre() + "', "
                + " CURDATE(), "
                + "'" + pro.getEstado()+ "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarProcedimiento(procedimiento pro) throws Exception {
        String sql = "DELETE FROM PROCEDIMIENTO"
                + " WHERE IDPROCEDIMIENTO = " + pro.getId_procedimiento();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public procedimiento leerProcedimiento(procedimiento pro) throws Exception {
        procedimiento proc = null;
        ResultSet rs = null;
        String sql = "SELECT P.IDPROCEDIMIENTO, P.NOMBRE, P.FECHAREGISTRO, P.ESTADO "
                + "FROM procedimiento P WHERE P.IDPROCEDIMIENTO = " + pro.getId_procedimiento();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                proc = new procedimiento();
                proc.setId_procedimiento(rs.getInt("IDPROCEDIMIENTO"));
                proc.setNombre(rs.getString("NOMBRE"));
                proc.setFecregis(rs.getString("FECHAREGISTRO"));
                proc.setEstado(rs.getString("ESTADO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return proc;
    }
    public void actualizarProcedimiento(procedimiento pro) throws Exception {
        String sql = "UPDATE procedimiento SET NOMBRE = '"
                + pro.getNombre() + "', FECHAREGISTRO = CURDATE(), ESTADO = '"
                + pro.getEstado()+ "'"
                + " WHERE IDPROCEDIMIENTO = " + pro.getId_procedimiento();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
}
