/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.empresa.posesiones;
import java.util.Scanner;
/**
 *
 * @author Ivan
 */ //Clase serializable para ser guardada en productos.dat
public abstract class Producto implements Computable, java.io.Serializable{
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private int clave;

    public Producto(String marca, String modelo, String color, double precio, int clave){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.clave = clave;
    }
    //Gets
    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public String getColor(){
        return this.color;
    }
    public double getPrecio(){
        return this.precio;
    }
    public int getClave(){
        return this.clave;
    }
    //Definición de métodos con override en Computadora.java
    public abstract String getProcesador();
    public abstract int getRam();
    public abstract int getHdd();
    public abstract String getTarjetaVideo();
    public abstract String getTarjetaAudio();
}
