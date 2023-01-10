/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ellis
 */
public class fua {
    private int id_fua;
    private String nro;
    private String fecha;
    private historial historial;
    private consulta consulta;

    public int getId_fua() {
        return id_fua;
    }

    public void setId_fua(int id_fua) {
        this.id_fua = id_fua;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public historial getHistorial() {
        return historial;
    }

    public void setHistorial(historial historial) {
        this.historial = historial;
    }

    public consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(consulta consulta) {
        this.consulta = consulta;
    }
    
    
}
