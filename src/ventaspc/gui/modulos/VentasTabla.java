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
import javax.swing.table.DefaultTableModel;
import ventaspc.empresa.posesiones.RegistroCompra;
import ventaspc.Sistema;
public class VentasTabla extends PanelBase{
    private JButton regresar;
    private JButton editar;
    private JButton eliminar;
    private JButton buscar;
    
    public VentasTabla(Sistema sistema){
        super(sistema);
        add(tabla(),BorderLayout.CENTER);
        setVisible(true);
    }
    //Panel que muestra la tabla
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        String[] columnNames = {"Nombre", "Apellido", "Cédula", "Marca", "Modelo","Precio","Clave"};
        
        final DefaultTableModel tableModel = new DefaultTableModel(getModeloDatos(), columnNames);
        final JTable table = new JTable(getModeloDatos(), columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        pnl.add(scrollPane);
        //Se añaden los botones al panel
        regresar = new JButton("Regresar");
        eliminar = new JButton("Eliminar");
        add(regresar);
        add(eliminar);
        
        //Event-handles para los botones de Regresar, Eliminar y Buscar
        regresar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
               sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        
        eliminar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               eliminarVenta(table,tableModel);
           } 
        });
        
        return pnl;
    }
    
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
    
    public void eliminarVenta(JTable table, DefaultTableModel tableModel){
        int pos = table.getSelectedRow();
        
        int seleccion = JOptionPane.showOptionDialog(this, "¿Desea eliminar esta venta?", "Eliminar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
        if (seleccion == 0){
            sistema.getEmpresa().getCompras().remove(pos);
            sistema.getGuardar().guardarVentas(sistema, this);
            tableModel.removeRow(table.getSelectedRow());
            JOptionPane.showMessageDialog(this,"Venta eliminada");
        }
    }
    
    public void buscarVenta(JTable table){
        JTextField nombre = new JTextField();
        JTextField marca = new JTextField();
        Object[] mensaje = {
            "Busca la venta por comprador o computadora","",
            "Nombre:", nombre,
            "Marca:", marca
        };

        int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Buscar", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            for (int i=0; i<sistema.getEmpresa().getCompras().size(); i++){
                if (nombre.getText().equalsIgnoreCase(sistema.getEmpresa().getCompras().get(i).getNombre()) || marca.getText().equalsIgnoreCase(sistema.getEmpresa().getCompras().get(i).getMarca())) {
                    table.changeSelection(i, 0, false, false);
                    JOptionPane.showMessageDialog(this,"Encontrado");
                    return;
                } 
            }
        } 
        JOptionPane.showMessageDialog(this, "No se encontró");
    }

 }

