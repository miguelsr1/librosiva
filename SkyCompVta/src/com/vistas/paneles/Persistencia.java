/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas.paneles;

/**
 *
 * @author sanchez
 */
public interface Persistencia {
    public void guardar();
    public void eliminar();
    public void actualizar();
    public void nuevo();
    public void suma();
    
    public void setEnabledEliminar(Boolean eliminar);
    public Boolean getEnabledEliminar();
}
