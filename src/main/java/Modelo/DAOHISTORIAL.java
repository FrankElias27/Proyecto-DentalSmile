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
public class DAOHISTORIAL extends Conexion{
    public List<historial> listarHistorial() throws Exception {
        List<historial> historial;
        historial hi;
        ResultSet rs = null;
        String sql = "SELECT hi.IDHISTORIA,hi.FECHAREGISTRO,p.DNI,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,p.IDPACIENTE "
                + "FROM historiaclinica as hi "
                + "INNER JOIN paciente as p ON p.IDPACIENTE=hi.IDPACIENTE "
                + "ORDER BY IDHISTORIA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            historial = new ArrayList<>();
            while (rs.next() == true) {
                hi = new historial();
                hi.setId_historial(rs.getInt("IDHISTORIA"));
                hi.setFecharegistro(rs.getString("FECHAREGISTRO"));
                hi.setPaciente(new paciente());
                hi.getPaciente().setDni(rs.getString("DNI"));
                hi.getPaciente().setNombre(rs.getString("PACIENTE"));
                hi.getPaciente().setId_paciente(rs.getInt("IDPACIENTE"));
                historial.add(hi);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return historial;
    }
    public consulta leerConsultas(consulta co) throws Exception {
        consulta con = null;
        ResultSet rs = null;
        String sql = "SELECT co.IDCONSULTA, co.DESCRIPCION, co.DIAGNOSTICO, co.FECHAREGISTRO, co.ESTADO, co.IDCITA , concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE, c.IDCITA, c.DESCRIPCION,h.IDHISTORIA "
                + "FROM consulta co "
                + "INNER JOIN cita as c ON c.IDCITA=co.IDCITA "
                + "INNER JOIN paciente as p ON p.IDPACIENTE=c.IDPACIENTE "
                + "INNER JOIN historiaclinica as h ON h.IDPACIENTE=p.IDPACIENTE "
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
                con.setId_historia(rs.getInt("h.IDHISTORIA"));
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
    public void registrarFua(fua fo) throws Exception {
        String sql;
        sql = "INSERT INTO fua (FECHAREGISTRO, IDHISTORIA, IDCONSULTA) "
                + "VALUES ( CURDATE() , "
                + "'" + fo.getHistorial().getId_historial()+ "', "
                + "'" + fo.getConsulta().getId_consulta()+ "');";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    
    public void eliminarHistorial(historial hi) throws Exception {
        String sql = "DELETE FROM HISTORIACLINICA"
                + " WHERE IDHISTORIA = " + hi.getId_historial();
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
