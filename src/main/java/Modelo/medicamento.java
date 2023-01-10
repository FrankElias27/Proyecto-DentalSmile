/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ellis
 */
public class medicamento {
    private int id_medicamento;
    private String nombre;
    private String alias;
    private int stock;
    private String fecregis;
    private String fecvenc;
    private String estado;

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecregis() {
        return fecregis;
    }

    public void setFecregis(String fecregis) {
        this.fecregis = fecregis;
    }

    public String getFecvenc() {
        return fecvenc;
    }

    public void setFecvenc(String fecvenc) {
        this.fecvenc = fecvenc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
