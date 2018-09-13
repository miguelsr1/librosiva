/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.dibujadorDeColumna;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author misanchez
 */
public class FechaRenderer extends DefaultTableCellRenderer{
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public FechaRenderer(){
        super();
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
        
        try{
            this.setText(sdf.format(value));
        } catch(Exception e){
            this.setText("");
        }
            
        return this;
    } 
}
