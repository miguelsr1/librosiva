/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "VENTA_CONTRIBUYENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaContribuyente.findAll", query = "SELECT v FROM VentaContribuyente v"),
    @NamedQuery(name = "VentaContribuyente.findByIdVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "VentaContribuyente.findByAplicacionVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.aplicacionVenta = :aplicacionVenta"),
    @NamedQuery(name = "VentaContribuyente.findByContableVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.contableVenta = :contableVenta"),
    @NamedQuery(name = "VentaContribuyente.findByCsvVtaC", query = "SELECT v FROM VentaContribuyente v WHERE v.csvVtaC = :csvVtaC"),
    @NamedQuery(name = "VentaContribuyente.findByDia", query = "SELECT v FROM VentaContribuyente v WHERE v.dia = :dia"),
    @NamedQuery(name = "VentaContribuyente.findByEliminado", query = "SELECT v FROM VentaContribuyente v WHERE v.eliminado = :eliminado"),
    @NamedQuery(name = "VentaContribuyente.findByExentaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.exentaVenta = :exentaVenta"),
    @NamedQuery(name = "VentaContribuyente.findByGravadaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.gravadaVenta = :gravadaVenta"),
    @NamedQuery(name = "VentaContribuyente.findByIvaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.ivaVenta = :ivaVenta"),
    @NamedQuery(name = "VentaContribuyente.findByMesAnhoVtaC", query = "SELECT v FROM VentaContribuyente v WHERE v.mesAnhoVtaC = :mesAnhoVtaC"),
    @NamedQuery(name = "VentaContribuyente.findByNCompVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.nCompVenta = :nCompVenta"),
    @NamedQuery(name = "VentaContribuyente.findByNForm", query = "SELECT v FROM VentaContribuyente v WHERE v.nForm = :nForm"),
    @NamedQuery(name = "VentaContribuyente.findByNumVtaC", query = "SELECT v FROM VentaContribuyente v WHERE v.numVtaC = :numVtaC"),
    @NamedQuery(name = "VentaContribuyente.findByPercepcionVtaC", query = "SELECT v FROM VentaContribuyente v WHERE v.percepcionVtaC = :percepcionVtaC"),
    @NamedQuery(name = "VentaContribuyente.findByRetencionVtaC", query = "SELECT v FROM VentaContribuyente v WHERE v.retencionVtaC = :retencionVtaC"),
    @NamedQuery(name = "VentaContribuyente.findByTotIva", query = "SELECT v FROM VentaContribuyente v WHERE v.totIva = :totIva"),
    @NamedQuery(name = "VentaContribuyente.findByTotVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.totVenta = :totVenta"),
    @NamedQuery(name = "VentaContribuyente.findByTotalExentaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.totalExentaVenta = :totalExentaVenta"),
    @NamedQuery(name = "VentaContribuyente.findByTotalGravadaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.totalGravadaVenta = :totalGravadaVenta"),
    @NamedQuery(name = "VentaContribuyente.findByTotalIvaVenta", query = "SELECT v FROM VentaContribuyente v WHERE v.totalIvaVenta = :totalIvaVenta")})
public class VentaContribuyente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    @Column(name = "APLICACION_VENTA")
    private Boolean aplicacionVenta;
    @Column(name = "CONTABLE_VENTA")
    private Boolean contableVenta;
    @Column(name = "CSV_VTA_C")
    private Boolean csvVtaC;
    @Basic(optional = false)
    @Column(name = "DIA")
    private int dia;
    @Basic(optional = false)
    @Column(name = "ELIMINADO")
    private Boolean eliminado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXENTA_VENTA")
    private BigDecimal exentaVenta;
    @Column(name = "GRAVADA_VENTA")
    private BigDecimal gravadaVenta;
    @Column(name = "IVA_VENTA")
    private BigDecimal ivaVenta;
    @Basic(optional = false)
    @Column(name = "MES_ANHO_VTA_C")
    private String mesAnhoVtaC;
    @Column(name = "N_COMP_VENTA")
    private String nCompVenta;
    @Column(name = "N_FORM")
    private String nForm;
    @Column(name = "NUM_VTA_C")
    private Integer numVtaC;
    @Column(name = "PERCEPCION_VTA_C")
    private BigDecimal percepcionVtaC;
    @Column(name = "RETENCION_VTA_C")
    private BigDecimal retencionVtaC;
    @Column(name = "TOT_IVA")
    private BigDecimal totIva;
    @Column(name = "TOT_VENTA")
    private BigDecimal totVenta;
    @Column(name = "TOTAL_EXENTA_VENTA")
    private BigDecimal totalExentaVenta;
    @Column(name = "TOTAL_GRAVADA_VENTA")
    private BigDecimal totalGravadaVenta;
    @Column(name = "TOTAL_IVA_VENTA")
    private BigDecimal totalIvaVenta;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "CODIGO_SUCURSAL", referencedColumnName = "CODIGO_SUCURSAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal codigoSucursal;
    @JoinColumn(name = "CODIGO_ORG", referencedColumnName = "CODIGO_ORG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Organizacion codigoOrg;
    @JoinColumn(name = "ID_DOC", referencedColumnName = "ID_DOC")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Documento idDoc;

    public VentaContribuyente() {
    }

    public VentaContribuyente(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public VentaContribuyente(Integer idVenta, int dia, Boolean eliminado, String mesAnhoVtaC) {
        this.idVenta = idVenta;
        this.dia = dia;
        this.eliminado = eliminado;
        this.mesAnhoVtaC = mesAnhoVtaC;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Boolean getAplicacionVenta() {
        return aplicacionVenta;
    }

    public void setAplicacionVenta(Boolean aplicacionVenta) {
        Boolean oldAplicacionVenta = this.aplicacionVenta;
        this.aplicacionVenta = aplicacionVenta;
        changeSupport.firePropertyChange("aplicacionVenta", oldAplicacionVenta, aplicacionVenta);
    }

    public Boolean getContableVenta() {
        return contableVenta;
    }

    public void setContableVenta(Boolean contableVenta) {
        Boolean oldContableVenta = this.contableVenta;
        this.contableVenta = contableVenta;
        changeSupport.firePropertyChange("contableVenta", oldContableVenta, contableVenta);
    }

    public Boolean getCsvVtaC() {
        return csvVtaC;
    }

    public void setCsvVtaC(Boolean csvVtaC) {
        Boolean oldCsvVtaC = this.csvVtaC;
        this.csvVtaC = csvVtaC;
        changeSupport.firePropertyChange("csvVtaC", oldCsvVtaC, csvVtaC);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        int oldDia = this.dia;
        this.dia = dia;
        changeSupport.firePropertyChange("dia", oldDia, dia);
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        Boolean oldEliminado = this.eliminado;
        this.eliminado = eliminado;
        changeSupport.firePropertyChange("eliminado", oldEliminado, eliminado);
    }

    public BigDecimal getExentaVenta() {
        return exentaVenta;
    }

    public void setExentaVenta(BigDecimal exentaVenta) {
        BigDecimal oldExentaVenta = this.exentaVenta;
        this.exentaVenta = exentaVenta;
        changeSupport.firePropertyChange("exentaVenta", oldExentaVenta, exentaVenta);
    }

    public BigDecimal getGravadaVenta() {
        return gravadaVenta;
    }

    public void setGravadaVenta(BigDecimal gravadaVenta) {
        BigDecimal oldGravadaVenta = this.gravadaVenta;
        this.gravadaVenta = gravadaVenta;
        changeSupport.firePropertyChange("gravadaVenta", oldGravadaVenta, gravadaVenta);
    }

    public BigDecimal getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(BigDecimal ivaVenta) {
        BigDecimal oldIvaVenta = this.ivaVenta;
        this.ivaVenta = ivaVenta;
        changeSupport.firePropertyChange("ivaVenta", oldIvaVenta, ivaVenta);
    }

    public String getMesAnhoVtaC() {
        return mesAnhoVtaC;
    }

    public void setMesAnhoVtaC(String mesAnhoVtaC) {
        String oldMesAnhoVtaC = this.mesAnhoVtaC;
        this.mesAnhoVtaC = mesAnhoVtaC;
        changeSupport.firePropertyChange("mesAnhoVtaC", oldMesAnhoVtaC, mesAnhoVtaC);
    }

    public String getNCompVenta() {
        return nCompVenta;
    }

    public void setNCompVenta(String nCompVenta) {
        String oldNCompVenta = this.nCompVenta;
        this.nCompVenta = nCompVenta;
        changeSupport.firePropertyChange("nCompVenta", oldNCompVenta, nCompVenta);
    }

    public String getNForm() {
        return nForm;
    }

    public void setNForm(String nForm) {
        String oldNForm = this.nForm;
        this.nForm = nForm;
        changeSupport.firePropertyChange("nForm", oldNForm, nForm);
    }

    public Integer getNumVtaC() {
        return numVtaC;
    }

    public void setNumVtaC(Integer numVtaC) {
        Integer oldNumVtaC = this.numVtaC;
        this.numVtaC = numVtaC;
        changeSupport.firePropertyChange("numVtaC", oldNumVtaC, numVtaC);
    }

    public BigDecimal getPercepcionVtaC() {
        return percepcionVtaC;
    }

    public void setPercepcionVtaC(BigDecimal percepcionVtaC) {
        BigDecimal oldPercepcionVtaC = this.percepcionVtaC;
        this.percepcionVtaC = percepcionVtaC;
        changeSupport.firePropertyChange("percepcionVtaC", oldPercepcionVtaC, percepcionVtaC);
    }

    public BigDecimal getRetencionVtaC() {
        return retencionVtaC;
    }

    public void setRetencionVtaC(BigDecimal retencionVtaC) {
        BigDecimal oldRetencionVtaC = this.retencionVtaC;
        this.retencionVtaC = retencionVtaC;
        changeSupport.firePropertyChange("retencionVtaC", oldRetencionVtaC, retencionVtaC);
    }

    public BigDecimal getTotIva() {
        return totIva;
    }

    public void setTotIva(BigDecimal totIva) {
        BigDecimal oldTotIva = this.totIva;
        this.totIva = totIva;
        changeSupport.firePropertyChange("totIva", oldTotIva, totIva);
    }

    public BigDecimal getTotVenta() {
        return totVenta;
    }

    public void setTotVenta(BigDecimal totVenta) {
        BigDecimal oldTotVenta = this.totVenta;
        this.totVenta = totVenta;
        changeSupport.firePropertyChange("totVenta", oldTotVenta, totVenta);
    }

    public BigDecimal getTotalExentaVenta() {
        return totalExentaVenta;
    }

    public void setTotalExentaVenta(BigDecimal totalExentaVenta) {
        BigDecimal oldTotalExentaVenta = this.totalExentaVenta;
        this.totalExentaVenta = totalExentaVenta;
        changeSupport.firePropertyChange("totalExentaVenta", oldTotalExentaVenta, totalExentaVenta);
    }

    public BigDecimal getTotalGravadaVenta() {
        return totalGravadaVenta;
    }

    public void setTotalGravadaVenta(BigDecimal totalGravadaVenta) {
        BigDecimal oldTotalGravadaVenta = this.totalGravadaVenta;
        this.totalGravadaVenta = totalGravadaVenta;
        changeSupport.firePropertyChange("totalGravadaVenta", oldTotalGravadaVenta, totalGravadaVenta);
    }

    public BigDecimal getTotalIvaVenta() {
        return totalIvaVenta;
    }

    public void setTotalIvaVenta(BigDecimal totalIvaVenta) {
        BigDecimal oldTotalIvaVenta = this.totalIvaVenta;
        this.totalIvaVenta = totalIvaVenta;
        changeSupport.firePropertyChange("totalIvaVenta", oldTotalIvaVenta, totalIvaVenta);
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        Usuario oldUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldUsuario, idUsuario);
    }

    public Sucursal getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Sucursal codigoSucursal) {
        Sucursal oldSucursal = this.codigoSucursal;
        this.codigoSucursal = codigoSucursal;
        changeSupport.firePropertyChange("codigoSucursal", oldSucursal, codigoSucursal);
    }

    public Organizacion getCodigoOrg() {
        return codigoOrg;
    }

    public void setCodigoOrg(Organizacion codigoOrg) {
        Organizacion oldOrg = this.codigoOrg;
        this.codigoOrg = codigoOrg;
        changeSupport.firePropertyChange("codigoOrg", oldOrg, codigoOrg);
    }

    public Documento getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Documento idDoc) {
        Documento oldDoc = this.idDoc;
        this.idDoc = idDoc;
        changeSupport.firePropertyChange("idDoc", oldDoc, idDoc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaContribuyente)) {
            return false;
        }
        VentaContribuyente other = (VentaContribuyente) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.VentaContribuyente[ idVenta=" + idVenta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}