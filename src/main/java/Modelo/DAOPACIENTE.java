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
public class DAOPACIENTE extends Conexion{
    public List<paciente> listarPacientes() throws Exception {
        List<paciente> paciente;
        paciente pa;
        ResultSet rs = null;
        String sql = "SELECT P.IDPACIENTE,concat_ws(' ',P.NOMBRE,P.APELLIDOS) as PACIENTE, P.SEXO, P.TELEFONO, P.FECHANACIMIENTO,P.DNI,P.DOMICILIO "
                + "FROM paciente P";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            paciente = new ArrayList<>();
            while (rs.next() == true) {
                pa = new paciente();
                pa.setId_paciente(rs.getInt("IDPACIENTE"));
                pa.setNombre(rs.getString("PACIENTE"));
                pa.setSexo(rs.getString("SEXO"));
                pa.setTelefono(rs.getString("TELEFONO"));
                pa.setFechanac(rs.getString("FECHANACIMIENTO"));
                pa.setDni(rs.getString("DNI"));
                pa.setDomicilio(rs.getString("DOMICILIO"));
                paciente.add(pa);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return paciente;
    }
    public void registrarPacientes(paciente pa) throws Exception {
        String sql;
        sql = "INSERT INTO paciente (NOMBRE, APELLIDOS, SEXO, TELEFONO, FECHANACIMIENTO, DNI, DOMICILIO) "
                + "VALUES ('" + pa.getNombre() + "', "
                + "'" + pa.getApellidos() + "', "
                + "'" + pa.getSexo() + "', "
                + "'" + pa.getTelefono() + "', "
                + "'" + pa.getFechanac() + "', "
                + "'" + pa.getDni() + "', "
                + "'" + pa.getDomicilio() + "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarPaciente(paciente pac) throws Exception {
        String sql = "DELETE FROM PACIENTE"
                + " WHERE IDPACIENTE = " + pac.getId_paciente();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public paciente leerPaciente(paciente pa) throws Exception {
        paciente pac = null;
        ResultSet rs = null;
        String sql = "SELECT P.IDPACIENTE, P.NOMBRE, P.APELLIDOS, P.SEXO, P.TELEFONO, P.FECHANACIMIENTO, P.DNI, P.DOMICILIO "
                + "FROM paciente P WHERE P.IDPACIENTE = " + pa.getId_paciente();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                pac = new paciente();
                pac.setId_paciente(rs.getInt("IDPACIENTE"));
                pac.setNombre(rs.getString("NOMBRE"));
                pac.setApellidos(rs.getString("APELLIDOS"));
                pac.setSexo(rs.getString("SEXO"));
                pac.setTelefono(rs.getString("TELEFONO"));
                pac.setFechanac(rs.getString("FECHANACIMIENTO"));
                pac.setDni(rs.getString("DNI"));
                pac.setDomicilio(rs.getString("DOMICILIO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return pac;
    }
    public void actualizarPaciente(paciente pa) throws Exception {
        String sql = "UPDATE paciente SET NOMBRE = '"
                + pa.getNombre() + "', APELLIDOS = '"
                + pa.getApellidos()+ "', SEXO = '"
                + pa.getSexo()+ "', TELEFONO = '"
                + pa.getTelefono()+ "', FECHANACIMIENTO = '"
                + pa.getFechanac() + "', DNI = "
                + pa.getDni()+ ", DOMICILIO = '"
                + pa.getDomicilio()+"'"
                + " WHERE IDPACIENTE = " + pa.getId_paciente();
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
