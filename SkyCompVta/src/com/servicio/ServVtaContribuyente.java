/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.VentaContribuyente;
import com.utilidades.AdministradorEntidades;
import com.utilidades.Compras;
import com.utilidades.Fechas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sanchez
 */
public class ServVtaContribuyente {
    private static Query q;
    
    public static List<VentaContribuyente> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT v FROM VentaContribuyente v WHERE v.mesAnhoVtaC = :fecha and v.eliminado = 0 order by v.numVtaC");
        q.setParameter("fecha", Fechas.getFechaRpt());
        List<VentaContribuyente> lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return lst;
    }
    
    public static Object[] getListadoTotalVtasC(){
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("select * from v_total_vta_contribuyente where mes_anho_vta_c='"+Fechas.getFechaRpt()+"'");
        
        List lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return (Object[]) lst.get(0);
    }
    
    public static List<Compras> getListadoCSVClientes(String meses)  throws Exception {
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("SELECT * FROM v_csv_clientes WHERE mes_anho_vta_c IN ("+meses+" ORDER BY mes, dia");
        List listado = q.getResultList();
        
        List<Compras> lstVta = new ArrayList<Compras>();
        
        for (int i = 0; i < listado.size(); i++) {
            Object obj[] = (Object [])listado.get(i);
            Compras v = new Compras();
        
            v.setMes(obj[9].toString().substring(0, 2));
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
    
    public static List<VentaContribuyente> getListadoVtasNRCInconsistente(String nrc, int anhoFiscal){
        q = AdministradorEntidades.getInstance().getEM().createQuery("select v from VentaContribuyente v where v.codigoOrg.regIvaOrg=:nrc and v.mesAnhoVtaC like :anhoFiscal order by v.mesAnhoVtaC");
        q.setParameter("nrc", nrc);
        q.setParameter("anhoFiscal", "%"+anhoFiscal);
        
        return java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
    }
}
