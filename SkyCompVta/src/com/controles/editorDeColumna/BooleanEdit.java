/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.entidades.Organizacion;
import com.servicio.ServOrganizacion;
import com.utilidades.AdministradorEntidades;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Microsoft User
 */
public class BooleanEdit  extends JCheckBox implements TableCellEditor {
    
    private boolean valor;
    /**
     * Lista de suscriptores
     */
    private LinkedList suscriptores = new LinkedList();

    public BooleanEdit() {
        super();
        
        // Nos apuntamos a cuando se seleccione algo, para avisar a la tabla
        // de que hemos cambiado el dato.
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                editado(true);
            }
        });

        this.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("press");
                switch (e.getKeyCode()) {
                    case 39:
                    case 37:
                    case 40:
                    case 38:
                    case 10:
                        editado(true);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                editado(false);
            }
        });

        this.setBorder(BorderFactory.createEmptyBorder());
    }
   
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        if (value.toString().equals("true")) {
            valor = true;
        } else {
            valor = false;
        }

        booleanFieldFocusEvent(null);
        return this;
    }

    protected void booleanFieldFocusEvent(FocusEvent evt) {
        this.requestFocus();
        this.requestFocusInWindow();
    }
    
    @Override
    public Object getCellEditorValue() {
        return valor;
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

    /**
     * Si cambiado es true, se avisa a los suscriptores de que se ha terminado
     * la edición. Si es false, se avisa de que se ha cancelado la edición.
     */
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