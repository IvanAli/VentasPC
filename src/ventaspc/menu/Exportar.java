/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.menu;

import ventaspc.empresa.posesiones.Computadora;
import ventaspc.empresa.posesiones.Producto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ventaspc.empresa.posesiones.RegistroCompra;
import ventaspc.Sistema;
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.gui.modulos.PrincipalPanel;

/**
 *
 * @author Ivan
 */
//Clase para exportar la lista de objetos de un tipo en un archivo csv
public class Exportar {
    public void exportarCSVClientes(Sistema sistema, JPanel jpanel){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.csv"));
            int cantidadClientes = sistema.getEmpresa().sizeClientes();
            Cliente c = new Cliente();
            bw.write("Nombre,Apellido,Cedula,Direccion,Ciudad,Telefono\n");
            for (int i=0; i<cantidadClientes; i++){
                c = sistema.getEmpresa().getClientes().get(i);
                bw.write("\"" + c.getNombre() + "\"," + "\"" + c.getApellido() + "\"," + "\"" + c.getCedula() + "\"," +
                        "\"" + c.getDireccion() + "\"," + "\"" + c.getCiudad() + "\"," + "\"" + c.getTelefono() + "\"\n");
            }
            JOptionPane.showMessageDialog(jpanel,"Exportado");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"No se ha podido exportar a CSV");
        }
    }
    
    public void exportarCSVProductos(Sistema sistema, JPanel jpanel){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos.csv"));
            int cantidadProductos = sistema.getEmpresa().sizeProductos();
            Producto c = new Computadora();
            bw.write("Marca,Modelo,Color,Precio,Procesador,HDD,RAM,Tarjeta de video,Tarjeta de audio\n");
            for (int i=0; i<cantidadProductos; i++){
                c = sistema.getEmpresa().getProductos().get(i);
                bw.write("\"" + c.getMarca() + "\"," + "\"" + c.getModelo() + "\"," + "\"" + c.getColor() + "\"," +
                        "\"" + c.getPrecio() + "\"," + "\"" + c.getProcesador() + "\"," + "\"" + c.getHdd() + "\","
                        + "\"" + c.getRam() + "\"," + "\"" + c.getTarjetaVideo() + "\"," + "\"" + c.getTarjetaAudio() + "\"\n");
            }
            JOptionPane.showMessageDialog(jpanel,"Exportado");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"No se ha podido exportar a CSV");
        }
    }
    
    public void exportarVentas(Sistema sistema, JPanel jpanel){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("ventas.csv"));
            int cantidad = sistema.getEmpresa().getCompras().size();
            RegistroCompra c = new RegistroCompra();
            bw.write("Nombre,Apellido,Cedula,Marca,Modelo,Precio\n");
            for (int i=0; i<cantidad; i++){
                c = sistema.getEmpresa().getCompras().get(i);
                bw.write("\"" + c.getNombre() + "\"," + "\"" + c.getApellido() + "\"," + "\"" + c.getCedula() + "\"," +
                        "\"" + c.getMarca() + "\"," + "\"" + c.getModelo() + "\"," + "\"" + c.getPrecio() + "\"\n");
            }
            JOptionPane.showMessageDialog(jpanel,"Exportado");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"No se ha podido exportar a CSV");
        }
    }
}
