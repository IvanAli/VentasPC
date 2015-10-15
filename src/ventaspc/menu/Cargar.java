/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.menu;
import java.io.*;
import javax.swing.JOptionPane;
import ventaspc.Sistema;
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.empresa.posesiones.Computadora;
import ventaspc.empresa.posesiones.Empleado;
import ventaspc.empresa.posesiones.RegistroCompra;
/**
 *
 * @author Ivan
 */
//Clase para cargar cada uno de los arreglos de objetos del programa
public class Cargar {
    public void cargarClientes(Sistema sistema){
        try{
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int cantidad = ois.readInt();
            for (int i=0; i<cantidad; i++){
               sistema.getEmpresa().getClientes().add((Cliente)ois.readObject());
            }
            //JOptionPane.showMessageDialog(this,"Clientes cargados");
            ois.close();
        }
        catch(IOException ex){
            //JOptionPane.showMessageDialog(null,"No hay clientes que cargar");
        }
        catch(ClassNotFoundException ex){
            
        }
    }
    
    public void cargarProductos(Sistema sistema){
        try{
            FileInputStream fis = new FileInputStream("productos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int cantidad = ois.readInt();
            for (int i=0; i<cantidad; i++){
               sistema.getEmpresa().getProductos().add((Computadora)ois.readObject());
            }
            //JOptionPane.showMessageDialog(null,"Productos cargados");
            ois.close();
        }
        catch(IOException ex){
            //JOptionPane.showMessageDialog(this,"No hay productos que cargar");
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            
        }
    }
    
    public void cargarVentas(Sistema sistema){
        try{
            FileInputStream fis = new FileInputStream("ventas.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int cantidad = ois.readInt();
            for (int i=0; i<cantidad; i++){
               sistema.getEmpresa().getCompras().add((RegistroCompra)ois.readObject());
            }
            //JOptionPane.showMessageDialog(this,"Productos cargados");
            ois.close();
        }
        catch(IOException ex){
            //JOptionPane.showMessageDialog(this,"No hay historial de ventas que cargar");
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            
        }
    }
    
    public void cargarVentaIngreso(Sistema sistema){
        try{
            FileInputStream fis = new FileInputStream("ingreso.dat");
            DataInputStream dis = new DataInputStream(fis);
            sistema.getEmpresa().setIngreso((double)dis.readDouble());
            sistema.getEmpresa().setNumVentas((int)dis.readInt());
            dis.close();
        }
        catch(IOException ex){
            
        }
    }
    
    public void cargarEmpleados(Sistema sistema){
        try{
            FileInputStream fis = new FileInputStream("empleados.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int cantidad = ois.readInt();
            for (int i=0; i<cantidad; i++){
               sistema.getEmpresa().getEmpleados().add((Empleado)ois.readObject());
            }
            //JOptionPane.showMessageDialog(this,"Usuarios cargados");
            ois.close();
        }
        catch(IOException ex){
            //JOptionPane.showMessageDialog(null,"No hay usuarios que cargar");
        }
        catch(ClassNotFoundException ex){
            
        }
    }
}
