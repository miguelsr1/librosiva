/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.entidades.Organizacion;
import com.servicio.ServOrganizacion;
import com.utilidades.AdministradorEntidades;
import java.awt.Component;
import java.awt.event.*;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author sanchez
 */
public class OrganizacionEdit extends JTextField implements TableCellEditor {

    private int idTipoOrg;
    private Organizacion org = null;
    /**
     * Lista de suscriptores
     */
    private LinkedList suscriptores = new LinkedList();

    public OrganizacionEdit(int idTipoOrg) {
        super();
        this.idTipoOrg = idTipoOrg;
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
                select(0, 0);
                setCaretPosition(getText().isEmpty() ? 0 : getText().length());
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

        if (value != null) {
            this.setText(value.toString());
        } else {
            this.setText("");
        }

        codigoOrgFieldFocusEvent(null);
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return org;
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
        try {
            ChangeEvent evento = new ChangeEvent(this);
            int i;
            for (i = 0; i < suscriptores.size(); i++) {
                CellEditorListener aux = (CellEditorListener) suscriptores.get(i);
                if (cambiado) {
                    buscarOrg();
                    aux.editingStopped(evento);
                    this.transferFocus();
                } else {
                    aux.editingCanceled(evento);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected void codigoOrgFieldFocusEvent(FocusEvent evt) {
        this.requestFocus();
        this.requestFocusInWindow();
    }

    private void buscarOrg() {
        List<Organizacion> lst = ServOrganizacion.getListado(idTipoOrg, this.getText().trim());
        if (!lst.isEmpty()) {
            org = lst.get(0);
        } else {
            JOptionPane.showMessageDialog(this, "Este " + ((idTipoOrg == 1) ? "cliente" : "proveedor") + " no esta registrado en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
            org = AdministradorEntidades.getInstance().getEM().find(Organizacion.class, "");
        }
    }
}