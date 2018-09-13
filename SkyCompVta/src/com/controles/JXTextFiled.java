/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author sanchez
 */
public class JXTextFiled extends JTextField{
    private int maxCaracteres = 0;
    
    private boolean decimal = false;
    private boolean numero = false;

    public JXTextFiled() {
        agregarListener();
        agregarEvento();
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
                if(numero){
                    char caracter = evt.getKeyChar();
                    if(maxCaracteres == 0 || getLongitud() < maxCaracteres || getSelectedText() != null){
                        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
                            if(decimal &&  isPosPtoDecimal() == -1){
                                if(caracter != '.')
                                    evt.consume();
                            }else
                                evt.consume();
                    }else
                        evt.consume();
                }
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

    public boolean isDecimal() {
        return decimal;
    }

    public void setDecimal(boolean decimal) {
        this.decimal = decimal;
        setNumero(decimal);
    }

    public int getMaxCaracteres() {
        return maxCaracteres;
    }

    public void setMaxCaracteres(int maxCaracteres) {
        this.maxCaracteres = maxCaracteres;
    }

    public boolean isNumero() {
        return numero;
    }

    public void setNumero(boolean numero) {
        this.numero = numero;
        this.setHorizontalAlignment(JLabel.RIGHT);
    }
    
    /**
     * Retorna la longitud de la cadena de caracteres del control
     * @return
     */
    private int getLongitud(){
        return this.getText().length();
    }
    
    /**
     * Verifica si existe el caracter punto ('.') en la cadena de caracteres ingresada en el control
     * @return
     */
    private int isPosPtoDecimal(){
        return this.getText().indexOf(".");
    }
    
    /**
     * Establece el color de fondo al control
     * @param color
     */
    private void setBackGround(Color color){
        this.setBackground(color);
    }
}
