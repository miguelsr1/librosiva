/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import com.controlador.HiloMensajeDeUsuario;
import com.entidades.Usuario;
import com.vistas.Sky;
import com.vistas.paneles.Persistencia;

/**
 *
 * @author misanchez
 */
public class AccesoAVtaPadre {
    public static Sky vtaPadre;

    public static Sky getVtaPadre() {
        return vtaPadre;
    }

    public static void setVtaPadre(Sky vtaPadre) {
        AccesoAVtaPadre.vtaPadre = vtaPadre;
    }
    
    public static void setLoading(boolean visible){
        vtaPadre.setMsjLoading(visible);
    }
    
    public static void setVisibleVtna(String titulo, String nameIcono, Persistencia panel){
        vtaPadre.setVisibleVtna(titulo, nameIcono, panel);
    }
    
    public static HiloMensajeDeUsuario getHiloMsjUsuario(){
        return vtaPadre.getHiloMsjUsuario();
    }
    
    public static Usuario getUsuario(){
        return vtaPadre.getUsuario();
    }
}
