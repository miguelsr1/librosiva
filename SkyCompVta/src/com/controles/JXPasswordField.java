/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author sanchez
 */
public class JXPasswordField extends JPasswordField{
    private int maxCaracteres = 0;

    public JXPasswordField() {
        agregarListener();
    }
    
    private void agregarEvento(){
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt){
                if(evt.getKeyCode() == 10)
                    transferFocus();
            }
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if(maxCaracteres == 0 || getLongitud() < maxCaracteres || getSelectedText() != null){
                    if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
                            evt.consume();
                }else
                    evt.consume();
            }
        });
    }
    
    /**
     * Agrega un evento que permite modificar el color de fondo de este control
     */
    private void agregarListener(){
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

        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(isFocusOwner())
                    setBackGround(Color.getHSBColor(0.5893f, 0.2705f, 1.00f));
            }

            @Override
            public void removeUpdate(DocumentEvent e) { }
            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
    }

    public int getMaxCaracteres() {
        return maxCaracteres;
    }

    public void setMaxCaracteres(int maxCaracteres) {
        this.maxCaracteres = maxCaracteres;
        agregarEvento();
    }
    
    /**
     * Retorna la longitud de la cadena de caracteres del control
     * @return
     */
    private int getLongitud(){
        return this.getText().length();
    }
    
    /**
     * Establece el color de fondo al control
     * @param color
     */
    private void setBackGround(Color color){
        this.setBackground(color);
    }
}
