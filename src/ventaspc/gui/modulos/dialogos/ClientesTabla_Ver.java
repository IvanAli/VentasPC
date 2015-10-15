/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.gui.modulos.dialogos;

/**
 *
 * @author Ivan
 */
import ventaspc.gui.modulos.*;
import ventaspc.empresa.posesiones.Producto;
import ventaspc.gui.modulos.PrincipalPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ventaspc.Sistema;
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.empresa.posesiones.Empleado;

//Tabla utilizada únicamente para seleccionar un cliente
public class ClientesTabla_Ver extends PanelBase{
    private JButton seleccionar;
    private JButton buscar;
    private JTextField nom;
    private JTextField ced;
    private JDialog d;
    
    public ClientesTabla_Ver(Sistema sistema, JTextField nom, JTextField ced, JDialog d){
        super(sistema);
        this.nom = nom;
        this.ced = ced;
        this.d = d;
        add(tabla(),BorderLayout.CENTER);
        setVisible(true);
    }
    private Container tabla(){
        JPanel pnl = new JPanel(new GridLayout(2,0));
        String[] columnNames = {"Nombre","Apellido","Cédula","Dirección","Ciudad","Teléfono"};
        
        final DefaultTableModel tableModel = new DefaultTableModel(getModeloDatos(), columnNames);
        final JTable table = new JTable();
        table.setModel(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(470, 340));
        //table.setPreferredSize(new Dimension(20,100));
        table.setFillsViewportHeight(true);
        

        JScrollPane scrollPane = new JScrollPane(table);
        pnl.add(scrollPane);
        
        seleccionar = new JButton("Seleccionar");
        buscar = new JButton("Buscar");
        add(seleccionar);
        add(buscar);
        
        seleccionar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                llenarCampos(table);
                d.dispose();
           } 
        });
        
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarCliente(table);
            }
        });
        return pnl;
        }
    
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
    
    public void llenarCampos(JTable table){
        nom.setText((String)(table.getValueAt(table.getSelectedRow(),0)));
        ced.setText(String.valueOf((int)(table.getValueAt(table.getSelectedRow(),2))));
    }
    
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

