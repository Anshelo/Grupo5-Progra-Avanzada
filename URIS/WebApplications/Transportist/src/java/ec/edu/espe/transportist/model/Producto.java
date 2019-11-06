/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportist.model;

/**
 *
 * @author Diego
 */
public class Producto {
    String codigo;
    String nombre;
    String descripcion;
    float peso;
    String sensibilidad;
    float valorU;

    public Producto(String codigo, String nombre, String descripcion, float peso, String sensibilidad, float valorU) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peso = peso;
        this.sensibilidad = sensibilidad;
        this.valorU = valorU;
    }

    public Producto() {
    }

    @Override
    public String toString() {
        return "Product{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", peso=" + peso + ", sensibilidad=" + sensibilidad + ", valorU=" + valorU + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(String sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public float getValorU() {
        return valorU;
    }

    public void setValorU(float valorU) {
        this.valorU = valorU;
    }
}
