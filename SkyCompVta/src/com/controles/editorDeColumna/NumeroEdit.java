/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import java.awt.Component;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.EventObject;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Microsoft User
 */
public class NumeroEdit extends JTextField implements TableCellEditor {

    private LinkedList suscriptores = new LinkedList();
    boolean decimal = false;

    public NumeroEdit() {
        super();
    }

    public NumeroEdit(boolean decimal, int aling) {
        super();

        this.decimal = decimal;

        setHorizontalAlignment(aling);

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
                editado(false);
            }
        });

        setOpaque(true);
        setBorder(null);

        addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    transferFocus();
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (getDecimal()) {
                    char caracter = evt.getKeyChar();
                    if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
                        if (getDecimal() && isPosPtoDecimal() == -1) {
                            if (caracter != '.') {
                                evt.consume();
                            }
                        } else {
                            evt.consume();
                        }
                    }
                }
            }
        });
    }

    private boolean getDecimal() {
        return decimal;
    }

    private int isPosPtoDecimal() {
        return this.getText().indexOf(".");
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null) {
            if (decimal) {
                this.setText(((BigDecimal) value).toPlainString());
            } else {
                this.setText(value.toString());
            }
        }

        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return getText();
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
