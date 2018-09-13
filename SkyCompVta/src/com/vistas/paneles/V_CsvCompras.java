/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas.paneles;

import com.servicio.ServCompras;
import com.servicio.ServVtaConsumidorF;
import com.servicio.ServVtaContribuyente;
import com.utilidades.AccesoAVtaPadre;
import com.utilidades.CSV;
import com.utilidades.ClientesMenor200;
import com.utilidades.Compras;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Microsoft User
 */
public class V_CsvCompras extends javax.swing.JDialog {

    /**
     * Creates new form V_CsvCompras
     */
    public V_CsvCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        cboTipoInforme = new javax.swing.JComboBox();
        cboPeriodo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        anhoChooser = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        btoArchivo = new javax.swing.JButton();
        btoAceptar = new javax.swing.JButton();
        btoSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generacion de archivo CVS");

        jLabel1.setText("1. Seleccione las siguientes opciones:");

        jLabel2.setText("b. Periodo:");

        jLabel6.setText("a. Tipo de informe:");

        cboTipoInforme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proveedores Inscritos en IVA", "Proveedores Excluidos en IVA", "Clientes", "Clientes (Facturas < $ 200.00)", "Mandante (Venta a Cuenta de Terceros)" }));

        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primer Semestre", "Segundo Semestre" }));

        jLabel3.setText("c. Año:");

        jLabel5.setText("d. Nombre de archivo:");

        jLabel4.setText("e. Ubicación del archivo a crear:");

        txtUbicacion.setFocusable(false);

        btoArchivo.setText("...");
        btoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoArchivoActionPerformed(evt);
            }
        });

        btoAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recursos/aceptar.png"))); // NOI18N
        btoAceptar.setText("Aceptar");
        btoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAceptarActionPerformed(evt);
            }
        });

        btoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recursos/salir.png"))); // NOI18N
        btoSalir.setText("Salir");
        btoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btoAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btoSalir))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btoArchivo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel6))
                                            .addGap(34, 34, 34))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(anhoChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboTipoInforme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboTipoInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(anhoChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btoArchivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoSalir)
                    .addComponent(btoAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoArchivoActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = file.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            txtUbicacion.setText(file.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_btoArchivoActionPerformed

    private void btoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAceptarActionPerformed
        if(txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Debe de ingresar un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(txtUbicacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Debe de seleccionar una ubicación válida", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            generarArchivo();
        }
    }//GEN-LAST:event_btoAceptarActionPerformed

    private void btoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btoSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(V_CsvCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_CsvCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_CsvCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_CsvCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                V_CsvCompras dialog = new V_CsvCompras(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser anhoChooser;
    private javax.swing.JButton btoAceptar;
    private javax.swing.JButton btoArchivo;
    private javax.swing.JButton btoSalir;
    private javax.swing.JComboBox cboPeriodo;
    private javax.swing.JComboBox cboTipoInforme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables

    private void generarArchivo() {
        try {
            String meses = getParametros(anhoChooser.getYear());
            switch (cboTipoInforme.getSelectedIndex()) {
                case 0:
                    meses = meses.concat(" and (importacion_gravada = 0 OR importacion_gravada is null) ");
                    executarConsultaSobreCompras(ServCompras.getListadoCSVCompras(meses), false);
                    break;
                case 1:
                    meses = meses.concat(" and (excluido_compra <> 0)  ");
                    executarConsultaSobreCompras(ServCompras.getListadoCSVCompras(meses), false);
                    break;
                case 2:
                    executarConsultaSobreCompras(ServVtaContribuyente.getListadoCSVClientes(meses), true);
                    break;
                case 3:
                    executarConsultaSobreClientes(ServVtaConsumidorF.getListadoCSVClientes(meses));
                    break;
                case 4:
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error en la generación del CSV!\n"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(V_CsvCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executarConsultaSobreCompras(List<Compras> listado, boolean venta) {
        if (!txtUbicacion.getText().isEmpty()) {
            (new CSV(venta)).crearArchivo(txtUbicacion.getText() + File.separator + txtNombre.getText().trim() + ".csv", listado, txtNombre.getText());
        } else {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Seleccione una ubicación valida!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void executarConsultaSobreClientes(List<ClientesMenor200> listado) {
        if (!txtUbicacion.getText().isEmpty()) {
            (new CSV()).crearArchivoClienteMenor200(txtUbicacion.getText() + File.separator + txtNombre.getText().trim() + ".csv", listado, txtNombre.getText());
        } else {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Seleccione una ubicación valida!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getParametros(int anho) {
        String parametros;

        switch (cboPeriodo.getSelectedIndex()) {
            case 0:
                parametros = "'01%d','02%d','03%d','04%d','05%d','06%d')";
                break;
            default:
                parametros = "'07%d','08%d','09%d','10%d','11%d','12%d')";
                break;
        }
        
        return String.format(parametros, anho, anho, anho, anho, anho, anho);
    }
}
