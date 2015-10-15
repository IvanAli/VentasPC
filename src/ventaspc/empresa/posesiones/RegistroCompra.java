/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.empresa.posesiones;
import javax.swing.*;
/**
 *
 * @author Ivan
 */ //Clase para guardar cada compra/venta realizada en un objeto
public class RegistroCompra implements java.io.Serializable{
    private String nombre;
    private String apellido;
    private int cedula;
    private String marca;
    private String modelo;
    private double precio;
    private int clave;

    public RegistroCompra() {
    }
    
    public RegistroCompra(String nombre, String apellido, int cedula, String marca, String modelo, double precio, int clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.clave = clave;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getClave(){
        return clave;
    }
}
