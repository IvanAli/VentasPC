/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.empresa.posesiones;
import ventaspc.empresa.posesiones.Producto;
import java.util.Scanner;
/**
 *
 * @author Ivan
 */ //Clase serializable para ser guardada en productos.dat
public class Computadora extends Producto implements java.io.Serializable{
    private String procesador;
    private int ram;
    private int hdd;
    private String tarjetaVideo;
    private String tarjetaAudio;

    public Computadora() {
        super(null, null, null, 0, 0);
    }
    
    public Computadora(String marca, String modelo, String color, double precio, int clave, String procesador, int ram, int hdd, String tarjetaVideo, String tarjetaAudio){
        super(marca, modelo, color, precio, clave);
        this.procesador = procesador;
        this.ram = ram;
        this.hdd = hdd;
        this.tarjetaVideo = tarjetaVideo;
        this.tarjetaAudio = tarjetaAudio;
    }
    @Override
    public String getMarca() {
        return super.getMarca(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String getColor() {
        return super.getColor(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double getPrecio() {
        return super.getPrecio(); //To change body of generated methods, choose Tools | Templates.
    }
    //@Override
    //public int getDisponibilidad(){
    //    return super.getDisponibilidad();
    //}
    /*@Override
    public void disponibilidadDecremento(){
        return super.disponibilidadDecremento();
    }*/
    public String getProcesador(){
        return this.procesador;
    }
    public int getRam(){
        return this.ram;
    }
    public int getHdd(){
        return this.hdd;
    }
    public String getTarjetaVideo(){
        return this.tarjetaVideo;
    }
    public String getTarjetaAudio(){
        return this.tarjetaAudio;
    }
    
}
