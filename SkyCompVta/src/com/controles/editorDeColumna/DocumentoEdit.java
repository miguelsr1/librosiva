/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.servicio.ServDocumento;
import java.awt.Component;
import java.awt.Dimension;
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
public class DocumentoEdit extends JComboBox implements TableCellEditor {

    private LinkedList suscriptores = new LinkedList();

    public DocumentoEdit(boolean venta) {
        super();

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                editado(true);
            }
        });

        if (venta) {
            this.setListado(ServDocumento.getListadoVentas(), true);
        } else {
            this.setListado(ServDocumento.getListadoCompras(), true);
        }

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

    private void setListado(List<?> datos, boolean inicializado) {
        this.removeAllItems();

        if (inicializado) {
            this.addItem("");
        }
        for (Object object : datos) {
            this.addItem(object);
        }
    }

    protected void editado(boolean cambiado) {
        ChangeEvent evento = new ChangeEvent(this);
        int i;
        try {
            for (i = 0; i < suscriptores.size(); i++) {
                CellEditorListener aux = (CellEditorListener) suscriptores.get(i);
                if (cambiado) {
                    aux.editingStopped(evento);
                    this.transferFocus();
                } else {
                    aux.editingCanceled(evento);
                }
            }
        } catch (Exception e) {
        }
    }
    private boolean layingOut = false;

    @Override
    public void doLayout() {
        try {
            layingOut = true;
            super.doLayout();
        } finally {
            layingOut = false;
        }
    }

    @Override
    public Dimension getSize() {
        Dimension dim = super.getSize();
        if (!layingOut) {
            dim.width = Math.max(dim.width, getPreferredSize().width);
        }
        return dim;
    }
}