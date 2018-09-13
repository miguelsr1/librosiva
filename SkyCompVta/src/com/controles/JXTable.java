/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles;

import com.controles.editorDeColumna.FechaEdit;
import com.controles.editorDeColumna.NumeroEdit;
import com.controles.editorDeColumna.OrganizacionEdit;
import com.ezware.oxbow.swingbits.table.filter.TableRowFilterSupport;
import com.utilidades.OperacionMatematica;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.icon.ColumnControlIcon;

/**
 *
 * @author sanchez
 */
public class JXTable extends JTable {

    private String colsMultiplicar = "";
    private String colsSumar = "";
    private String colsSum[] = null;
    private int colMult = -1;
    private String[] colsMults;
    private int colResulMult = -1;
    private int verticalScrollPolicy;
    private JComponent columnControlButton;
    private List<?> listado;
    private Object[] paramSuma;

    public JXTable() {
        super();
        this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0,
                false), "selectNextColumn");

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 39://rigth
                    case 37://left
                    case 40://down
                    case 38://up
                    case 10://enter
                        break;
                    case 127: //delete
                        setValueAt(null, getSelectedRow(), getSelectedColumn());
                        break;
                    default:
                        if (!isEditing()) {
                            editCellAt(getSelectedRow(), getSelectedColumn());
                            if (getEditorComponent() != null) {
                                getEditorComponent().requestFocusInWindow();
                                if (getEditorComponent() instanceof NumeroEdit) {
                                    ((NumeroEdit) getEditorComponent()).setText("");
                                } else if (getEditorComponent() instanceof FechaEdit) {
                                    ((FechaEdit) getEditorComponent()).setText("");
                                } else if (getEditorComponent() instanceof OrganizacionEdit) {
                                    ((OrganizacionEdit) getEditorComponent()).setText("");
                                }
                            }
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                editCellAt(-1, -1);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        if (autoResizeMode != AUTO_RESIZE_OFF) {
            if (getParent() instanceof JViewport) {
                configureColumnControl();
                return (((JViewport) getParent()).getWidth() > getPreferredSize().width);
            }
        }
        return false;
    }

    public void setCellRenderer(int columna, TableCellRenderer cellRenderer) {
        (this.getColumnModel().getColumn(columna)).setCellRenderer(cellRenderer);
    }

    public void setCellEditor(int columna, TableCellEditor cellEditor) {
        (this.getColumnModel().getColumn(columna)).setCellEditor(cellEditor);
    }

    /**
     * Crea y agrega a la tabla un componente que servira de boton para mostrar
     * el menu de importacion de los datos a las tablas, a algunos formatos
     * previamente definidos.<br> Por Ejemplo exportacion de datos a excel.
     */
    private void configureColumnControl() {
        Container p = getParent();
        if (p instanceof JViewport) {
            Container gp = p.getParent();
            if (gp instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) gp;
                JViewport viewport = scrollPane.getViewport();
                if (viewport == null || viewport.getView() != this) {
                    return;
                }

                verticalScrollPolicy = scrollPane.getVerticalScrollBarPolicy();
                scrollPane.setCorner(JScrollPane.UPPER_TRAILING_CORNER,
                        getColumnControl());

                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }
        }
    }

    /**
     * Retorna el componente que se visualizara en la esquina superior derecha
     * de la tabla.
     *
     * @return
     */
    private JComponent getColumnControl() {
        if (columnControlButton == null) {
            columnControlButton = new HColumnControlButton(this,
                    new ColumnControlIcon());
        }
        return columnControlButton;
    }

    public List<?> getListado() {
        return listado;
    }

    public void setLisado(List<?> listado) {
        this.listado = listado;
    }

    public void cambiarSeleccion() {
        super.changeSelection(this.getSelectedRow(), this.getSelectedColumn(), false, false);
        if (editCellAt(this.getSelectedRow(), this.getSelectedColumn())) {
            Component editor = getEditorComponent();
            editor.requestFocusInWindow();
        }
    }

    public String getColsSumar() {
        return colsSumar;
    }

    public void setColsSumar(String colsSumar) {
        this.colsSumar = colsSumar;
        armarFormulaSuma();
    }

    private void armarFormulaSuma() {
        String c = colsSumar.substring(colsSumar.indexOf("=") + 1, colsSumar.length());
        paramSuma = new Object[colsSumar.split("\\+").length];

        colsSum = new String[colsSumar.split("\\+").length + 1];

        colsSum[0] = colsSumar.substring(0, colsSumar.indexOf("="));
        System.arraycopy(c.split("\\+"), 0, colsSum, 1, c.split("\\+").length);
    }

    @Override
    public void editingStopped(ChangeEvent e) {
        super.editingStopped(e);

        if (!getColsSumar().isEmpty() && getSelectedRow() != -1) {
            colMult = isEditColumnasDeMult();
            if (colMult != -1) {
                this.setValueAt(OperacionMatematica.calcularIva(this.getValueAt(getSelectedRow(), colMult)),
                        this.getSelectedRow(),
                        colResulMult);
            }

            if (isEditColumnasDeSuma()) {
                for (int i = 0; i < paramSuma.length; i++) {
                    paramSuma[i] = this.getValueAt(getSelectedRow(), Integer.parseInt(colsSum[i + 1]));
                }
                this.setValueAt(OperacionMatematica.getResultadoSumaBigDecimal(paramSuma), this.getSelectedRow(), Integer.parseInt(colsSum[0]));
            }
        }
    }

    private boolean isEditColumnasDeSuma() {
        if (colsSum != null) {
            for (int i = 1; i < colsSum.length; i++) {
                if (getSelectedColumn() == Integer.parseInt(colsSum[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private int isEditColumnasDeMult() {
        if (colsMults != null) {
            for (String string : colsMults) {
                if (Integer.parseInt(string) == getSelectedColumn()) {
                    return Integer.parseInt(string);
                }
            }
        }

        return -1;
    }

    public String getColsMultiplicar() {
        return colsMultiplicar;
    }

    public void setColsMultiplicar(String colsMultiplicar) {
        this.colsMultiplicar = colsMultiplicar;
        armarFormulaMult();
    }

    private void armarFormulaMult() {
        colsMults = colsMultiplicar.substring(colsMultiplicar.indexOf("=") + 1, colsMultiplicar.length()).split(",");
        colResulMult = Integer.parseInt(colsMultiplicar.substring(0, colsMultiplicar.indexOf("=")));
    }

    /**
     * Método para habilitar la visualización de la ventana de búsqueda
     * emergente al dar clic derecho sobre la columna<br>
     * en la tabla
     *
     * @param searchable: activar control adicional para busqueda por texto.
     */
    public void aplicacionFiltros(boolean searchable) {
        if (searchable) {
            TableRowFilterSupport.forTable(this).searchable(true).apply();
        } else {
            TableRowFilterSupport.forTable(this).apply();
        }
    }
}