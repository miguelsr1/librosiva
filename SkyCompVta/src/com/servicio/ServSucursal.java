/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.Sucursal;
import com.utilidades.AdministradorEntidades;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author misanchez
 */
public class ServSucursal {
    private static Query q;
    
    public static List<Sucursal> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT s FROM Sucursal s");
        return q.getResultList();
    }
}
