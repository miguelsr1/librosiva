/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.servicio.ServSucursal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author misanchez
 */
public class SucursalEdit extends JComboBox implements TableCellEditor{
    private LinkedList suscriptores = new LinkedList();
    
    public SucursalEdit(boolean venta){
        super();
        
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                editado(true);
            }
        });
        
        this.setListado(ServSucursal.getListado());
        
        this.setUI(new BasicComboBoxUI());
        
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                editado(false);
            }
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.setSelectedItem(value);
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return this.getSelectedItem();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {
        
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        suscriptores.add(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        suscriptores.remove(l);
    }
    
    private void setListado(List<?> datos){
        this.removeAllItems();
        
        for (Object object : datos) {
            this.addItem(object);
        }
    }
    
    protected void editado(boolean cambiado) {
        ChangeEvent evento = new ChangeEvent(this);
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            CellEditorListener aux = (CellEditorListener) suscriptores.get(i);
            if (cambiado) {
                aux.editingStopped(evento);
                this.transferFocus();
            } else {
                aux.editingCanceled(evento);
            }
        }
    }
}
