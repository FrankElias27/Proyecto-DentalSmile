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
public class DAOODONTOLOGO extends Conexion {

    public List<odontologo> listarOdontolgos() throws Exception {
        List<odontologo> odontologo;
        odontologo odont;
        ResultSet rs = null;
        String sql = "SELECT O.IDDOCTOR,concat_ws(' ',O.NOMBRE,O.APELLIDOS) as ODONTOLOGO, O.SEXO, O.TELEFONO, O.FECHANACIMIENTO,O.DNI,U.NOMBREUSUARIO "
                + "FROM odontologo O INNER JOIN usuario U "
                + "ON U.IDUSUARIO = O.IDUSUARIO "
                + "ORDER BY O.IDDOCTOR";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            odontologo = new ArrayList<>();
            while (rs.next() == true) {
                odont = new odontologo();
                odont.setId_doctor(rs.getInt("IDDOCTOR"));
                odont.setNombre(rs.getString("ODONTOLOGO"));
                odont.setSexo(rs.getString("SEXO"));
                odont.setTelefono(rs.getString("TELEFONO"));
                odont.setFechanac(rs.getString("FECHANACIMIENTO"));
                odont.setDni(rs.getString("DNI"));
                odont.setUsuario(new usuario());
                odont.getUsuario().setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                odontologo.add(odont);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return odontologo;
    }

    public void registrarOdontologos(odontologo odont) throws Exception {
        String sql;
        sql = "INSERT INTO odontologo (NOMBRE, APELLIDOS, SEXO, TELEFONO, FECHANACIMIENTO, DNI, IDUSUARIO) "
                + "VALUES ('" + odont.getNombre() + "', "
                + "'" + odont.getApellidos() + "', "
                + "'" + odont.getSexo() + "', "
                + "'" + odont.getTelefono() + "', "
                + "'" + odont.getFechanac() + "', "
                + "'" + odont.getDni() + "', "
                + "'" + odont.getUsuario().getId_usuario() + "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public void eliminarOdontologo(odontologo odo) throws Exception {
        String sql = "DELETE FROM ODONTOLOGO"
                + " WHERE IDDOCTOR = " + odo.getId_doctor();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public odontologo leerOdontologo(odontologo doctor) throws Exception {
        odontologo doc = null;
        ResultSet rs = null;
        String sql = "SELECT O.IDDOCTOR, O.NOMBRE, O.APELLIDOS, O.SEXO, O.TELEFONO, O.FECHANACIMIENTO, O.DNI, O.IDUSUARIO "
                + "FROM odontologo O WHERE O.IDDOCTOR = " + doctor.getId_doctor();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                doc = new odontologo();
                doc.setId_doctor(rs.getInt("IDDOCTOR"));
                doc.setNombre(rs.getString("NOMBRE"));
                doc.setApellidos(rs.getString("APELLIDOS"));
                doc.setSexo(rs.getString("SEXO"));
                doc.setTelefono(rs.getString("TELEFONO"));
                doc.setFechanac(rs.getString("FECHANACIMIENTO"));
                doc.setDni(rs.getString("DNI"));
                doc.setUsuario(new usuario());
                doc.getUsuario().setId_usuario(rs.getInt("IDUSUARIO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return doc;
    }
    public void actualizarOdontologo(odontologo odo) throws Exception {
        String sql = "UPDATE odontologo SET NOMBRE = '"
                + odo.getNombre() + "', APELLIDOS = '"
                + odo.getApellidos()+ "', SEXO = '"
                + odo.getSexo()+ "', TELEFONO = '"
                + odo.getTelefono()+ "', FECHANACIMIENTO = '"
                + odo.getFechanac() + "', DNI = "
                + odo.getDni()+ ", IDUSUARIO = "
                + odo.getUsuario().getId_usuario()
                + " WHERE IDDOCTOR = " + odo.getId_doctor();
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
