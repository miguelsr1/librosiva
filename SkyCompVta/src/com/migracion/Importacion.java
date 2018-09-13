/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migracion;

import com.entidades.*;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.utilidades.AdministradorEntidades;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author misanchez
 */
public class Importacion {

    private static EntityManager em = null;

    public static void compras(String path, String mesAnho) {
        em = AdministradorEntidades.getInstance().getEM();

        try {
            DBFReader dbfIn = new DBFReader(new FileInputStream(new File(path)));

            Compra compra;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                compra = new Compra();
                Double seq = Double.parseDouble(rowObjects[0].toString());
                compra.setNumCompra(seq.intValue());
                compra.setFechaCompra((Date) rowObjects[1]);
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
                compra.setMesAnhoCompra(mesAnho);

                if (compra.getCodigoOrg() != null) {
                    em.persist(compra);
                } else {
                    System.out.println("compra: " + compra.getNumCompra() + " - proveedor: " + rowObjects[6].toString().trim());
                }
            }

            em.getTransaction().commit();

        } catch (IOException ex) {
            System.out.println("Error en IMPORTACION\n");
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

    public static void organizacion(String path, int idTipoOrg) {
        em = AdministradorEntidades.getInstance().getEM();
        InputStream is = null;

        try {
            is = new FileInputStream(new File(path));
            DBFReader dbfIn = new DBFReader(is);

            Organizacion org;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                if (!rowObjects[0].toString().trim().equals("")) {

                    if (em.find(Organizacion.class, rowObjects[0].toString().trim()) != null) {
                        org = em.find(Organizacion.class, rowObjects[0].toString().trim());
                        org.setIdTipoOrg(em.find(TipoOrganizacion.class, 3));
                    } else {
                        org = new Organizacion();
                        org.setIdTipoOrg(em.find(TipoOrganizacion.class, idTipoOrg));
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

                    if (org.getCodigoOrg() != null) {
                        try {
                            em.persist(org);
                        } catch (Exception e) {
                            System.out.println("org: " + org.getCodigoOrg());
                        }
                    } else {
                        System.out.println("org: " + org.getCodigoOrg());
                    }
                }
            }

            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "FIN DE IMPORTACION");
        } catch (IOException ex) {
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Importacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void ventaConsumidorFinal(String path, String mesAnho) {
        em = AdministradorEntidades.getInstance().getEM();
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            DBFReader dbfIn = new DBFReader(is);

            VentaConsumidor vta;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                vta = new VentaConsumidor();

                Double seq = Double.parseDouble(rowObjects[0].toString());
                vta.setNumVtaF(seq.intValue());
                if (!rowObjects[1].toString().trim().isEmpty()) {
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
                    vta.setMesAnhoVtaCf(mesAnho);
                    vta.setEliminado(false);

                    em.persist(vta);
                }
            }

            em.getTransaction().commit();

            System.out.println("FIN DE IMPORTACION\n");
        } catch (IOException ex) {
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Importacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void ventaContribuyente(String path, String mesAnho) {
        em = AdministradorEntidades.getInstance().getEM();
        int j = 0;
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            DBFReader dbfIn = new DBFReader(is);

            VentaContribuyente vta;

            for (int i = 0; i < dbfIn.getFieldCount(); i++) {
                DBFField field = dbfIn.getField(i);
                System.out.println(field.getName() + "-" + i);
            }

            Object[] rowObjects;

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            while ((rowObjects = dbfIn.nextRecord()) != null) {
                vta = new VentaContribuyente();

                Double seq = Double.parseDouble(rowObjects[0].toString());
                vta.setNumVtaC(seq.intValue());
                if (!rowObjects[1].toString().trim().isEmpty()) {
                    seq = Double.parseDouble(rowObjects[1].toString());
                    vta.setDia(seq.intValue());
                    vta.setIdDoc(em.find(Documento.class, getIdDoc(rowObjects[2])));
                    vta.setNCompVenta(rowObjects[3].toString().trim());
                    vta.setNForm(rowObjects[4].toString().trim());
                    Organizacion org = em.find(Organizacion.class, rowObjects[5].toString().trim());
                    if(org == null)
                        vta.setCodigoOrg(em.find(Organizacion.class, "0"));
                    else
                    vta.setCodigoOrg(org);
                    vta.setExentaVenta(getCantidad(rowObjects[8]));
                    vta.setGravadaVenta(getCantidad(rowObjects[9]));
                    vta.setIvaVenta(getCantidad(rowObjects[10]));
                    vta.setTotalExentaVenta(getCantidad(rowObjects[11]));
                    vta.setTotalGravadaVenta(getCantidad(rowObjects[12]));
                    vta.setTotalIvaVenta(getCantidad(rowObjects[13]));
                    vta.setTotVenta(getCantidad(rowObjects[14]));
                    vta.setTotIva(getCantidad(rowObjects[15]));
                    vta.setAplicacionVenta((Boolean) rowObjects[16]);
                    vta.setContableVenta((Boolean) rowObjects[17]);

                    vta.setCodigoSucursal(em.find(Sucursal.class, "1"));
                    vta.setIdUsuario(em.find(Usuario.class, 1));
                    vta.setEliminado(false);
                    vta.setMesAnhoVtaC(mesAnho);

                    em.persist(vta);
                    j++;
                }
            }

            em.getTransaction().commit();

            is.close();

            System.out.println("FIN DE IMPORTACION\n");
        } catch (IOException ex) {
            System.out.println("ERROR EN IMPORTACION\n" + j);
            Logger.getLogger(MigracionCompras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Importacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static int getIdDoc(Object doc) {
        if (doc != null) {
            if (doc.toString().trim().equals("CREDITO FISCAL")) {
                return 1;
            } else if (doc.toString().trim().equals("COMPROBANTE CONTABLE DE LIQUIDACION")) {
                return 2;
            } else if (doc.toString().trim().equals("COMPROBANTE DE RETENCION")) {
                return 3;  
            } else if (doc.toString().trim().equals("DEBITO FISCAL")) {
                return 4;
            } else if (doc.toString().trim().equals("NOTA DE CREDITO")) {
                return 5;
            } else if (doc.toString().trim().equals("NOTA DE DEBITO")) {
                return 6;
            } else if (doc.toString().trim().equals("EXCLUIDOS")) {
                return 7;
            }
        }

        return 3;
    }

    private static Modalidad getIdModalidad(Object modalidad) {
        int mod;
        if (modalidad != null) {
            if (modalidad.toString().trim().equals("PERCEPCION")) {
                mod = 1;
            } else {
                mod = -1;
            }
        } else {
            mod = -1;
        }

        return em.find(Modalidad.class, mod);
    }

    private static BigDecimal getCantidad(Object cantidad) {
        if (cantidad != null) {
            if (!cantidad.toString().trim().equals("")) {
                return new BigDecimal(cantidad.toString().trim());
            }
        }

        return null;
    }
}
