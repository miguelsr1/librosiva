/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.controles.JXTable;
import com.controles.dibujadorDeColumna.CellRenderer;

/**
 *
 * @author sanchez
 */
public class OperacionesGUI {
    public static void setRender(JXTable table){
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setCellRenderer(i, new CellRenderer());
        }
    }
}
