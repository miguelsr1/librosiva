/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migracion;

import com.entidades.Sucursal;
import com.entidades.Usuario;
import com.entidades.VentaConsumidor;
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
public class MigracionVtaCF {

    private static EntityManager em = null;

    public static void main(String[] args) throws FileNotFoundException, DBFException {
        em = AdministradorEntidades.getInstance().getEM();
        try {
            InputStream is = new FileInputStream("/home/sanchez/Documentos/Sky/BASE_DTH_SKY/con012010.DBF");
            DBFReader dbfIn = new DBFReader(is);

            VentaConsumidor vta;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            em.getTransaction().begin();

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                vta = new VentaConsumidor();

                Double seq = Double.parseDouble(rowObjects[0].toString());
                vta.setNumVtaF(seq.intValue());
                seq = Double.parseDouble(rowObjects[1].toString());
                vta.setDiaVtaConF(seq.intValue());
                vta.setDesde(rowObjects[2].toString().trim());
                vta.setHasta(rowObjects[3].toString().trim());
                vta.setMaquina(rowObjects[4].toString().trim());
                vta.setVtaExenConF(getCantidad(rowObjects[5]));
                vta.setVtaGravConF(getCantidad(rowObjects[6]));
                vta.setExporVtaConF(getCantidad(rowObjects[7]));
                vta.setTotalVtaConF(getCantidad(rowObjects[8]));
                vta.setTercerosVtaConF(getCantidad(rowObjects[9]));
                vta.setAplicacionVtaConF((Boolean) rowObjects[10]);
                vta.setContableVtaConF((Boolean) rowObjects[11]);
                vta.setCodigoSucursal(em.find(Sucursal.class, "1"));
                vta.setRetencionVtaConF(getCantidad(rowObjects[13]));
                vta.setPercencionVtaConF(getCantidad(rowObjects[14]));
                vta.setIdUsuario(em.find(Usuario.class, 1));
                vta.setMesAnhoVtaCf("012010");
                vta.setEliminado(false);

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
}