/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.Modalidad;
import com.utilidades.AdministradorEntidades;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author misanchez
 */
public class ServModalidad {
    private static Query q;
    
    public static List<Modalidad> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT m FROM Modalidad m");
        return q.getResultList();
    }
}
