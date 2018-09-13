/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.utilidades.Fechas;
import java.awt.Component;
import java.awt.event.*;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author misanchez
 */
public class FechaEdit extends JTextField implements TableCellEditor {

    private LinkedList suscriptores = new LinkedList();
    private Date fechaTemp;

    public FechaEdit() {
        super();

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                editado(true);
            }
        });

        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                select(0, 0);
                setCaretPosition(getText().isEmpty() ? 0 : getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
                editado(true);
            }
        });

        this.setBorder(null);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        fechaTemp = (Date) value;
        this.setText(Fechas.DateToString(fechaTemp));
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        try {
            String fecha = this.getText().replace(".", "/");
            return Fechas.stringToDate(fecha);
        } catch (Exception e) {

            try {
                String fecha = this.getText();
                String temp = fecha.substring(0, 2).concat("/").concat(fecha.substring(2, 4)).concat("/").concat(fecha.substring(4, 8));
                return Fechas.stringToDate(temp);
            } catch (Exception ee) {
                return fechaTemp;
            }
        }
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
            return ((MouseEvent) anEvent).getClickCount() >= 2;
        }
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
