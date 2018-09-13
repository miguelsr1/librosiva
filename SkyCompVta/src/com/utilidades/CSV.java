/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Microsoft
 */
public class CSV {

    private boolean isVenta = false;

    public CSV() {
    }

    public CSV(boolean venta) {
        this.isVenta = venta;
    }

    public void crearArchivo(String path, List<Compras> vent, String nombreArchivo) {
        String rutaCSV = path;
        CsvWriter csvW = new CsvWriter(rutaCSV);
        boolean error = false;
        for (Compras venta : vent) {
            String tipoDocumento;
            //convirtiendo
            venta.setMes(venta.formatearMes(venta.getMes()));
            String numeroId = venta.quitarGuiones(venta.getNumero_identificacion());
            numeroId = String.format("%1$-14s", numeroId);
            venta.setNumero_identificacion(numeroId);
            venta.setFecha_emision(venta.formatearFecha(venta.getFecha_emision()));
            String numeroDocumento = venta.quitarGuiones(venta.getNumero_documento());
            numeroDocumento = String.format("%1$-20s", numeroDocumento);
            venta.setNumero_documento(numeroDocumento);
            venta.setMonto_operacion(venta.formatearNumero(11, venta.getMonto_operacion()));
            venta.setIVA_operacion(venta.formatearNumero(11, venta.getIVA_operacion()));

            if (isVenta) {
                if (venta.getTipo_documento().equals("4")) {
                    tipoDocumento = "1";
                } else {
                    tipoDocumento = venta.getTipo_documento();
                }
            } else {
                tipoDocumento = venta.getTipo_documento();
            }

            try {
                csvW.write(venta.getMes() + venta.getDocumento_identificacion() + venta.getNumero_identificacion() + venta.getFecha_emision() + tipoDocumento + venta.getNumero_documento() + venta.getMonto_operacion() + venta.getIVA_operacion() + venta.getAnio());
            } catch (IOException ex) {
                Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                csvW.endRecord();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error al generar el archivo \"" + nombreArchivo + ".csv\"", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                error = true;
            }
        }

        csvW.close();

        if (!error) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "El archivo \"" + nombreArchivo + ".csv\" fue generado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void crearArchivoClienteMenor200(String path, List<ClientesMenor200> vent, String nombreArchivo) {
        String rutaCSV = path;
        CsvWriter csvW = new CsvWriter(rutaCSV);
        boolean error = false;
        for (ClientesMenor200 venta : vent) {
            //convirtiendo
            venta.setFecha_emision(venta.formatearFecha(venta.getFecha_emision()));
            venta.setNumero_registro(venta.formatearNumero(8, venta.getNumero_registro()));
            venta.setMonto_operacion(venta.formatearNumero(11, venta.getMonto_operacion()));
            venta.setIVA_operacion(venta.formatearNumero(11, venta.getIVA_operacion()));
            try {
                csvW.write(venta.getFecha_emision() + venta.getNumero_registro() + venta.getMonto_operacion() + venta.getIVA_operacion() + venta.getAnio());
            } catch (IOException ex) {
                Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                csvW.endRecord();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error al generar el archivo \"" + nombreArchivo + ".csv\"", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                error = true;
            }
        }

        csvW.close();

        if (!error) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "El archivo \"" + nombreArchivo + ".csv\" fue generado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
