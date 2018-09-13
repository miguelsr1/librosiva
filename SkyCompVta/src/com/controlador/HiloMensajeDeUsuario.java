/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controlador;

import com.utilidades.AccesoAVtaPadre;

/**
 *
 * @author MISanchez
 */
public class HiloMensajeDeUsuario extends Thread{
    private Thread t;

    /**
     * Constructor de la clase
     * @param main
     */
    public HiloMensajeDeUsuario(){  }

    @Override
    public void run(){
        AccesoAVtaPadre.setLoading(true);
    }

    @Override
    public void start() {
        t = new java.lang.Thread(this);
        t.start();
    }

    public void finalizar(){
        AccesoAVtaPadre.setLoading(false);
    }
}
