/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.dibujadorDeColumna;

import com.utilidades.OperacionMatematica;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author misanchez
 */
public class NumerosRenderer extends DefaultTableCellRenderer {

    public NumerosRenderer() {
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        this.setForeground(Color.BLACK);
        if(isSelected){
            if (hasFocus){
                this.setBackground(Color.decode("#004d9d"));
                this.setForeground(Color.WHITE);
            }else{
                this.setBackground(Color.decode("#b8cfe5"));
                this.setForeground(Color.BLACK);
            }
        }else{
            this.setBackground(Color.WHITE);
            
        }
        
        this.setText(OperacionMatematica.formatoNumero(value));

        return this;
    }
}
