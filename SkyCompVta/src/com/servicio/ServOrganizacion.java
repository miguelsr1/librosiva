/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.Organizacion;
import com.utilidades.AdministradorEntidades;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sanchez
 */
public class ServOrganizacion {
    private static Query q;
    
    public static String getCountOrg(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("select COUNT(o) from Organizacion o", Organizacion.class);
        Object numOrg = q.getSingleResult();
        return numOrg.toString();
    }
    
    public static List<Organizacion> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("select o from Organizacion o", Organizacion.class);
        return q.getResultList();
    }
    
    public static List<Organizacion> getListado(int idTipoOrg, String codigoOrg){
        q = AdministradorEntidades.getInstance().getEM().createQuery("select o from Organizacion o where o.idTipoOrg.idTipoOrg in(:idTipoOrg,3) and o.codigoOrg = :codigoOrg and o.eliminado = :eliminado", Organizacion.class);
        q.setParameter("idTipoOrg", idTipoOrg);
        q.setParameter("codigoOrg", codigoOrg);
        q.setParameter("eliminado", false);
        
        return q.getResultList();
    }
    public static List<Organizacion> getListado(int idTipoOrg){
        q = AdministradorEntidades.getInstance().getEM().createQuery("select o from Organizacion o where o.idTipoOrg.idTipoOrg in(:idTipoOrg,3) and o.eliminado = :eliminado", Organizacion.class);
        q.setParameter("idTipoOrg", idTipoOrg);
        q.setParameter("eliminado", false);
        
        return q.getResultList();
    }
}
