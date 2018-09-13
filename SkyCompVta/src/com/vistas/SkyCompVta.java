package com.vistas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.LightGray;
import com.utilidades.AdministradorEntidades;
import java.io.File;

/**
 *
 * @author misanchez
 */
public class SkyCompVta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("carpetaDB", System.getProperty("user.dir") + File.separator + "sky_libros_iva");

        isArchivoLock();

        AdministradorEntidades ae = AdministradorEntidades.getInstance();
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            PlasticLookAndFeel.setPlasticTheme(new LightGray());
            javax.swing.UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (Exception e) {
            System.out.println("Error L&F " + e.getMessage());
        }
        //</editor-fold>

        V_InicioSession vInicioSesion = new V_InicioSession(null, true);
        vInicioSesion.setEntityManager(ae.getEM());
        vInicioSesion.setVisible(true);
        if (vInicioSesion.isUsuarioValido()) {
            Sky.Run(vInicioSesion.getUsuario());
        } else {
            ae.cerrarEM();
        }
    }

    public static void isArchivoLock() {
        File f = new File(System.getProperty("carpetaDB"));

        File[] ficheros = f.listFiles();

        for (File file1 : ficheros) {
            if (file1.getName().equals("sky_libros_iva.lock.db")) {
                file1.delete();
                break;
            }
        }

    }
}
