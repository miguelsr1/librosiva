/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author sanchez
 */
public class JXComboBox extends JComboBox {
    public JXComboBox() {
        agregarEvento();
        agregarListener();
    }

    private void agregarEvento() {
        addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    transferFocus();
                }
            }
        });
    }

    /**
     * Agrega un evento que permite modificar el color de fondo de este control
     */
    private void agregarListener() {
        this.addFocusListener(new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                setBackGround(Color.getHSBColor(0.5893f, 0.2705f, 1.00f));
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                setBackGround(Color.WHITE);
            }
        });
    }

    /**
     * Establece el color de fondo al control
     *
     * @param color
     */
    private void setBackGround(Color color) {
        this.setBackground(color);
    }
    
    public JXComboBox(ComboBoxModel aModel) { 
        super(aModel); 
    } 
 
    private boolean layingOut = false; 
 
    @Override
    public void doLayout(){ 
        try{ 
            layingOut = true; 
            super.doLayout(); 
        }finally{ 
            layingOut = false; 
        } 
    } 
 
    @Override
    public Dimension getSize(){ 
        Dimension dim = super.getSize(); 
        if(!layingOut) 
            dim.width = Math.max(dim.width, getPreferredSize().width); 
        return dim; 
    } 
}
