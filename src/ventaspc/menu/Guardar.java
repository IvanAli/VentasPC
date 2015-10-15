/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.menu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ventaspc.Sistema;
import ventaspc.gui.modulos.PrincipalPanel;

/**
 *
 * @author Ivan
 */
//Clase para realizar todas las funciones de guardado
public class Guardar {
    public void guardarClientes(Sistema sistema, JPanel jpanel) {                                                    
        try{
            FileOutputStream fos = new FileOutputStream("clientes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            int cantidadClientes = sistema.getEmpresa().sizeClientes();
            oos.writeInt(cantidadClientes);
            for (int i=0; i<cantidadClientes; i++){
                oos.writeObject(sistema.getEmpresa().getClientes().get(i));
            }
            //JOptionPane.showMessageDialog(jpanel,"Clientes guardados");
            oos.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"Ha ocurrido un error al guardar los clientes");
        }
    }   
    
    public void guardarProductos(Sistema sistema, JPanel jpanel){
         try{
            FileOutputStream fos = new FileOutputStream("productos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            int cantidadProductos = sistema.getEmpresa().sizeProductos();
            oos.writeInt(cantidadProductos);
            for (int i=0; i<cantidadProductos; i++){
                oos.writeObject(sistema.getEmpresa().getProductos().get(i));
            }
            //JOptionPane.showMessageDialog(jpanel,"Productos guardados");
            oos.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"Ha ocurrido un error al guardar los productos");
        }
    }
    
    public void guardarVentas(Sistema sistema, JPanel jpanel){
        try{
            FileOutputStream fos = new FileOutputStream("ventas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            int cantidad = sistema.getEmpresa().getCompras().size();
            oos.writeInt(cantidad);
            for (int i=0; i<cantidad; i++){
                oos.writeObject(sistema.getEmpresa().getCompras().get(i));
            }
            //JOptionPane.showMessageDialog(jpanel,"Historial de ventas guardado");
            oos.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"Ha ocurrido un error al guardar las ventas");
        }
    }
    
    public void guardarEmpleados(Sistema sistema, JPanel jpanel) {                                                    
        try{
            FileOutputStream fos = new FileOutputStream("empleados.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            int cantidadEmpleados = sistema.getEmpresa().sizeEmpleados();
            oos.writeInt(cantidadEmpleados);
            for (int i=0; i<cantidadEmpleados; i++){
                oos.writeObject(sistema.getEmpresa().getEmpleados().get(i));
            }
            //JOptionPane.showMessageDialog(jpanel,"Empleados guardados");
            oos.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(jpanel,"Ha ocurrido un error al guardar los usuarios");
        }
    } 
}
