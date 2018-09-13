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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author sanchez
 */
public class MigracionVtaContribuyente {

    private static EntityManager em = null;

    public static void main(String[] args) throws FileNotFoundException, DBFException {
        em = AdministradorEntidades.getInstance().getEM();
        try {
            InputStream is = new FileInputStream("/home/misanchez/Documentos/Personal/Sky/BASE_DTH_SKY/VentasContribuyente/ven012010.DBF");
            DBFReader dbfIn = new DBFReader(is);

            VentaContribuyente vta;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            em.getTransaction().begin();

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                vta = new VentaContribuyente();

                Double seq = Double.parseDouble(rowObjects[0].toString());
                vta.setNumVtaC(seq.intValue());
                seq = Double.parseDouble(rowObjects[1].toString());
                vta.setDia(seq.intValue());
                vta.setIdDoc(em.find(Documento.class, getIdDoc(rowObjects[2])));
                vta.setNCompVenta(rowObjects[3].toString().trim());
                vta.setNForm(rowObjects[4].toString().trim());
                vta.setCodigoOrg(em.find(Organizacion.class, rowObjects[5].toString().trim()));
                vta.setExentaVenta(getCantidad(rowObjects[8]));
                vta.setGravadaVenta(getCantidad(rowObjects[9]));
                vta.setIvaVenta(getCantidad(rowObjects[10]));
                vta.setTotalExentaVenta(getCantidad(rowObjects[11]));
                vta.setTotalGravadaVenta(getCantidad(rowObjects[12]));
                vta.setTotalIvaVenta(getCantidad(rowObjects[13]));
                vta.setTotVenta(getCantidad(rowObjects[14]));
                vta.setTotIva(getCantidad(rowObjects[15]));
                vta.setAplicacionVenta((Boolean)rowObjects[16]);
                vta.setContableVenta((Boolean)rowObjects[17]);
                
                vta.setCodigoSucursal(em.find(Sucursal.class, "1"));
                vta.setIdUsuario(em.find(Usuario.class, 1));
                vta.setEliminado(false);
                vta.setMesAnhoVtaC("");

                em.persist(vta);
            }

            em.getTransaction().commit();

            is.close();

            System.out.println("FIN DE IMPORTACION\n");
        } catch (IOException ex) {
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
    }

    private static BigDecimal getCantidad(Object cantidad) {
        if (cantidad != null) {
            if (!cantidad.equals("")) {
                return new BigDecimal(cantidad.toString().trim());
            }
        }

        return null;
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
}