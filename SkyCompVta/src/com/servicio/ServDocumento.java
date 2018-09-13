/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.Documento;
import com.utilidades.AdministradorEntidades;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author misanchez
 */
public class ServDocumento {

    private static Query q;

    public static List<Documento> getListadoCompras() {
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT d FROM Documento d WHERE d.idDoc in (1,2,3,5,6,7)");
        return q.getResultList();
    }

    public static List<Documento> getListadoVentas() {
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT d FROM Documento d WHERE d.idDoc in (1,2,3,4,5,6)");
        return q.getResultList();
    }

    public static Documento getDocumentoById(Integer id) {
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT d FROM Documento d WHERE d.idDoc in (" + id + ")");
        return (Documento) q.getResultList().get(0);
    }
}
