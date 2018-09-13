/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.io.File;

/**
 *
 * @author Microsoft User
 */
public class ServiceDB {
    /**
     * Inicializa el servicio de la base de datos MySQL
     *
     * @return
     */
    public static boolean startServiceBD() {
        return exeBat("startMysql.bat");
    }

    /**
     * Detiene el servicio de la base de datos MySQL
     *
     * @return
     */
    public static boolean stopServiceDB() {
        return exeBat("shutdownMysql.bat");
    }

    /**
     * Ejecución de un archivo bat
     *
     * @param nombreArchivo
     * @return
     */
    private static boolean exeBat(String nombreArchivo) {
        boolean ok = false;
        try {
            String r = "\"" + System.getProperty("user.home") + File.separator + "mysql-5.5.25a-win32" + File.separator + nombreArchivo + "\"";
            Runtime.getRuntime().exec("cmd.exe /K start cmd.exe /C " + r);
        } catch (Exception e) {
            System.out.println(e);
            ok = true;
        }

        return ok;
    }
}
