/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.vistas.Sky;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author misanchez
 */
public class ArchivoPropiedades {

    private static Properties p = new Properties();

    public static Properties getPropiedades(String pathFile) {
        try {
            p.load(Sky.class.getResourceAsStream(pathFile));
            return p;
        } catch (IOException ex) {
            return null;
        }
    }

    public static void setPropiedades(String pathFile, Properties pro) {
        try {
            pro.store(new FileOutputStream(Sky.class.getResource(pathFile).getFile()), null);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoPropiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
