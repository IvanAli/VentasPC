/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.empresa;
import ventaspc.empresa.posesiones.Producto;
import ventaspc.empresa.posesiones.Computadora;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import ventaspc.empresa.posesiones.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ventaspc.empresa.posesiones.Empleado;
import ventaspc.empresa.posesiones.RegistroCompra;
import ventaspc.Sistema;
/**
 *
 * @author Ivan
 */
public class Empresa {
    private ArrayList<Producto> productos;//Lista de productos
    private ArrayList<Cliente> clientes;//Lista de clientes
    private ArrayList<Empleado> empleados;//Lista de empleados
    private ArrayList<RegistroCompra> compras;//Lista de compras/ventas
    private int numVentas;
    private int usuarioPos;
    private double ingreso;
    
    public Empresa(){//Instancia de las clases
        clientes = new ArrayList<Cliente>();
        productos = new ArrayList<Producto>();
        compras = new ArrayList<RegistroCompra>();
        empleados = new ArrayList<Empleado>();
        numVentas = 0;
        ingreso = 0;
    }
    
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    public ArrayList<RegistroCompra> getCompras(){
        return compras;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    
    public void setIngreso(double ingresoCliente){
        ingreso += ingresoCliente;
    }
    //Método para crear un nuevo cliente. Recibe como parámetros los datos que el cliente
    //debe tener. Regresa true si pudo ser creado. De lo contrario, al existir ya esa cédula,
    //no es posible ser creado.
    public boolean nuevoCliente(String nombre, String apellido, int cedula, String direccion, String ciudad, String telefono){
        for(int i=0; i<clientes.size(); i++){
            if(cedula == clientes.get(i).getCedula())
                return false;
        }
        clientes.add(new Cliente(nombre, apellido, cedula, direccion, ciudad, telefono));
        return true;
    }
    //Método para crear un nuevo producto. Recibe como parámetros los datos que el producto
    //debe tener. Regresa true si pudo ser creado. De lo contrario, al existir ya esa clave,
    //no es posible ser creado.
    public boolean nuevoProducto(String marca, String modelo, String color, double precio, int clave, String procesador, int ram, int hdd, String video, String audio){
        for(int i=0; i<productos.size(); i++){
            if(clave == productos.get(i).getClave())
                return false;
        }
        productos.add(new Computadora(marca, modelo, color, precio, clave, procesador, ram, hdd, video, audio));
        return true;
    }
    //Método utilizado para editar la información de un cliente ya creado en cierta posición.
    public boolean editarCliente(Cliente c, int pos){
        for(int i=0; i<clientes.size(); i++){
            if(pos != i){
                if(c.getCedula() == clientes.get(i).getCedula())
                    return false;
            }
        }
        clientes.set(pos,c);
        return true;
    }
    //Método para modificar los datos de un producto en una determinada posición.
    public boolean editarProducto(Producto p, int pos){
        for(int i=0; i<productos.size(); i++){
            if(pos != i){
                if(p.getClave() == productos.get(i).getClave())
                    return false;
            }
        }
        productos.set(pos,p);
        return true;
    }
    //Permite crear un nuevo usuario que tendrá acceso al sistema
    public boolean nuevoUsuario(String usuario, String contrasena, String puesto){
        for(int i=0; i<empleados.size(); i++){
            if(usuario.equalsIgnoreCase(empleados.get(i).getUsuario()))
                return false;
        }
        empleados.add(new Empleado(usuario, contrasena, puesto));
        return true;
    }
    //Añadir un nuevo objeto en el ArrayList compras. Incluye algunos datos del cliente y del producto
    public void nuevaCompra(String nombre, String apellido, int cedula, String marca, String modelo, double precio, int clave){
        compras.add(new RegistroCompra(nombre,apellido,cedula,marca,modelo,precio,clave));
    }
    //Regresa el tamaño de los arraylists
    public int sizeClientes(){
        return clientes.size();
    }
    
    public int sizeProductos(){
        return productos.size();
    }
    
    public int sizeEmpleados(){
        return empleados.size();
    }
    
    public double getIngreso(){
        return ingreso;
    }

    /**
     * @return the numVentas
     */
    public int getNumVentas() {
        return numVentas;
    }

    /**
     * @param numVentas the numVentas to set
     */
    public void setNumVentas(int numVentas) {
        this.numVentas += numVentas;
    }
   
}
