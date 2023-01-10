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
public class DAOFUA extends Conexion {

    public List<paciente> listarDiagnosticos(paciente p) throws Exception {
        List<paciente> paci;
        paciente pac;
        ResultSet rs = null;
        String sql = "SELECT c.FECHA,concat_ws(' ',o.NOMBRE,o.APELLIDOS) as ODONTOLOGO, c.DESCRIPCION, co.DIAGNOSTICO,f.IDFUA "
                + "FROM paciente as p "
                + "INNER JOIN cita as c ON c.IDPACIENTE=p.IDPACIENTE "
                + "INNER JOIN estadocita as e ON e.IDESTADO=c.IDESTADO "
                + "INNER JOIN consulta as co ON co.IDCITA=c.IDCITA "
                +"INNER JOIN fua as f ON f.IDCONSULTA=co.IDCONSULTA "
                + "INNER JOIN odontologo as o ON o.IDDOCTOR=c.IDDOCTOR "
                + "WHERE p.IDPACIENTE = " + p.getId_paciente() + " AND co.ESTADO = 'TERMINADA' ";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            paci = new ArrayList<>();
            while (rs.next() == true) {
                pac = new paciente();
                pac.setFecha1(rs.getString("c.FECHA"));
                pac.setOdont1(rs.getString("ODONTOLOGO"));
                pac.setDescripcion1(rs.getString("c.DESCRIPCION"));
                pac.setDiagnostico1(rs.getString("co.DIAGNOSTICO"));
                pac.setId_fua(rs.getInt("f.IDFUA"));
                paci.add(pac);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return paci;
    }
    public void eliminarFua(fua f) throws Exception {
        String sql = "DELETE FROM FUA"
                + " WHERE IDFUA = " + f.getId_fua();
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
