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
public class DAOMEDICAMENTO extends Conexion  {
    public List<medicamento> listarMedicamentos() throws Exception {
        List<medicamento> medicamento;
        medicamento mec;
        ResultSet rs = null;
        String sql = "SELECT * FROM medicamento;";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            medicamento = new ArrayList<>();
            while (rs.next() == true) {
                mec = new medicamento();
                mec.setId_medicamento(rs.getInt("IDMEDICAMENTO"));
                mec.setNombre(rs.getString("NOMBRE"));
                mec.setAlias(rs.getString("ALIAS"));
                mec.setStock(rs.getInt("STOCK"));
                mec.setFecregis(rs.getString("FECHAREGISTRO"));
                mec.setFecvenc(rs.getString("FECHAVENCIMIENTO"));
                mec.setEstado(rs.getString("ESTADO"));
                medicamento.add(mec);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return medicamento;
    }
    public List<medicamento> listarMedicamentos2() throws Exception {
        List<medicamento> medicamento;
        medicamento mec;
        ResultSet rs = null;
        String sql = "SELECT * FROM medicamento WHERE ESTADO = 'ACTIVO' ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            medicamento = new ArrayList<>();
            while (rs.next() == true) {
                mec = new medicamento();
                mec.setId_medicamento(rs.getInt("IDMEDICAMENTO"));
                mec.setNombre(rs.getString("NOMBRE"));
                mec.setAlias(rs.getString("ALIAS"));
                mec.setStock(rs.getInt("STOCK"));
                mec.setFecregis(rs.getString("FECHAREGISTRO"));
                mec.setFecvenc(rs.getString("FECHAVENCIMIENTO"));
                mec.setEstado(rs.getString("ESTADO"));
                medicamento.add(mec);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return medicamento;
    }
    public void registrarMedicamentos(medicamento me) throws Exception {
        String sql;
        sql = "INSERT INTO medicamento (NOMBRE, ALIAS, STOCK, FECHAREGISTRO, FECHAVENCIMIENTO, ESTADO) "
                + "VALUES ('" + me.getNombre() + "', "
                + "'" + me.getAlias()+ "', "
                + "'" + me.getStock()+ "', "
                + " CURDATE(), "
                + "'" + me.getFecvenc()+ "', "
                + "'" + me.getEstado()+ "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public void eliminarMedicamento(medicamento me) throws Exception {
        String sql = "DELETE FROM MEDICAMENTO"
                + " WHERE IDMEDICAMENTO = " + me.getId_medicamento();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    public medicamento leerMedicamento(medicamento me) throws Exception {
        medicamento medi = null;
        ResultSet rs = null;
        String sql = "SELECT M.IDMEDICAMENTO, M.NOMBRE, M.ALIAS, M.STOCK, M.FECHAREGISTRO, M.FECHAVENCIMIENTO, M.ESTADO "
                + "FROM medicamento M WHERE M.IDMEDICAMENTO = " + me.getId_medicamento();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                medi = new medicamento();
                medi.setId_medicamento(rs.getInt("IDMEDICAMENTO"));
                medi.setNombre(rs.getString("NOMBRE"));
                medi.setAlias(rs.getString("ALIAS"));
                medi.setStock(Integer.parseInt(rs.getString("STOCK")));
                medi.setFecregis(rs.getString("FECHAREGISTRO"));
                medi.setFecvenc(rs.getString("FECHAVENCIMIENTO"));
                medi.setEstado(rs.getString("ESTADO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return medi;
    }
    public void actualizarMedicamento(medicamento me) throws Exception {
        String sql = "UPDATE medicamento SET NOMBRE = '"
                + me.getNombre() + "', ALIAS = '"
                + me.getAlias() + "', STOCK = '"
                + me.getStock()+ "', FECHAREGISTRO = CURDATE(), FECHAVENCIMIENTO = '"
                + me.getFecvenc()+ "', ESTADO = '"
                + me.getEstado()+ "'"
                + " WHERE IDMEDICAMENTO = " + me.getId_medicamento();
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
