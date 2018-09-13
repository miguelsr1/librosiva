/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migracion;

import com.entidades.*;
import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.utilidades.AdministradorEntidades;
import com.utilidades.Fechas;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *22645047 neurolab
 * @author misanchez
 */
public class MigracionCompras {
    private static EntityManager em=null;
    public static void main(String[] args) throws FileNotFoundException, DBFException {
        em = AdministradorEntidades.getInstance().getEM();
        
        try {
            InputStream is = new FileInputStream("/home/misanchez/Documentos/Personal/Sky/BASE_DTH_SKY/Compras/com012011.DBF");
            DBFReader dbfIn = new DBFReader(is);
            
            //em.getTransaction().begin();
            Compra compra;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName()+"-"+i);
            }

            Object[] rowObjects;

            em.getTransaction().begin();
            
            while ((rowObjects = dbfIn.nextRecord()) != null) {
                compra = new Compra();
                Double seq = Double.parseDouble(rowObjects[0].toString());
                compra.setNumCompra(seq.intValue());
                compra.setFechaCompra((Date)rowObjects[1]);
                compra.setIdDoc(em.find(Documento.class, getIdDoc(rowObjects[2])));
                compra.setNCompCompra(rowObjects[3].toString().trim());
                compra.setCodigoOrg(em.find(Organizacion.class, rowObjects[4].toString().trim()));
                compra.setInternaExenta(getCantidad(rowObjects[8]));
                compra.setImportacionExenta(getCantidad(rowObjects[9]));
                compra.setInternaGravada(getCantidad(rowObjects[10]));
                compra.setImportacionGravada(getCantidad(rowObjects[11]));
                compra.setIvaCompra(getCantidad(rowObjects[12]));
                compra.setTotalCompra(getCantidad(rowObjects[13]));
                compra.setRetencionTercero(getCantidad(rowObjects[14]));
                compra.setExcluidoCompra(getCantidad(rowObjects[15]));
                compra.setCodigoSucursal(em.find(Sucursal.class, "1"));
                compra.setIdModalidad(getIdModalidad(rowObjects[23]));
                compra.setMontoImp(getCantidad(rowObjects[24]));
                compra.setIdUsuario(em.find(Usuario.class, 1));
                compra.setEliminado(false);
                compra.setMesAnhoCompra(Fechas.getNumeroMes("1").concat("2011"));
                
                if(compra.getCodigoOrg() != null)
                    em.persist(compra);
                else{
                    System.out.println("compra: "+compra.getNumCompra()+" - proveedor: "+rowObjects[6].toString().trim());
                }
            }
            
            em.getTransaction().commit();

            is.close();
            

            System.out.println("FIN DE IMPORTACION\n");
        } catch (IOException ex) {
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            em.close();
        }
    }
    
    private static int getIdDoc(Object doc){
        if(doc != null){
            if(doc.toString().trim().equals("CREDITO FISCAL"))
                return 1;
            else if(doc.toString().trim().equals("COMPROBANTE CONTABLE DE LIQUIDACION"))
                return 2;
            else if(doc.toString().trim().equals("COMPROBANTE DE RETENCION"))
                return 3;
            else if(doc.toString().trim().equals("NOTA DE CREDITO"))
                return 5;
            else if(doc.toString().trim().equals("NOTA DE DEBITO"))
                return 6;
            else if(doc.toString().trim().equals("EXCLUIDOS"))
                return 7;
        }
        
        return 3;
    }
    
    private static Modalidad getIdModalidad(Object modalidad){
        int mod;
        if(modalidad != null){
            if(modalidad.toString().trim().equals("PERCEPCION"))
                mod = 1;
            else
                mod = -1;
        }else 
            mod = -1;
        
        return em.find(Modalidad.class, mod);
    }
    
    private static BigDecimal getCantidad(Object cantidad){
        if(cantidad != null){
            if(!cantidad.equals(""))
                return new BigDecimal(cantidad.toString().trim());
        }
        
        return null;
    }
}
