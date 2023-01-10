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
public class DAOCITA extends Conexion  {
    public List<cita> listarCitas() throws Exception {
        List<cita> cita;
        cita ci;
        ResultSet rs = null;
        String sql = "SELECT c.IDCITA,c.FECHA,c.HORA,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO,e.NOMBRE_ESTADO,c.DESCRIPCION "
                + "FROM cita as c "
                + "INNER JOIN paciente as p ON c.IDPACIENTE=p.IDPACIENTE "
                + "INNER JOIN odontologo as o ON c.IDDOCTOR=o.IDDOCTOR "
                + "INNER JOIN estadocita as e ON c.IDESTADO= e.IDESTADO "
                + "ORDER BY IDCITA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            cita = new ArrayList<>();
            while (rs.next() == true) {
                ci = new cita();
                ci.setId_cita(rs.getInt("IDCITA"));
                ci.setFecha(rs.getString("FECHA"));
                ci.setHora(rs.getString("HORA"));
                ci.setDescripcion(rs.getString("DESCRIPCION"));
                ci.setPaciente(new paciente());
                ci.getPaciente().setNombre(rs.getString("PACIENTE"));
                ci.setEstadocita(new estadocita());
                ci.getEstadocita().setNombreEstado(rs.getString("NOMBRE_ESTADO"));
                ci.setOdontologo(new odontologo());
                ci.getOdontologo().setNombre(rs.getString("ODONTOLOGO"));
                cita.add(ci);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return cita;
    }
    public List<cita> listarCitas2() throws Exception {
        List<cita> cita;
        cita ci;
        ResultSet rs = null;
        String sql = "SELECT c.IDCITA,c.FECHA,c.HORA,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO,e.NOMBRE_ESTADO,c.DESCRIPCION "
                + "FROM cita as c "
                + "INNER JOIN paciente as p ON c.IDPACIENTE=p.IDPACIENTE "
                + "INNER JOIN odontologo as o ON c.IDDOCTOR=o.IDDOCTOR "
                + "INNER JOIN estadocita as e ON c.IDESTADO= e.IDESTADO "
                + "WHERE C.IDESTADO= 2 "
                + "ORDER BY IDCITA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            cita = new ArrayList<>();
            while (rs.next() == true) {
                ci = new cita();
                ci.setId_cita(rs.getInt("IDCITA"));
                ci.setFecha(rs.getString("FECHA"));
                ci.setHora(rs.getString("HORA"));
                ci.setDescripcion(rs.getString("DESCRIPCION"));
                ci.setPaciente(new paciente());
                ci.getPaciente().setNombre(rs.getString("PACIENTE"));
                ci.setEstadocita(new estadocita());
                ci.getEstadocita().setNombreEstado(rs.getString("NOMBRE_ESTADO"));
                ci.setOdontologo(new odontologo());
                ci.getOdontologo().setNombre(rs.getString("ODONTOLOGO"));
                cita.add(ci);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return cita;
    }
    public List<cita> listarCitas3() throws Exception {
        List<cita> cita;
        cita ci;
        ResultSet rs = null;
        String sql = "SELECT c.IDCITA,c.FECHA,c.HORA,concat_ws(' ',p.NOMBRE,p.APELLIDOS) as PACIENTE,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO,e.NOMBRE_ESTADO,c.DESCRIPCION "
                + "FROM cita as c "
                + "INNER JOIN paciente as p ON c.IDPACIENTE=p.IDPACIENTE "
                + "INNER JOIN odontologo as o ON c.IDDOCTOR=o.IDDOCTOR "
                + "INNER JOIN estadocita as e ON c.IDESTADO= e.IDESTADO "
                + "WHERE C.IDESTADO= 4 "
                + "ORDER BY IDCITA ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            cita = new ArrayList<>();
            while (rs.next() == true) {
                ci = new cita();
                ci.setId_cita(rs.getInt("IDCITA"));
                ci.setFecha(rs.getString("FECHA"));
                ci.setHora(rs.getString("HORA"));
                ci.setDescripcion(rs.getString("DESCRIPCION"));
                ci.setPaciente(new paciente());
                ci.getPaciente().setNombre(rs.getString("PACIENTE"));
                ci.setEstadocita(new estadocita());
                ci.getEstadocita().setNombreEstado(rs.getString("NOMBRE_ESTADO"));
                ci.setOdontologo(new odontologo());
                ci.getOdontologo().setNombre(rs.getString("ODONTOLOGO"));
                cita.add(ci);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return cita;
    }
    public void registrarCitas(cita ci) throws Exception {
        String sql;
        sql = "INSERT INTO cita (FECHA, HORA, IDESTADO, IDDOCTOR, IDPACIENTE, DESCRIPCION) "
                + "VALUES ('" + ci.getFecha() + "', "
                + "'" + ci.getHora() + "', "
                + "'" + ci.getEstadocita().getId_estado() + "', "
                + "'" + ci.getOdontologo().getId_doctor() + "', "
                + "'" + ci.getPaciente().getId_paciente() + "', "
                + "'" + ci.getDescripcion() +  "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarCita(cita ci) throws Exception {
        String sql = "DELETE FROM CITA"
                + " WHERE IDCITA = " + ci.getId_cita();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public cita leerCitas(cita ci) throws Exception {
        cita cit = null;
        ResultSet rs = null;
        String sql = "SELECT ci.IDCITA, ci.FECHA, ci.HORA, ci.IDESTADO, ci.IDDOCTOR, ci.IDPACIENTE, ci.DESCRIPCION,e.NOMBRE_ESTADO "
                + "FROM cita ci "
                + "INNER JOIN estadocita as e ON e.IDESTADO=ci.IDESTADO "
                + "WHERE ci.IDCITA = " + ci.getId_cita();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                cit = new cita();
                cit.setId_cita(rs.getInt("IDCITA"));
                cit.setFecha(rs.getString("FECHA"));
                cit.setHora(rs.getString("HORA"));
                cit.setDescripcion(rs.getString("DESCRIPCION"));
                cit.setOdontologo(new odontologo());
                cit.getOdontologo().setId_doctor(rs.getInt("IDDOCTOR"));
                cit.setPaciente(new paciente());
                cit.getPaciente().setId_paciente(rs.getInt("IDPACIENTE"));
                cit.setEstadocita(new estadocita());
                cit.getEstadocita().setId_estado(rs.getInt("IDESTADO"));
                cit.getEstadocita().setNombreEstado(rs.getString("e.NOMBRE_ESTADO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return cit;
    }
    public void actualizarCita(cita ci) throws Exception {
        String sql = "UPDATE cita SET FECHA = '"
                + ci.getFecha()+ "', HORA = '"
                + ci.getHora()+ "', IDESTADO = '"
                + ci.getEstadocita().getId_estado()+ "', IDDOCTOR = '"
                + ci.getOdontologo().getId_doctor()+ "', IDPACIENTE = '"
                + ci.getPaciente().getId_paciente()+ "', DESCRIPCION = '"
                + ci.getDescripcion()+"' "
                + " WHERE IDCITA = " + ci.getId_cita();
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
