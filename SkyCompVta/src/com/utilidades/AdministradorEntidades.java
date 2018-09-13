/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author misanchez
 */
public class AdministradorEntidades {

    private static AdministradorEntidades instance = null;
    private static EntityManager em = null;
    private static Properties propertiesDB = new Properties();

    protected AdministradorEntidades() {
        try {
            System.out.println(System.getProperty("user.dir") + File.separator + "propiedades" + File.separator + "DB.properties");
            propertiesDB.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "propiedades" + File.separator + "DB.properties"));
            String urlBD = propertiesDB.getProperty("javax.persistence.jdbc.url")+System.getProperty("user.dir")+File.separator+"sky_libros_iva"+File.separator+"sky_libros_iva";            
            propertiesDB.setProperty("javax.persistence.jdbc.url", urlBD);
            em = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SkyCompVtaPU", propertiesDB).createEntityManager();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error en la generacion del Administrador de Entidades.\n\nCola de Error: "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static AdministradorEntidades getInstance() {
        if (instance == null) {
            instance = new AdministradorEntidades();
        }

        return instance;
    }

    public EntityManager getEM() {
        return em;
    }

    public void cerrarEM() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
