/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Microsoft User
 */
public class ClientesMenor200 {
    private List<ClientesMenor200> listadoVentas = new ArrayList<ClientesMenor200>(0);
    private String fecha_emision;
    private String numero_registro;
    private String monto_operacion;
    private String IVA_operacion;
    private String anio;

    public ClientesMenor200() {
    }

    public String formatearNumero(int posisiones, String valor) {
        valor = valor.replaceAll("[.]", "");
        Formatter fmt = new Formatter();
        fmt.format("%0" + posisiones + "d", Integer.parseInt(valor));
        return fmt.toString();
    }

    public String formatearMes(String mes) {
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        return mes;
    }

    public String quitarGuiones(String numero) {
        int valor = numero.indexOf("-");
        if (valor >= 0) {
            numero = numero.replaceAll("[-]", "");
        }

        return numero;
    }

    public String formatearFecha(String fecha) {
        String salida = null;
        int indexpleca = fecha.indexOf("/");
        if (indexpleca >= 0) {
            String[] arrayFecha = fecha.split("/");
            String anioString = arrayFecha[2];
            String mesString = arrayFecha[1];
            mesString = formatearMes(mesString);
            String dia = arrayFecha[0];
            dia = formatearMes(dia);
            salida = anioString + mesString + dia;
        }


        return salida;
    }

    public String getIVA_operacion() {
        return IVA_operacion;
    }

    public void setIVA_operacion(String IVA_operacion) {
        this.IVA_operacion = IVA_operacion;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getMonto_operacion() {
        return monto_operacion;
    }

    public void setMonto_operacion(String monto_operacion) {
        this.monto_operacion = monto_operacion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public List<ClientesMenor200> getListadoVentas() {
        return listadoVentas;
    }

    public void setListadoVentas(List<ClientesMenor200> listadoVentas) {
        this.listadoVentas = listadoVentas;
    }

    public String getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(String numero_registro) {
        this.numero_registro = numero_registro;
    }

    @Override
    public String toString() {
        return "ClientesMenor200{" + "listadoVentas=" + listadoVentas + ", fecha_emision=" + fecha_emision + ", numero_registro=" + numero_registro + ", monto_operacion=" + monto_operacion + ", IVA_operacion=" + IVA_operacion + ", anio=" + anio + '}';
    }
}
