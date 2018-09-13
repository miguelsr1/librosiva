/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas.paneles;

import com.controles.dibujadorDeColumna.NumerosRenderer;
import com.controles.editorDeColumna.NumeroEdit;
import com.controles.editorDeColumna.SucursalEdit;
import com.entidades.Sucursal;
import com.entidades.VentaConsumidor;
import com.servicio.ServSucursal;
import com.servicio.ServVtaConsumidorF;
import com.utilidades.AccesoAVtaPadre;
import com.utilidades.AdministradorEntidades;
import com.utilidades.OperacionMatematica;
import com.utilidades.OperacionesGUI;
import com.vistas.VtnaSuma;
import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author misanchez
 */
public class V_LibroVtaConF extends JPanel implements Persistencia {

    public V_LibroVtaConF() {
        initComponents();
        if (!Beans.isDesignTime()) {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
        }

        OperacionesGUI.setRender(masterTable);

        masterTable.setCellEditor(10, new SucursalEdit(false));

        masterTable.setCellEditor(1, new NumeroEdit(false, JTextField.LEFT));
        masterTable.setCellEditor(2, new NumeroEdit(false, JTextField.LEFT));
        masterTable.setCellEditor(3, new NumeroEdit(false, JTextField.LEFT));

        masterTable.setCellEditor(5, new NumeroEdit(true, JTextField.RIGHT));
        masterTable.setCellEditor(6, new NumeroEdit(true, JTextField.RIGHT));
        masterTable.setCellEditor(7, new NumeroEdit(true, JTextField.RIGHT));
        masterTable.setCellEditor(8, new NumeroEdit(true, JTextField.RIGHT));
        masterTable.setCellEditor(9, new NumeroEdit(true, JTextField.RIGHT));

        masterTable.setCellEditor(10, new SucursalEdit(false));

        masterTable.setCellRenderer(5, new NumerosRenderer());
        masterTable.setCellRenderer(6, new NumerosRenderer());
        masterTable.setCellRenderer(7, new NumerosRenderer());
        masterTable.setCellRenderer(8, new NumerosRenderer());
        masterTable.setCellRenderer(9, new NumerosRenderer());
        
        masterTable.setColsSumar("8=5+6+7");
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

        entityManager = AdministradorEntidades.getInstance().getEM();
        listVentaF = ServVtaConsumidorF.getListado();
        listSucursal = ServSucursal.getListado();
        diaVtaConFLabel = new javax.swing.JLabel();
        desdeLabel = new javax.swing.JLabel();
        hastaLabel = new javax.swing.JLabel();
        maquinaLabel = new javax.swing.JLabel();
        vtaExenConFLabel = new javax.swing.JLabel();
        vtaGravConFLabel = new javax.swing.JLabel();
        exporVtaConFLabel = new javax.swing.JLabel();
        totalVtaConFLabel = new javax.swing.JLabel();
        tercerosVtaConFLabel = new javax.swing.JLabel();
        codigoSucursalLabel = new javax.swing.JLabel();
        diaVtaConFLabel1 = new javax.swing.JLabel();
        numVtaFField = new com.controles.JXTextFiled();
        diaVtaConFField = new com.controles.JXTextFiled();
        desdeField = new com.controles.JXTextFiled();
        hastaField = new com.controles.JXTextFiled();
        maquinaField = new com.controles.JXTextFiled();
        vtaExenConFField = new com.controles.JXTextFiled();
        vtaGravConFField = new com.controles.JXTextFiled();
        exporVtaConFField = new com.controles.JXTextFiled();
        totalVtaConFField = new com.controles.JXTextFiled();
        tercerosVtaConFField = new com.controles.JXTextFiled();
        codigoSucursalCBox = new com.controles.JXComboBox();
        jLabel1 = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new com.controles.JXTable();

        FormListener formListener = new FormListener();

        diaVtaConFLabel.setText("Día:");

        desdeLabel.setText("Desde:");

        hastaLabel.setText("Hasta:");

        maquinaLabel.setText("Maquina:");

        vtaExenConFLabel.setText("Locales Exentas:");

        vtaGravConFLabel.setText("Locales Gravadas:");

        exporVtaConFLabel.setText("Exportación:");

        totalVtaConFLabel.setText("Total de Ventas:");

        tercerosVtaConFLabel.setText("Ventas a Terceros:");

        codigoSucursalLabel.setText("Sucursal:");

        diaVtaConFLabel1.setText("#:");

        numVtaFField.setNumero(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.numVtaF}"), numVtaFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), numVtaFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        diaVtaConFField.setNumero(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.diaVtaConF}"), diaVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), diaVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        diaVtaConFField.addFocusListener(formListener);

        desdeField.setNumero(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.desde}"), desdeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), desdeField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        hastaField.setNumero(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hasta}"), hastaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), hastaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.maquina}"), maquinaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), maquinaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        vtaExenConFField.setDecimal(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.vtaExenConF}"), vtaExenConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), vtaExenConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        vtaGravConFField.setDecimal(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.vtaGravConF}"), vtaGravConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), vtaGravConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        exporVtaConFField.setDecimal(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.exporVtaConF}"), exporVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), exporVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        totalVtaConFField.setDecimal(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.totalVtaConF}"), totalVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), totalVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        totalVtaConFField.addFocusListener(formListener);

        tercerosVtaConFField.setDecimal(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tercerosVtaConF}"), tercerosVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), tercerosVtaConFField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listSucursal, codigoSucursalCBox);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoSucursal}"), codigoSucursalCBox, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoSucursalCBox, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 3, 11)); // NOI18N
        jLabel1.setText("Lista de ventas al consumidor final:");

        masterScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        masterScrollPane.setAutoscrolls(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listVentaF, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numVtaF}"));
        columnBinding.setColumnName("#");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${diaVtaConF}"));
        columnBinding.setColumnName("Día");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${desde}"));
        columnBinding.setColumnName("Desde");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hasta}"));
        columnBinding.setColumnName("Hasta");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maquina}"));
        columnBinding.setColumnName("Maquina");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vtaExenConF}"));
        columnBinding.setColumnName("Locales Exentas");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vtaGravConF}"));
        columnBinding.setColumnName("Locales Gravadas");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${exporVtaConF}"));
        columnBinding.setColumnName("Exportación");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalVtaConF}"));
        columnBinding.setColumnName("Total de Ventas");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tercerosVtaConF}"));
        columnBinding.setColumnName("Ventas a Terceros");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoSucursal}"));
        columnBinding.setColumnName("Sucursal");
        columnBinding.setColumnClass(com.entidades.Sucursal.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        masterTable.getColumnModel().getColumn(5).setPreferredWidth(130);
        masterTable.getColumnModel().getColumn(6).setPreferredWidth(130);
        masterTable.getColumnModel().getColumn(7).setPreferredWidth(130);
        masterTable.getColumnModel().getColumn(8).setPreferredWidth(130);
        masterTable.getColumnModel().getColumn(9).setPreferredWidth(130);
        masterTable.getColumnModel().getColumn(10).setPreferredWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(diaVtaConFLabel1)
                                    .addComponent(maquinaLabel)
                                    .addComponent(totalVtaConFLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(totalVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(tercerosVtaConFLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(maquinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(vtaExenConFLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(numVtaFField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(diaVtaConFLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tercerosVtaConFField, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(vtaExenConFField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(vtaGravConFLabel)
                                            .addComponent(codigoSucursalLabel)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(diaVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                        .addComponent(desdeLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codigoSucursalCBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(vtaGravConFField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(exporVtaConFLabel))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(desdeField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(hastaLabel)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hastaField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(exporVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(masterScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaVtaConFLabel)
                    .addComponent(desdeLabel)
                    .addComponent(desdeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hastaLabel)
                    .addComponent(hastaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaVtaConFLabel1)
                    .addComponent(numVtaFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vtaExenConFLabel)
                    .addComponent(vtaExenConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vtaGravConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exporVtaConFLabel)
                    .addComponent(exporVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vtaGravConFLabel)
                    .addComponent(maquinaLabel)
                    .addComponent(maquinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tercerosVtaConFLabel)
                    .addComponent(tercerosVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoSucursalLabel)
                    .addComponent(codigoSucursalCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalVtaConFLabel)
                    .addComponent(totalVtaConFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.FocusListener, java.awt.event.MouseListener {
        FormListener() {}
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == totalVtaConFField) {
                V_LibroVtaConF.this.totalVtaConFFieldFocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == diaVtaConFField) {
                V_LibroVtaConF.this.diaVtaConFFieldFocusLost(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                V_LibroVtaConF.this.masterTableMouseClicked(evt);
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

    private void diaVtaConFFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_diaVtaConFFieldFocusLost
    }//GEN-LAST:event_diaVtaConFFieldFocusLost

    private void totalVtaConFFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalVtaConFFieldFocusGained
        totalVtaConFField.setText(String.valueOf(OperacionMatematica.getResultadoSumaFloat(vtaExenConFField, vtaGravConFField, exporVtaConFField)));
    }//GEN-LAST:event_totalVtaConFFieldFocusGained

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        //((VtnaProceso) this.getParent().getParent().getParent().getParent()).setEnableBotonBorrar(deleteButton.isEnabled());
    }//GEN-LAST:event_masterTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.controles.JXComboBox codigoSucursalCBox;
    private javax.swing.JLabel codigoSucursalLabel;
    private com.controles.JXTextFiled desdeField;
    private javax.swing.JLabel desdeLabel;
    private com.controles.JXTextFiled diaVtaConFField;
    private javax.swing.JLabel diaVtaConFLabel;
    private javax.swing.JLabel diaVtaConFLabel1;
    private javax.persistence.EntityManager entityManager;
    private com.controles.JXTextFiled exporVtaConFField;
    private javax.swing.JLabel exporVtaConFLabel;
    private com.controles.JXTextFiled hastaField;
    private javax.swing.JLabel hastaLabel;
    private javax.swing.JLabel jLabel1;
    private java.util.List<com.entidades.Sucursal> listSucursal;
    private java.util.List<com.entidades.VentaConsumidor> listVentaF;
    private com.controles.JXTextFiled maquinaField;
    private javax.swing.JLabel maquinaLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private com.controles.JXTable masterTable;
    private com.controles.JXTextFiled numVtaFField;
    private com.controles.JXTextFiled tercerosVtaConFField;
    private javax.swing.JLabel tercerosVtaConFLabel;
    private com.controles.JXTextFiled totalVtaConFField;
    private javax.swing.JLabel totalVtaConFLabel;
    private com.controles.JXTextFiled vtaExenConFField;
    private javax.swing.JLabel vtaExenConFLabel;
    private com.controles.JXTextFiled vtaGravConFField;
    private javax.swing.JLabel vtaGravConFLabel;
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
            java.util.logging.Logger.getLogger(V_LibroVtaConF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_LibroVtaConF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_LibroVtaConF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_LibroVtaConF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new V_LibroVtaConF());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private boolean existeResgitro() {
        return false;
    }

    @Override
    public void guardar() {
        if (!existeResgitro()) {
            try {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().rollback();
                entityManager.getTransaction().begin();
                List<com.entidades.VentaConsumidor> merged = new ArrayList<com.entidades.VentaConsumidor>(listVentaF.size());
                for (com.entidades.VentaConsumidor v1 : listVentaF) {
                    merged.add(entityManager.merge(v1));
                }
                listVentaF.clear();
                listVentaF.addAll(merged);
            } finally {
            }
        }
    }

    @Override
    public void eliminar() {
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar este registro?",
                "Operación de eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            int[] selected = masterTable.getSelectedRows();
            List<com.entidades.VentaConsumidor> toRemove = new ArrayList<com.entidades.VentaConsumidor>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                com.entidades.VentaConsumidor v1 = listVentaF.get(masterTable.convertRowIndexToModel(selected[idx]));
                v1.setEliminado(true);
                toRemove.add(v1);

                if (v1.getIdVentaConF() != null);
                guardar();
            }
            listVentaF.removeAll(toRemove);
        }
    }

    @Override
    public void actualizar() {
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.List<VentaConsumidor> data = ServVtaConsumidorF.getListado();
        for (VentaConsumidor entity : data) {
            entityManager.refresh(entity);
        }
        listVentaF.clear();
        listVentaF.addAll(data);
    }

    @Override
    public void nuevo() {
        com.entidades.VentaConsumidor vNew = new com.entidades.VentaConsumidor();
        int num;
        if (masterTable.getRowCount() != 0) {
            num = listVentaF.get(masterTable.getRowCount() - 1).getNumVtaF() + 1;
        } else {
            num = 1;
        }

        vNew.setNumVtaF(num);
        vNew.setMesAnhoVtaCf(System.getProperty("mes").concat(System.getProperty("anho")));
        vNew.setCodigoSucursal((Sucursal) codigoSucursalCBox.getSelectedItem());
        vNew.setIdUsuario(AccesoAVtaPadre.getUsuario());
        vNew.setEliminado(false);

        entityManager.persist(vNew);
        listVentaF.add(vNew);
        int row = listVentaF.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        masterTable.requestFocus();
        masterTable.changeSelection(row, 1, false, false);
    }

    @Override
    public void suma() {
        VtnaSuma sum = new VtnaSuma(AccesoAVtaPadre.vtaPadre, true);

        sum.add(new V_SumVtaConFinal());
        sum.pack();
        sum.setLocationRelativeTo(this);
        sum.setVisible(true);

        System.gc();
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