/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.temp.V_Msj_Espera;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author misanchez
 */
public class BD extends Thread {

    private int operacion;
    private String path;
    private String sSistemaOperativo;
    private JLayeredPane capa;
    private V_Msj_Espera msj;

    public BD(final JLayeredPane capa, int operacion) {
        sSistemaOperativo = System.getProperty("os.name");
        this.capa = capa;
        this.operacion = operacion;

        msj = new V_Msj_Espera();
        msj.setSize(294, 74);
        msj.setLocation((capa.getWidth() / 2) - 188, (capa.getHeight() / 2) - 38);
    }

    @Override
    public void run() {
        switch (operacion) {
            case 1: //Generación de respaldo
                msj.setMsj("Generando respaldo de la Base de Datos");
                BackupDB();
                break;
            case 2: //Restauración de respaldo
                msj.setMsj("Restaurando la Base de Datos");
                RestoreDB();
                break;
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Llama a mysql y le redirige a su entrada el fichero de backup obtenido
     * con mysqldump.
     */
    public void BackupDB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyy");
        String fecha = sdf.format(new java.util.Date());
        try {
            
              String[] args = { "-url",
              "jdbc:h2:"+System.getProperty("user.home")+File.separator+"sky_libros_iva"+File.separator+"sky_libros_iva", 
              "-user",
              "admin", 
              "-password", 
              "adminsky",
              "-script", 
              path + File.separator + "Backup_" + fecha + ".zip", 
              "-options",
              "compression zip"};
             
              org.h2.tools.Script.main(args);

            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "El archivo \"Backup_" + fecha + ".zip\" fue generado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error en la generacion del archivo \"Backup_" + fecha + ".zip\".", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Llama a mysql y le redirige a su entrada el fichero de backup obtenido
     * con mysqldump.
     */
    public void RestoreDB() {

        try {
            EntityManager em = AdministradorEntidades.getInstance().getEM();
            em.getTransaction().begin();
            Connection con =
                    em.unwrap(java.sql.Connection.class);
            org.h2.tools.RunScript.execute(con, new FileReader(path));

            em.getTransaction().commit();

            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "La restauración de la base de datos fue generado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Hubo un error en la restauración de la base de datos.", "Información", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Se saca por pantalla la salida de errores del comando, por si acaso.
     *
     * @param es El InputStream de donde leer los errores del comando mysql.
     */
    private void muestraSalidaDeError(final InputStream es) {
        Thread hiloError = new Thread() {

            public void run() {
                try {
                    byte[] buffer = new byte[1024];
                    int leido = es.read(buffer);
                    while (leido > 0) {
                        System.out.println(new String(buffer, 0, leido));
                        leido = es.read(buffer);
                    }
                    es.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        hiloError.start();
    }
}
