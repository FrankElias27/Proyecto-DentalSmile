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
public class DAOESTADOCITA extends Conexion {
    
    public List<estadocita> listarEstados() throws Exception {
        List<estadocita> estados;
        estadocita est;
        ResultSet rs = null;
        String sql = "SELECT E.IDESTADO, E.NOMBRE_ESTADO FROM ESTADOCITA E "
                + "ORDER BY E.IDESTADO";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            estados = new ArrayList<>();
            while (rs.next() == true) {
                est = new estadocita();
                est.setId_estado(rs.getInt("IDESTADO"));
                est.setNombreEstado(rs.getString("NOMBRE_ESTADO"));
                estados.add(est);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return estados;
    }
}
