/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.gui.modulos;

import ventaspc.Sistema;

/**
 *
 * @author Ivan
 */
public class PanelBase extends javax.swing.JPanel{
    public static final String PANEL_INICIO = "Inicio";
    public static final String PANEL_NUEVOCLIENTE = "Nuevo Cliente";
    public static final String PANEL_REGISTROCOMPUTADORA = "Registro Computadora";
    public static final String PANEL_COMPRACOMPUTADORA = "Compra Computadora";
    public static final String PANEL_COMPRACOMPUTADORATABLA = "Compra Computadora Tabla";
    public static final String PANEL_VENTASTABLA = "Ventas Tabla";
    public static final String PANEL_COMPUTADORASTABLA = "Computadoras Tabla";
    public static final String PANEL_FACTURATABLA = "Factura Tabla";
    public static final String PANEL_CLIENTESTABLA = "Clientes Tabla";
    public static final String PANEL_REGISTROUSUARIO = "Registro Usuario";
    protected Sistema sistema;
  
    public PanelBase(Sistema sistema){
        this.sistema = sistema;
    }
}
