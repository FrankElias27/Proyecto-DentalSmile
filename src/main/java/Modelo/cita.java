/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ellis
 */
public class cita {
    private int id_cita;
    private String fecha;
    private String hora;
    private estadocita estadocita;
    private odontologo odontologo;
    private paciente paciente;
    private String descripcion;
    private String dni;
    private String nombrep;
    private String nombreo;
    

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public estadocita getEstadocita() {
        return estadocita;
    }

    public void setEstadocita(estadocita estadocita) {
        this.estadocita = estadocita;
    }

    public odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getNombreo() {
        return nombreo;
    }

    public void setNombreo(String nombreo) {
        this.nombreo = nombreo;
    }
    
    
}
