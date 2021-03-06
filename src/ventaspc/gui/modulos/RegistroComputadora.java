/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.gui.modulos;

import javax.swing.JButton;
import ventaspc.gui.modulos.PrincipalPanel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ventaspc.Sistema;

/**
 *
 * @author Ivan
 */
public class RegistroComputadora extends PanelBase {

    /**
     * Creates new form RegistroComputadora
     */
    public RegistroComputadora(Sistema sistema) {
        super(sistema);
        initComponents();
    }
    
    public void limpiaDatos(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtPrecio.setText("");
        txtClave.setText("");
        txtColor.setText("");
        txtProcesador.setText("");
        txtHdd.setText("");
        txtRam.setText("");
        txtVideo.setText("");
        txtAudio.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtProcesador = new javax.swing.JTextField();
        txtHdd = new javax.swing.JTextField();
        txtVideo = new javax.swing.JTextField();
        txtAudio = new javax.swing.JTextField();
        btnGuardarComputadora = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtRam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();

        jLabel1.setText("Marca:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Color:");

        jLabel4.setText("Procesador:");

        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("HDD (gb):");
        jLabel5.setToolTipText("Número entero únicamente");

        jLabel6.setText("Tarjeta de Video:");

        jLabel7.setText("Tarjeta de Audio:");

        txtVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVideoActionPerformed(evt);
            }
        });

        btnGuardarComputadora.setText("Guardar");
        btnGuardarComputadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComputadoraActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("RAM (gb):");
        jLabel8.setToolTipText("Número entero únicamente");

        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Precio:");
        jLabel9.setToolTipText("Cantidad con número");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(51, 153, 255));
        jLabel10.setText("Clave:");
        jLabel10.setToolTipText("Número entero únicamente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarComputadora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHdd, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRam)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnGuardarComputadora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //Guardado de una nueva computadora en el arreglo de productos en Empresa
    private void btnGuardarComputadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComputadoraActionPerformed
        // TODO add your handling code here:
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String color = txtColor.getText();
        String procesador = txtProcesador.getText();
        String video = txtVideo.getText();
        String audio = txtAudio.getText();
        
        
        if (marca.equals("") || modelo.equals("") || txtHdd.getText().equals("") || txtRam.getText().equals("") ||
        color.equals("") || procesador.equals("") || video.equals("") || audio.equals("")){
            JOptionPane.showMessageDialog(this,"Hay campo(s) vacio(s)");
            return;
        }
        try{
            int clave = Integer.valueOf(txtClave.getText());
            int hdd = Integer.valueOf(txtHdd.getText());
            int ram = Integer.valueOf(txtRam.getText());
            double precio = Double.valueOf(txtPrecio.getText());

            if (sistema.getEmpresa().nuevoProducto(marca, modelo, color, precio, clave, procesador, ram, hdd, video, audio)){
                sistema.getGuardar().guardarProductos(sistema, null);
                JOptionPane.showMessageDialog(this,"Guardado");
                limpiaDatos();
            }
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Número(s) inválido(s)");
            return;
        }
    }//GEN-LAST:event_btnGuardarComputadoraActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        sistema.mostrarPanel(PANEL_INICIO);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVideoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVideoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarComputadora;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAudio;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtHdd;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProcesador;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtVideo;
    // End of variables declaration//GEN-END:variables
}
