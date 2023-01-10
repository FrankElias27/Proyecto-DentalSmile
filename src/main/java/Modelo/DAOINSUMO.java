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
public class DAOINSUMO extends Conexion {
    public List<insumo> listarInsumos() throws Exception {
        List<insumo> insumo;
        insumo in;
        ResultSet rs = null;
        String sql = "SELECT * FROM insumo;";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            insumo = new ArrayList<>();
            while (rs.next() == true) {
                in = new insumo();
                in.setId_insumo(rs.getInt("IDINSUMO"));
                in.setNombre(rs.getString("NOMBRE"));
                in.setStock(rs.getInt("STOCK"));
                in.setFecregis(rs.getString("FECHAREGISTRO"));
                in.setEstado(rs.getString("ESTADO"));
                insumo.add(in);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return insumo;
    }
    public List<insumo> listarInsumos2() throws Exception {
        List<insumo> insumo;
        insumo in;
        ResultSet rs = null;
        String sql = "SELECT * FROM insumo WHERE ESTADO = 'ACTIVO' ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            insumo = new ArrayList<>();
            while (rs.next() == true) {
                in = new insumo();
                in.setId_insumo(rs.getInt("IDINSUMO"));
                in.setNombre(rs.getString("NOMBRE"));
                in.setStock(rs.getInt("STOCK"));
                in.setFecregis(rs.getString("FECHAREGISTRO"));
                in.setEstado(rs.getString("ESTADO"));
                insumo.add(in);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return insumo;
    }
    public void registrarInsumos(insumo in) throws Exception {
        String sql;
        sql = "INSERT INTO insumo (NOMBRE, STOCK, FECHAREGISTRO, ESTADO) "
                + "VALUES ('" + in.getNombre() + "', "
                + "'" + in.getStock()+ "', "
                + " CURDATE(), "
                + "'" + in.getEstado()+ "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarInsumo(insumo in) throws Exception {
        String sql = "DELETE FROM INSUMO"
                + " WHERE IDINSUMO = " + in.getId_insumo();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public insumo leerInsumo(insumo in) throws Exception {
        insumo insu = null;
        ResultSet rs = null;
        String sql = "SELECT I.IDINSUMO, I.NOMBRE, I.STOCK, I.FECHAREGISTRO, I.ESTADO "
                + "FROM insumo I WHERE I.IDINSUMO = " + in.getId_insumo();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                insu = new insumo();
                insu.setId_insumo(rs.getInt("IDINSUMO"));
                insu.setNombre(rs.getString("NOMBRE"));
                insu.setStock(Integer.parseInt(rs.getString("STOCK")));
                insu.setFecregis(rs.getString("FECHAREGISTRO"));
                insu.setEstado(rs.getString("ESTADO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return insu;
    }
    public void actualizarInsumo(insumo in) throws Exception {
        String sql = "UPDATE insumo SET NOMBRE = '"
                + in.getNombre() + "', STOCK = '"
                + in.getStock()+ "', FECHAREGISTRO = CURDATE(), ESTADO = '"
                + in.getEstado()+ "'"
                + " WHERE IDINSUMO = " + in.getId_insumo();
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
