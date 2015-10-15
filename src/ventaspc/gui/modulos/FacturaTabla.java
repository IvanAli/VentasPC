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
import ventaspc.gui.modulos.PrincipalPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ventaspc.empresa.posesiones.RegistroCompra;
import ventaspc.Sistema;
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.empresa.posesiones.Producto;
import ventaspc.factura.Factura;
public class FacturaTabla extends PanelBase{
    private JButton regresar;
    private JButton facturar;
    
    public FacturaTabla(Sistema sistema){
        super(sistema);
        add(tabla(),BorderLayout.CENTER);
        setVisible(true);
    }
    //Panel que muestra la tabla
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        String[] columnNames = {"Nombre", "Apellido", "Cédula", "Marca", "Modelo","Precio","Clave"};

        final JTable table = new JTable(getModeloDatos(), columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        pnl.add(scrollPane);
        
        regresar = new JButton("Regresar");
        facturar = new JButton("Facturar");
        add(regresar);
        add(facturar);
        regresar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        facturar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               factura(table);
               //sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        
        return pnl;
    }
    //Método usado como parámetro para el constructor de JTable
    public Object[][] getModeloDatos(){
        int size = sistema.getEmpresa().getCompras().size();
        Object[][] datos = new Object[size][7];
        RegistroCompra c = null;
            for(int i=0; i<size; i++){
                c = sistema.getEmpresa().getCompras().get(i);
                datos[i] = new Object[]{
                    c.getNombre(),c.getApellido(),c.getCedula(),c.getMarca(),c.getModelo(),c.getPrecio(),c.getClave()
                };
            }
            return datos;
    }
    //Método para instanciar de la clase Factura, y así generar una factura en pdf
    public void factura(JTable table){
        Cliente c;
        Producto p;
        double precio=0;
        try{
            c = busquedaCliente(table);
            p = busquedaProducto(table);
            
            Factura factura = new Factura(c,p);
            JOptionPane.showMessageDialog(this, "Factura creada");
            
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No se ha seleccionado una computadora");
        }
    }
    //Método para hallar el producto en el ArrayList de la fila seleccionada
    public Producto busquedaProducto(JTable table){
        for (int i=0; i<sistema.getEmpresa().getProductos().size(); i++){
            if ((int)table.getValueAt(table.getSelectedRow(), 6) == sistema.getEmpresa().getProductos().get(i).getClave()){
                return sistema.getEmpresa().getProductos().get(i);
            }
        }
        return null;
    }
    //Método para hallar el cliente en el ArrayList de la fila seleccionada
    public Cliente busquedaCliente(JTable table){
        for (int i=0; i<sistema.getEmpresa().getClientes().size(); i++){
            if ((int)table.getValueAt(table.getSelectedRow(), 2) == sistema.getEmpresa().getClientes().get(i).getCedula()){
                return sistema.getEmpresa().getClientes().get(i);
            }
        }
        return null;
    }

 }

