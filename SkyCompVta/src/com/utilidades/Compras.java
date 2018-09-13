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
 * @author RCeron
 */
public class Compras {

    private List<Compras> listadoVentas = new ArrayList<Compras>(0);
    private String mes;
    private String documento_identificacion;
    private String numero_identificacion;
    private String fecha_emision;
    private String tipo_documento;
    private String numero_documento;
    private String monto_operacion;
    private String IVA_operacion;
    private String anio;

    public Compras() {
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

    public String getDocumento_identificacion() {
        return documento_identificacion;
    }

    public void setDocumento_identificacion(String documento_identificacion) {
        this.documento_identificacion = documento_identificacion;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMonto_operacion() {
        return monto_operacion;
    }

    public void setMonto_operacion(String monto_operacion) {
        this.monto_operacion = monto_operacion;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Venta{" + "mes=" + mes + ", documento_identificacion=" + documento_identificacion + ", numero_identificacion=" + numero_identificacion + ", fecha_emision=" + fecha_emision + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", monto_operacion=" + monto_operacion + ", IVA_operacion=" + IVA_operacion + ", anio=" + anio + '}';
    }

    public List<Compras> getListadoVentas() {
        return listadoVentas;
    }

    public void setListadoVentas(List<Compras> listadoVentas) {
        this.listadoVentas = listadoVentas;
    }
}
