/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migracion;

import com.entidades.Organizacion;
import com.entidades.TipoOrganizacion;
import com.entidades.Usuario;
import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.utilidades.AdministradorEntidades;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author misanchez
 */
public class MigracionOrganizacion {
    private static EntityManager em = null;
    private static InputStream is = null;
    
    public static void main(String[] args) throws FileNotFoundException, DBFException, IOException {
        em = AdministradorEntidades.getInstance().getEM();
        
        try {
            is = new FileInputStream("/home/misanchez/Documentos/Personal/Sky/BASE_DTH_SKY/Proveedores/PROVEEDORES.DBF");
            DBFReader dbfIn = new DBFReader(is);
            
            Organizacion org;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName()+"-"+i);
            }

            Object[] rowObjects;

            em.getTransaction().begin();
            
            while ((rowObjects = dbfIn.nextRecord()) != null) {
                if(!rowObjects[0].toString().trim().equals("")){
                    
                    if(em.find(Organizacion.class, rowObjects[0].toString().trim()) != null){
                        org = em.find(Organizacion.class, rowObjects[0].toString().trim());
                        org.setIdTipoOrg(em.find(TipoOrganizacion.class, 3));
                    }else{
                        org = new Organizacion();
                        org.setIdTipoOrg(em.find(TipoOrganizacion.class, 2));
                    }
                    org.setCodigoOrg(rowObjects[0].toString().trim());
                    org.setNombreOrg(rowObjects[1].toString().trim());
                    org.setDireccionOrg(rowObjects[2].toString().trim());
                    org.setTelefonoOrg(rowObjects[3].toString().trim());
                    org.setFaxOrg(rowObjects[4].toString().trim());
                    org.setRegIvaOrg(rowObjects[5].toString().trim());
                    org.setNitOrg(rowObjects[6].toString().trim());
                    org.setEliminado(false);
                    org.setIdUsuario(em.find(Usuario.class, 1));

                    if(org.getCodigoOrg() != null)
                        try{
                            em.persist(org);
                        } catch(Exception e){
                            System.out.println("org: "+org.getCodigoOrg());
                        }
                    else{
                        System.out.println("org: "+org.getCodigoOrg());
                    }
                }
            }
            
            em.getTransaction().commit();
            
            System.out.println("FIN DE IMPORTACION\n");
        } catch (IOException ex) {
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            is.close();
            em.close();
        }
    }
}
