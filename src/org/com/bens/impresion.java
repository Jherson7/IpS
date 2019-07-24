/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.bens;

/**
 *
 * @author Usuario
 */
public class impresion {
    int id;
    int linea;
    String nombre_archivo;
    String fecha;
    String estado;
    String usuario;
    String contenido;

    public impresion() {
    }

    public impresion(int id, int linea, String nombre_archivo, String fecha, String estado, String usuario, String contenido) {
        this.id = id;
        this.linea = linea;
        this.nombre_archivo = nombre_archivo;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
