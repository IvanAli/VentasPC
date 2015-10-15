/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc;

import ventaspc.gui.modulos.dialogos.RegistroComputadora_Editar;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ventaspc.menu.Guardar;
import ventaspc.menu.Exportar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import ventaspc.empresa.Empresa;
import ventaspc.gui.modulos.NuevoCliente;
import ventaspc.gui.VentanaPC;
import ventaspc.gui.modulos.*;
import ventaspc.gui.modulos.dialogos.NuevoCliente_Editar;
import ventaspc.menu.Cargar;

/**
 *
 * @author Ivan
 */
public class Sistema {
    //Referencia a las clases que el sistema estará manejando. Empresa contiene muchos
    //de los métodos para crear clientes, productos, ventas, etc. VentanaPC representa
    //el JFrame en el que se mostrarán los módulos. PanelBase se utiliza como la clase
    //de la cual heredan todos los módulos. El JDialog (panelDialog) es para ventanas
    //que no se mostrarán en el mismo JFrame.
    private Empresa empresa;
    private VentanaPC principal;
    private PanelBase panelActual;
    private JDialog panelDialog;
    //Atributos para guardar, exportar, cargar
    private Guardar guardar;
    private Exportar exportar;
    private Cargar cargar;
    //Login Dialog
    private LoginDialog login;
    
    public Sistema(){
        //Instancia del JFrame principal, que recibe como parámetro una referencia a
        //la clase Sistema. Instancia de la clase Empresa.
        principal = new VentanaPC(this);
        empresa = new Empresa();
        
        //Instancia de clases para guardar, exportar
        guardar = new Guardar();
        exportar = new Exportar();
        cargar = new Cargar();
    }
    //Método para instanciar el módulo por ser mostrado
    public void mostrarPanel(String panel){
        panelActual = null;
        switch(panel){
            case PanelBase.PANEL_INICIO:
                panelActual = new PrincipalPanel(this);
                break;
            case PanelBase.PANEL_NUEVOCLIENTE:
                panelActual = new NuevoCliente(this);
                break;
            case PanelBase.PANEL_REGISTROCOMPUTADORA:
                panelActual = new RegistroComputadora(this);
                break;
            case PanelBase.PANEL_COMPRACOMPUTADORA:
                panelActual = new CompraComputadora(this);
                break;
            case PanelBase.PANEL_COMPUTADORASTABLA:
                panelActual = new ComputadorasTabla(this);
                break;
            case PanelBase.PANEL_VENTASTABLA:
                panelActual = new VentasTabla(this);
                break;
            case PanelBase.PANEL_FACTURATABLA:
                panelActual = new FacturaTabla(this);
                break;
            case PanelBase.PANEL_REGISTROUSUARIO:
                panelActual = new PanelUsuarios(this);
                break;
            case PanelBase.PANEL_CLIENTESTABLA:
                panelActual = new ClientesTabla(this);
                break;
            default:
                break;
        }
        if (panelActual == null)
            panelActual = new PrincipalPanel(this);
        //mostrarPanel() permite la revalidación del panel que se ha pasado al atributo
        //panelActual en el switch
        principal.mostrarPanel(panelActual);
    }
    
    public void mostrarDialogo(String panel, PanelBase pnl, int pos, JTable table){
        panelDialog = new JDialog();
        panelDialog.setModal(true);
        panelDialog.setSize(550,380);
        panelDialog.setLocationRelativeTo(pnl);
        //A diferencia de mostrarPanel(), mostrarDialogo() mostrará un JDialog con el panel
        switch(panel){
            case PanelBase.PANEL_REGISTROCOMPUTADORA:
                panelDialog.add(new RegistroComputadora_Editar(this,getEmpresa().getProductos().get(pos),pos,table));
                panelDialog.setVisible(true);
                break;
            case PanelBase.PANEL_NUEVOCLIENTE:
                panelDialog.add(new NuevoCliente_Editar(this,getEmpresa().getClientes().get(pos),pos,table));
                panelDialog.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void mostrarPanelCedula(String panel, int cedula){
        //Método único utilizado para agregar un parámetro más al constructor de
        //la clase ComputadorasTablaComputadora
        panelActual = null;
        switch(panel){
            case PanelBase.PANEL_COMPRACOMPUTADORATABLA:
                panelActual = new ComputadorasTablaCompra(this,cedula);
                break;
            default:
                break;
        }
        if (panelActual == null)
            panelActual = new PrincipalPanel(this);
        
        principal.mostrarPanel(panelActual);
    }
    
    //Métodos get
    public Empresa getEmpresa(){
        return empresa;
    }
    
    public Guardar getGuardar(){
        return guardar;
    }
    
    public Exportar getExportar(){
        return exportar;
    }
    //Método para cargar todos los datos .dat. La clase Cargar contiene los métodos
    //que cargan cada uno de los archivos de datos
    public void cargaDatos(){
        cargar.cargarClientes(this);
        cargar.cargarProductos(this);
        cargar.cargarVentaIngreso(this);
        cargar.cargarVentas(this);
        cargar.cargarEmpleados(this);
    }
    //Método con el que arranca el programa
    public void arrancar(){
        cargaDatos();//Primero se cargan los datos
        loginScreen();//Se muestran la pantalla de login
        mostrarPanel(PanelBase.PANEL_INICIO);//Tras ser dispuesto el dialog de login, se inicia con PrincipalPanel
        principal.setVisible(true);//Mostrar visible
    }
    //Creación del diálogo de login
    public void loginScreen(){
        JDialog login = new JDialog();
        //LoginDialog es el panel que pintará al diálogo login
        login.setContentPane(new LoginDialog(login,this));//Recibe al diálogo y a Sistema como parámetros
        login.setSize(275,285);
        login.setModal(true);
        login.setTitle("Log in");
        login.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//La ventana no se cierra con el botón de la esquina
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}

