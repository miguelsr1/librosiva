/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas.paneles;

import com.entidades.TipoOrganizacion;
import com.utilidades.AccesoAVtaPadre;
import com.utilidades.AdministradorEntidades;
import com.utilidades.OperacionesGUI;
import com.vistas.VtnaProceso;
import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sanchez
 */
public class V_Organizacion extends JPanel implements Persistencia{
    
    private int idTipoOrg = 1;
    private String strLabel = "Listado de %s:";
    
    public V_Organizacion() {
        initComponents();
        if (!Beans.isDesignTime()) {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
        }
    }

    public V_Organizacion(int idTipoOrg) {
        this.idTipoOrg = idTipoOrg;

        initComponents();

        if (!Beans.isDesignTime()) {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
        }

        OperacionesGUI.setRender(masterTable);

        if (idTipoOrg == 1) {
            setTitulo("Clientes");
        } else {
            setTitulo("Proveedores");
        }
        masterTable.aplicacionFiltros(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        deleteButton = new javax.swing.JButton();
        entityManager = AdministradorEntidades.getInstance().getEM();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT o FROM Organizacion o WHERE o.idTipoOrg.idTipoOrg in(:idTipoOrg,3) and o.eliminado=0");
        query.setParameter("idTipoOrg", idTipoOrg);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jLabel1 = new javax.swing.JLabel();
        codigoOrgLabel = new javax.swing.JLabel();
        direccionOrgLabel = new javax.swing.JLabel();
        faxOrgLabel = new javax.swing.JLabel();
        nitOrgLabel = new javax.swing.JLabel();
        nombreOrgLabel = new javax.swing.JLabel();
        regIvaOrgLabel = new javax.swing.JLabel();
        telefonoOrgLabel = new javax.swing.JLabel();
        codigoOrgField = new com.controles.JXTextFiled();
        direccionOrgField = new com.controles.JXTextFiled();
        faxOrgField = new com.controles.JXTextFiled();
        nitOrgField = new com.controles.JXTextFiled();
        nombreOrgField = new com.controles.JXTextFiled();
        regIvaOrgField = new com.controles.JXTextFiled();
        telefonoOrgField = new com.controles.JXTextFiled();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new com.controles.JXTable();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recursos/edit-delete.png"))); // NOI18N
        deleteButton.setText("Borrar");
        deleteButton.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 3, 11)); // NOI18N
        jLabel1.setText("LBL");

        codigoOrgLabel.setText("Código:");

        direccionOrgLabel.setText("Direccion:");

        faxOrgLabel.setText("Fax:");

        nitOrgLabel.setText("NIT:");

        nombreOrgLabel.setText("Nombre:");

        regIvaOrgLabel.setText("Reg. IVA:");

        telefonoOrgLabel.setText("Teléfono:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoOrg}"), codigoOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.direccionOrg}"), direccionOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.faxOrg}"), faxOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nitOrg}"), nitOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombreOrg}"), nombreOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.regIvaOrg}"), regIvaOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonoOrg}"), telefonoOrgField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoOrg}"));
        columnBinding.setColumnName("Codigo Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreOrg}"));
        columnBinding.setColumnName("Nombre Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccionOrg}"));
        columnBinding.setColumnName("Direccion Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefonoOrg}"));
        columnBinding.setColumnName("Telefono Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${faxOrg}"));
        columnBinding.setColumnName("Fax Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nitOrg}"));
        columnBinding.setColumnName("Nit Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${regIvaOrg}"));
        columnBinding.setColumnName("Reg Iva Org");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(280);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(5).setPreferredWidth(140);
        masterTable.getColumnModel().getColumn(6).setPreferredWidth(110);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 3, 11)); // NOI18N
        jLabel2.setText("LBL");

        jCheckBox1.setText("Proveedor/Cliente");
        jCheckBox1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codigoOrgLabel)
                            .addComponent(direccionOrgLabel)
                            .addComponent(telefonoOrgLabel)
                            .addComponent(nitOrgLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(direccionOrgField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(nombreOrgLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonoOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nitOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(regIvaOrgLabel)
                            .addComponent(faxOrgLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(faxOrgField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regIvaOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoOrgLabel)
                    .addComponent(codigoOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreOrgLabel)
                    .addComponent(nombreOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionOrgLabel)
                    .addComponent(direccionOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoOrgLabel)
                    .addComponent(telefonoOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faxOrgLabel)
                    .addComponent(faxOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nitOrgLabel)
                    .addComponent(nitOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regIvaOrgLabel)
                    .addComponent(regIvaOrgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jCheckBox1) {
                V_Organizacion.this.jCheckBox1ActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                V_Organizacion.this.deleteButtonActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                V_Organizacion.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        ((VtnaProceso) this.getParent().getParent().getParent().getParent()).setEnableBotonBorrar(deleteButton.isEnabled());
    }//GEN-LAST:event_masterTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

   }//GEN-LAST:event_deleteButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        com.entidades.Organizacion o = list.get(masterTable.convertRowIndexToModel(masterTable.getSelectedRow()));
        
        if(jCheckBox1.isSelected()){
            o.setIdTipoOrg(entityManager.find(TipoOrganizacion.class, 3));
        }else{
            o.setIdTipoOrg(entityManager.find(TipoOrganizacion.class, idTipoOrg));
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.controles.JXTextFiled codigoOrgField;
    private javax.swing.JLabel codigoOrgLabel;
    private javax.swing.JButton deleteButton;
    private com.controles.JXTextFiled direccionOrgField;
    private javax.swing.JLabel direccionOrgLabel;
    private javax.persistence.EntityManager entityManager;
    private com.controles.JXTextFiled faxOrgField;
    private javax.swing.JLabel faxOrgLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.util.List<com.entidades.Organizacion> list;
    private javax.swing.JScrollPane masterScrollPane;
    private com.controles.JXTable masterTable;
    private com.controles.JXTextFiled nitOrgField;
    private javax.swing.JLabel nitOrgLabel;
    private com.controles.JXTextFiled nombreOrgField;
    private javax.swing.JLabel nombreOrgLabel;
    private javax.persistence.Query query;
    private com.controles.JXTextFiled regIvaOrgField;
    private javax.swing.JLabel regIvaOrgLabel;
    private com.controles.JXTextFiled telefonoOrgField;
    private javax.swing.JLabel telefonoOrgLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(V_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new V_Organizacion());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void guardar() {
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            List<com.entidades.Organizacion> merged = new ArrayList<com.entidades.Organizacion>(list.size());
            for (com.entidades.Organizacion o : list) {
                merged.add(entityManager.merge(o));
            }
            list.clear();
            list.addAll(merged);
        }
    }

    @Override
    public void eliminar() {
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar este registro?",
                "Operación de eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            int[] selected = masterTable.getSelectedRows();
            List<com.entidades.Organizacion> toRemove = new ArrayList<com.entidades.Organizacion>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                com.entidades.Organizacion c = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                c.setEliminado(true);
                toRemove.add(c);

                //if (c.getCodigoOrg() != null) {
                    guardar();
                //}
            }
            list.removeAll(toRemove);
        }
    }

    @Override
    public void actualizar() {
    }

    @Override
    public void nuevo() {
        com.entidades.Organizacion orgNew = new com.entidades.Organizacion();
        orgNew.setIdUsuario(AccesoAVtaPadre.getUsuario());
        orgNew.setIdTipoOrg(entityManager.find(TipoOrganizacion.class, idTipoOrg));
        orgNew.setEliminado(false);
        
        entityManager.persist(orgNew);
        list.add(orgNew);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        
        codigoOrgField.setSelectionEnd(0);
        codigoOrgField.setSelectionEnd(codigoOrgField.getText().length());
        codigoOrgField.requestFocus();
    }

    @Override
    public void suma() {
        
    }

    private void setTitulo(String titulo) {
        jLabel1.setText(titulo);
        jLabel2.setText(String.format(strLabel, titulo));
    }
    
    private Boolean enableEliminar = false;
    
    @Override
    public void setEnabledEliminar(Boolean eliminar) {
        this.enableEliminar = eliminar;
    }

    @Override
    public Boolean getEnabledEliminar() {
        return enableEliminar;
    }
}