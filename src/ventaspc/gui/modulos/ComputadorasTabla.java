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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ventaspc.Sistema;
public class ComputadorasTabla extends PanelBase{
    private JButton regresar;
    private JButton editar;
    private JButton eliminar;
    private JButton buscar;
    
    public ComputadorasTabla(Sistema sistema){
        super(sistema);
        add(tabla(),BorderLayout.CENTER);
        setVisible(true);
    }
    //Panel que muestra la tabla
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        String[] columnNames = {"Marca", "Modelo", "Color", "Precio", "Clave", "Procesador","RAM","HDD","Tarjeta de video","Tarjeta de audio"};
        
        final DefaultTableModel tableModel = new DefaultTableModel(getModeloDatos(), columnNames);
        final JTable table = new JTable();
        table.setModel(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        table.setFillsViewportHeight(true);
        

        JScrollPane scrollPane = new JScrollPane(table);
        pnl.add(scrollPane);
        //Se añaden los botones al panel
        regresar = new JButton("Regresar");
        eliminar = new JButton("Eliminar");
        buscar = new JButton("Buscar");
        editar = new JButton("Editar");
        add(regresar);
        add(eliminar);
        add(buscar);
        add(editar);
        //Event-handles para los botones de Regresar, Eliminar, Editar y Buscar
        regresar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
               sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        
        eliminar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               eliminarComputadora(table,tableModel);
           } 
        });
        
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                editarComputadora(table);
            }
        });
        
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarComputadora(table);
            }
        });
        
        return pnl;
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
    //Método para eliminar una computadora
    public void eliminarComputadora(JTable table, DefaultTableModel tableModel){
        int pos = table.getSelectedRow();
        
        int seleccion = JOptionPane.showOptionDialog(this, "¿Desea eliminar esta computadora?", "Eliminar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
        if (seleccion == 0){
            sistema.getEmpresa().getProductos().remove(pos);
            sistema.getGuardar().guardarProductos(sistema, this);
            tableModel.removeRow(table.getSelectedRow());
            JOptionPane.showMessageDialog(this,"Producto eliminado");
        }
    }
    //Método para editar una computadora
    public void editarComputadora(JTable table){
        try{
            int pos = table.getSelectedRow();
            sistema.mostrarDialogo(PanelBase.PANEL_REGISTROCOMPUTADORA,this,pos,table);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"Selecciona una computadora a editar");
        }
       
    }
    //Método para buscar una computadora
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
 }

