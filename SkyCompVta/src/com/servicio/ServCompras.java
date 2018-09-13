/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.Compra;
import com.utilidades.AdministradorEntidades;
import com.utilidades.Compras;
import com.utilidades.Fechas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author misanchez
 */
public class ServCompras {
    private static Query q;
    
    public static List<Compra> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT c FROM Compra c WHERE c.mesAnhoCompra=:mesAnho and c.eliminado=0 order by c.numCompra");
        q.setParameter("mesAnho", Fechas.getNumeroMes(System.getProperty("mes")).concat(System.getProperty("anho")));
        List<Compra> lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return lst;
    }
    
    public static Object[] getListadoTotalCompras(){
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("select * from v_total_compras where mes_anho_compra='"+Fechas.getFechaRpt()+"'");
        
        List lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return (Object[]) lst.get(0);
    }
    
    public static List<Compras> getListadoCSVCompras(String meses)  throws Exception {
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("SELECT * FROM v_csv_compras WHERE mes_anho_compra IN ("+meses+" and mes is not null ORDER BY mes, fecha_emision");
        List listado = q.getResultList();
        
        List<Compras> lstVta = new ArrayList<Compras>();
        
        for (int i = 0; i < listado.size(); i++) {
            Object obj[] = (Object [])listado.get(i);
            Compras v = new Compras();
        
            v.setMes(obj[11].toString().substring(0, 2));
            v.setDocumento_identificacion(obj[1].toString());
            v.setNumero_identificacion(obj[2].toString());
            v.setFecha_emision(obj[3].toString());
            v.setTipo_documento(obj[4].toString());
            v.setNumero_documento(obj[5].toString());
            v.setMonto_operacion(obj[6].toString());
            v.setIVA_operacion(obj[7].toString());
            v.setAnio(obj[8].toString());
            
            lstVta.add(v);
        }
        
        return lstVta; 
   }
}
