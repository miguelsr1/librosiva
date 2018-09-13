/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.editorDeColumna;

import com.entidades.Documento;
import com.servicio.ServDocumento;
import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author misanchez
 */
public class DefaultCellEdit extends JTextField implements TableCellEditor {
    private Documento docEdit;
    private List<Documento> lstDocumento = new ArrayList<Documento>();
    private LinkedList suscriptores = new LinkedList();

    public DefaultCellEdit(Boolean venta) {
        super();

        if (venta) {
            this.setListado(ServDocumento.getListadoVentas());
        } else {
            this.setListado(ServDocumento.getListadoCompras());
        }

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
                if(getText().trim().length()>=2){
                    e.consume();
                }
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
                String doc = getText().trim().toUpperCase();
                if(doc.length()==2){
                    if(doc.equals("CF")){
                        docEdit = ServDocumento.getDocumentoById(1);
                    }else if(doc.equals("DC")){
                        docEdit = ServDocumento.getDocumentoById(2);
                    }else if(doc.equals("CR")){
                        docEdit = ServDocumento.getDocumentoById(3);
                    }else if(doc.equals("DF")){
                        docEdit = ServDocumento.getDocumentoById(4);
                    }else if(doc.equals("NC")){
                        docEdit = ServDocumento.getDocumentoById(5);
                    }else if(doc.equals("ND")){
                        docEdit = ServDocumento.getDocumentoById(6);
                    }else{
                        docEdit = ServDocumento.getDocumentoById(-1);
                        setText("");
                    }
                }else if(doc.length()>2){
                    setText(""+e.getKeyChar()+"");
                }
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
        
        setBorder(null); 
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
            return ((MouseEvent) anEvent).getClickCount() >= 2;
        }
        return true;
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

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null) {
            setText(value.toString());
        }

        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return docEdit;
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

    private void setListado(List<Documento> datos) {
        lstDocumento.clear();
        lstDocumento = datos;
    }
}