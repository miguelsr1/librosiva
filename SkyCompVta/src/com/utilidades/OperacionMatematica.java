/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.controles.JXTextFiled;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author misanchez
 */
public class OperacionMatematica {

    private static DecimalFormat df = new DecimalFormat("0.00");
    
    public static float getResultadoSumaFloat(JTextField... txt) {
        float resultado = 0f;
        for (JTextField txtTemp : txt) {
            if (!txtTemp.getText().trim().isEmpty()) {
                resultado += Float.parseFloat(txtTemp.getText().trim());
            }
        }

        return Float.parseFloat(df.format(resultado));
    }

    public static float getResultadoSumaFloat(Object... txt) {
        float resultado = 0f;
        for (Object txtTemp : txt) {
            if (txtTemp != null) {
                resultado += ((BigDecimal) txtTemp).floatValue();
            }
        }

        return Float.parseFloat(df.format(resultado));
    }

    public static BigDecimal getResultadoSumaBigDecimal(Object... txt) {
        BigDecimal resultado = new BigDecimal(0);
        for (Object txtTemp : txt) {
            if (txtTemp != null) {
                resultado = resultado.add((BigDecimal) txtTemp);
            }
        }

        return new BigDecimal(df.format(resultado));
    }

    public static float getResultadoMultiplicacionFloat(JXTextFiled txt1, JXTextFiled txt2) {
        float resultado = 0;
        if (!txt1.getText().trim().isEmpty() && !txt2.getText().trim().isEmpty()) {
            resultado = Float.parseFloat(txt1.getText()) * Float.parseFloat(txt2.getText());
        }

        return Float.parseFloat(df.format(resultado));
    }

    public static float getResultadoMultiplicacionFloat(JXTextFiled txt1, String txt2) {
        float resultado = 0;
        if (!txt1.getText().trim().isEmpty() && !txt2.trim().isEmpty()) {
            resultado = Float.parseFloat(txt1.getText()) * Float.parseFloat(txt2);
        }

        return Float.parseFloat(df.format(resultado));
    }

    public static BigDecimal calcularIva(Object txt) {
        BigDecimal resultado = new BigDecimal(0);

        if (txt != null) {
            resultado = ((BigDecimal) txt).multiply(new BigDecimal("0." + System.getProperty("iva")));
        }

        return new BigDecimal(df.format(resultado));
    }
    
    public static String formatoNumero(Object numero){
        if(numero != null)
            return df.format(numero);
        return null;
    }
}
