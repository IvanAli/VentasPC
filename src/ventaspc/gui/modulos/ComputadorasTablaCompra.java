/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.gui.modulos;

/**
 *
 * @author Ivan
 */
import ventaspc.empresa.posesiones.Producto;
import ventaspc.gui.modulos.PrincipalPanel;
import ventaspc.empresa.posesiones.Cliente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import ventaspc.Sistema;
import ventaspc.factura.Factura;
public class ComputadorasTablaCompra extends PanelBase{
    private JButton comprar;
    private JButton regresar;
    private JButton buscar;
    private int cedula;
    
    public ComputadorasTablaCompra(Sistema sistema, int cedula){
        super(sistema);
        add(tabla(),BorderLayout.CENTER);
        //ver();
        //pack();
        setVisible(true);
        this.cedula = cedula;
    }
    //Panel que muestra la tabla
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        String[] columnNames = {"Marca", "Modelo", "Color", "Precio", "Clave", "Procesador","RAM","HDD","Tarjeta de video","Tarjeta de audio"};

        final JTable table = new JTable(getModeloDatos(), columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        pnl.add(scrollPane);
        //Se añaden los botones al panel
        regresar = new JButton("Regresar");
        comprar = new JButton("Comprar");
        buscar = new JButton("Buscar");
        add(regresar);
        add(comprar);
        add(buscar);
        //Event-handles para los botones de Regresar, Comprar y Buscar
        regresar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        comprar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               comprar(table);
           } 
        });
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarComputadora(table);
            }
        });
        return pnl;
    }
    
    
    public void comprar(JTable table){
        Cliente c = null;
        Producto p = null;
        double precio=0;
        try{
            c = busquedaCliente(table);
            p = sistema.getEmpresa().getProductos().get(table.getSelectedRow());
            precio = p.getPrecio();
            
            //Codigo para la compra
            sistema.getEmpresa().nuevaCompra(c.getNombre(),c.getApellido(),c.getCedula(),p.getMarca(),p.getModelo(),p.getPrecio(),p.getClave());
            JOptionPane.showMessageDialog(this, "El cliente "
                    + "ha comprado exitosamente este producto.\n"
                    + "Producto: " + sistema.getEmpresa().getProductos().get(table.getSelectedRow()).getMarca() + " " + sistema.getEmpresa().getProductos().get(table.getSelectedRow()).getModelo() + "\n"
                    + "Ingreso para la empresa: " + precio);
            sistema.getGuardar().guardarVentas(sistema, null);
            sistema.getEmpresa().setIngreso(precio);
            sistema.getEmpresa().setNumVentas(1);
            guardarVentaIngreso();
            abrirMenuFacturar(c,p);
            sistema.mostrarPanel(PanelBase.PANEL_INICIO);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No se ha seleccionado una computadora");
        }
    }
    
    public void buscarComputadora(JTable table){
        JTextField marca = new JTextField();
        JTextField clave = new JTextField();
        Object[] mensaje = {
            "Marca:", marca,
            "Clave:", clave
        };

        int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Buscar", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            for (int i=0; i<sistema.getEmpresa().getProductos().size(); i++){
                try{
                    if (marca.getText().equalsIgnoreCase(sistema.getEmpresa().getProductos().get(i).getMarca()) && Integer.parseInt(clave.getText()) == sistema.getEmpresa().getProductos().get(i).getClave()) {
                        table.changeSelection(i, 0, false, false);
                        JOptionPane.showMessageDialog(this,"Encontrado");
                        return;
                    } 
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,"Número inválido");
                }
            }
        } 
        JOptionPane.showMessageDialog(this, "No se encontró el producto");
    }
    
    public Cliente busquedaCliente(JTable table){
        for (int i=0; i<sistema.getEmpresa().getClientes().size(); i++){
            if (cedula == sistema.getEmpresa().getClientes().get(i).getCedula()){
                return sistema.getEmpresa().getClientes().get(i);
            }
        }
        return null;
    }
    
    public void abrirMenuFacturar(Cliente c, Producto p){
        int seleccion = JOptionPane.showOptionDialog(this, "¿Desea generar la factura en pdf?", "Factura en pdf", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No","Cancelar"}, "Si");
        if (seleccion == 0){
            Factura factura = new Factura(c,p);
            JOptionPane.showMessageDialog(this, "Factura creada");
        }
    }
     
    public void guardarVentaIngreso(){
        try{
            FileOutputStream fos = new FileOutputStream("ingreso.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeDouble(sistema.getEmpresa().getIngreso());
            dos.writeInt(sistema.getEmpresa().getNumVentas());
            dos.close();
        }
        catch(IOException ex){

        }
    }
    public Object[][] getModeloDatos(){
        int size = sistema.getEmpresa().sizeProductos();
        Object[][] datos = new Object[size][10];
        Producto p = null;
        for(int i=0; i<size; i++){
            p = sistema.getEmpresa().getProductos().get(i);
            datos[i] = new Object[]{
                p.getMarca(),p.getModelo(),p.getColor(),p.getPrecio(),p.getClave(),p.getProcesador(),p.getRam(),p.getHdd(),p.getTarjetaVideo(),p.getTarjetaAudio()
            };
        }
        return datos;
    }

 }

