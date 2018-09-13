/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author misanchez
 */
public class Reportes {

    private String nombreRpt;
    private Map param = new HashMap();
    private Connection con = null;

    public Reportes(String nombreRpt) {
        this.nombreRpt = nombreRpt;

        getConnection();
    }

    private Connection getConnection() {
        if (con == null) {
            EntityManager em = AdministradorEntidades.getInstance().getEM();
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            con = em.unwrap(java.sql.Connection.class);
            em.getTransaction().commit();
        }
        return con;
    }

    public void viewRpt() {
        try {
            getParametrosRpt();

            if (getNombreRpt().equals("rptLibroVtaContribuyente")) {
                URL urlSubRpt = Reportes.class.getResource("/com/reportes/" + getNombreRpt() + "_subRpt1.jasper");
                JasperReport jasperRpt = (JasperReport) JRLoader.loadObject(urlSubRpt);
                param.put("SUBREPORT", jasperRpt);
            }

            InputStream archivo = Reportes.class.getResourceAsStream("/com/reportes/" + getNombreRpt() + ".jasper");
            JasperPrint print = JasperFillManager.fillReport(archivo, param, getConnection());
            
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Verifique que los tres libros contengan datos para el mes actual!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public Map getParametrosRpt() {
        param.clear();
        param.put("iva", System.getProperty("iva").concat(".00 %"));
        param.put("fecha", Fechas.getNumeroMes(System.getProperty("mes").toString()).concat(System.getProperty("anho").toString()));
        param.put("mes", Fechas.getNombreMes(System.getProperty("mes")));
        param.put("anho", System.getProperty("anho"));

        return param;
    }

    public String getNombreRpt() {
        return nombreRpt;
    }
}
