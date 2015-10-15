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
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.empresa.posesiones.Empleado;
public class ClientesTabla extends PanelBase{
    private JButton regresar;
    private JButton editar;
    private JButton eliminar;
    private JButton buscar;
    
    public ClientesTabla(Sistema sistema){
        super(sistema);
        add(tabla(),BorderLayout.CENTER);
        setVisible(true);
    }
    //Panel que muestra la tabla
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        //Arreglo de string que representa los nombres en las columnas
        String[] columnNames = {"Nombre","Apellido","Cédula","Dirección","Ciudad","Teléfono"};
        //Modelo de la tabla que recibe las filas y columnas
        final DefaultTableModel tableModel = new DefaultTableModel(getModeloDatos(), columnNames);
        final JTable table = new JTable();
        //Creación de la tabla y asignación del modelo a la misma
        table.setModel(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        table.setFillsViewportHeight(true);
        //Scroll para la tabla
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
        //Event-handlers de los botones en la parte superior de la ventana
        regresar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
               sistema.mostrarPanel(PanelBase.PANEL_INICIO);
           } 
        });
        
        eliminar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               eliminarCliente(table,tableModel);
           } 
        });
        
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                editarCliente(table);
            }
        });
        
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarCliente(table);
            }
        });
        
        return pnl;
        }
    //Arreglo de Objetos que representan a las filas
    public Object[][] getModeloDatos(){
        int size = sistema.getEmpresa().getClientes().size();
        Object[][] datos = new Object[size][6];
        Cliente c = null;
        for(int i=0; i<size; i++){
            c = sistema.getEmpresa().getClientes().get(i);
            datos[i] = new Object[]{
                c.getNombre(),c.getApellido(),c.getCedula(),c.getDireccion(),c.getCiudad(),c.getTelefono()
            };
        }
        return datos;
    }
    //Método para eliminar a un cliente
    public void eliminarCliente(JTable table, DefaultTableModel tableModel){
        int pos = table.getSelectedRow();
        
        int seleccion = JOptionPane.showOptionDialog(this, "¿Desea eliminar este cliente?", "Eliminar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
        if (seleccion == 0){
            sistema.getEmpresa().getClientes().remove(pos);
            sistema.getGuardar().guardarClientes(sistema, this);
            tableModel.removeRow(table.getSelectedRow());
            JOptionPane.showMessageDialog(this,"Cliente eliminado");
        }
    }
    //Métdo para editar un cliente
    public void editarCliente(JTable table){
        try{
            int pos = table.getSelectedRow();
            sistema.mostrarDialogo(PanelBase.PANEL_NUEVOCLIENTE,this,pos,table);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"Selecciona un cliente a editar");
        }
    }
    //Método para buscar un cliente
    public void buscarCliente(JTable table){
        JTextField nombre = new JTextField();
        JTextField cedula = new JTextField();
        Object[] mensaje = {
            "Nombre:", nombre,
            "Cedula:", cedula
        };

        int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Buscar", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            for (int i=0; i<sistema.getEmpresa().getClientes().size(); i++){
                try{
                    if (nombre.getText().equalsIgnoreCase(sistema.getEmpresa().getClientes().get(i).getNombre()) && Integer.parseInt(cedula.getText()) == sistema.getEmpresa().getClientes().get(i).getCedula()) {
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
        JOptionPane.showMessageDialog(this, "No se encontró el cliente");
    }
 }

