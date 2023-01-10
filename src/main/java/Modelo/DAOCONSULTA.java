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
public class DAOCONSULTA extends Conexion {
    public List<consulta> listarConsultas() throws Exception {
        List<consulta> consulta;
        consulta co;
        ResultSet rs = null;
        String sql = "SELECT co.IDCONSULTA,p.DNI,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,co.FECHAREGISTRO,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO,c.DESCRIPCION, co.DIAGNOSTICO,co.ESTADO "
                + "FROM consulta as co "
                + "INNER JOIN cita as c ON c.IDCITA=co.IDCITA "
                + "INNER JOIN paciente as p ON p.IDPACIENTE=c.IDPACIENTE "
                + "INNER JOIN odontologo as o ON o.IDDOCTOR=c.IDDOCTOR "
                + "ORDER BY IDCONSULTA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            consulta = new ArrayList<>();
            while (rs.next() == true) {
                co = new consulta();
                co.setId_consulta(rs.getInt("IDCONSULTA"));
                co.setDiagnostico(rs.getString("DIAGNOSTICO"));
                co.setEstado(rs.getString("ESTADO"));
                co.setFecha(rs.getString("co.FECHAREGISTRO"));
                co.setCita(new cita());
                co.getCita().setDescripcion(rs.getString("DESCRIPCION"));
                co.getCita().setDni(rs.getString("DNI"));
                co.getCita().setNombrep(rs.getString("PACIENTE"));
                co.getCita().setNombreo(rs.getString("ODONTOLOGO"));
                consulta.add(co);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return consulta;
    }
    public List<consulta> listarConsultas2() throws Exception {
        List<consulta> consulta;
        consulta co;
        ResultSet rs = null;
        String sql = "SELECT co.IDCONSULTA,p.DNI,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,co.FECHAREGISTRO,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO,c.IDCITA, c.DESCRIPCION, co.DIAGNOSTICO,co.ESTADO,h.IDHISTORIA "
                + "FROM consulta as co "
                + "INNER JOIN cita as c ON c.IDCITA=co.IDCITA "
                + "INNER JOIN paciente as p ON p.IDPACIENTE=c.IDPACIENTE "
                + "INNER JOIN odontologo as o ON o.IDDOCTOR=c.IDDOCTOR "
                + "INNER JOIN historiaclinica as h ON h.IDPACIENTE=p.IDPACIENTE "
                + "WHERE co.ESTADO ='ATENDIDA' "
                + "ORDER BY IDCONSULTA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            consulta = new ArrayList<>();
            while (rs.next() == true) {
                co = new consulta();
                co.setId_consulta(rs.getInt("IDCONSULTA"));
                co.setDiagnostico(rs.getString("DIAGNOSTICO"));
                co.setEstado(rs.getString("ESTADO"));
                co.setFecha(rs.getString("co.FECHAREGISTRO"));
                co.setId_historia(rs.getInt("h.IDHISTORIA"));
                co.setCita(new cita());
                co.getCita().setId_cita(rs.getInt("c.IDCITA"));
                co.getCita().setDescripcion(rs.getString("DESCRIPCION"));
                co.getCita().setDni(rs.getString("DNI"));
                co.getCita().setNombrep(rs.getString("PACIENTE"));
                co.getCita().setNombreo(rs.getString("ODONTOLOGO"));
                consulta.add(co);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return consulta;
    }
    public void registrarConsulta(consulta co) throws Exception {
        String sql;
        sql = "INSERT INTO consulta (DESCRIPCION, DIAGNOSTICO, FECHAREGISTRO, ESTADO, IDCITA) "
                + "VALUES ('" + co.getDescripcion()+ "', "
                + "'" + co.getDiagnostico()+ "', "
                + " CURDATE() , "
                + "'ATENDIDA', "
                + "'" + co.getCita().getId_cita()+ "');";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarConsulta(consulta co) throws Exception {
        String sql = "DELETE FROM CONSULTA"
                + " WHERE IDCONSULTA = " + co.getId_consulta();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public consulta leerConsultas(consulta co) throws Exception {
        consulta con = null;
        ResultSet rs = null;
        String sql = "SELECT co.IDCONSULTA, co.DESCRIPCION, co.DIAGNOSTICO, co.FECHAREGISTRO, co.ESTADO, co.IDCITA , concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE, c.IDCITA, c.DESCRIPCION "
                + "FROM consulta co "
                + "INNER JOIN cita as c ON c.IDCITA=co.IDCITA "
                + "INNER JOIN paciente as p ON p.IDPACIENTE=c.IDPACIENTE "
                + "WHERE co.IDCONSULTA = " + co.getId_consulta();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                con = new consulta();
                con.setId_consulta(rs.getInt("IDCONSULTA"));
                con.setDescripcion(rs.getString("co.DESCRIPCION"));
                con.setDiagnostico(rs.getString("DIAGNOSTICO"));
                con.setFecha(rs.getString("FECHAREGISTRO"));
                con.setEstado(rs.getString("ESTADO"));
                con.setCita(new cita());
                con.getCita().setId_cita(rs.getInt("c.IDCITA"));
                con.getCita().setNombrep(rs.getString("PACIENTE"));
                con.getCita().setDescripcion(rs.getString("c.DESCRIPCION"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return con;
    }
    public void actualizarConsulta(consulta co) throws Exception {
        String sql = "UPDATE consulta SET DESCRIPCION = '"
                + co.getDescripcion()+ "', DIAGNOSTICO = '"
                + co.getDiagnostico()+ "', FECHAREGISTRO = CURDATE()"
                + " WHERE IDCONSULTA = " + co.getId_consulta();
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
