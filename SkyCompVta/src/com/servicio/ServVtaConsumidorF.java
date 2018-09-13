/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.entidades.VentaConsumidor;
import com.utilidades.AdministradorEntidades;
import com.utilidades.ClientesMenor200;
import com.utilidades.Fechas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sanchez
 */
public class ServVtaConsumidorF {
    private static Query q;
    
    public static List<VentaConsumidor> getListado(){
        q = AdministradorEntidades.getInstance().getEM().createQuery("SELECT v FROM VentaConsumidor v WHERE v.mesAnhoVtaCf = :fechaRpt and v.eliminado=0 Order by v.numVtaF");
        q.setParameter("fechaRpt", Fechas.getFechaRpt());
        List<VentaConsumidor> lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return lst;
    }
    
    public static Object[] getListadoTotalVtas(){
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("select * from v_total_vta_con_f where mes_anho_vta_cf='"+Fechas.getFechaRpt()+"'");
        
        List lst = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());
        
        return (Object[]) lst.get(0);
    }
    
    public static List<ClientesMenor200> getListadoCSVClientes(String meses)  throws Exception {
        q = AdministradorEntidades.getInstance().getEM().createNativeQuery("SELECT * FROM v_csv_clientes_menor_200 WHERE mes_anho_vta_cf IN ("+meses+") ORDER BY mes, dia_vta_con_f");
        List listado = q.getResultList();
        
        List<ClientesMenor200> lstVta = new ArrayList<ClientesMenor200>();
        
        for (int i = 0; i < listado.size(); i++) {
            Object obj[] = (Object [])listado.get(i);
            ClientesMenor200 v = new ClientesMenor200();
        
            v.setFecha_emision(v.formatearFecha(obj[0].toString()));
            v.setNumero_registro(obj[1].toString());
            v.setMonto_operacion(obj[2].toString());
            v.setIVA_operacion(obj[3].toString());
            v.setAnio(obj[4].toString());
            
            lstVta.add(v);
        }
        
        return lstVta; 
   }
}
