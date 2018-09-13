/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanchez
 */
@Entity
@Table(name = "COMPRA", catalog = "SKY_LIBROS_IVA", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByAplicacion", query = "SELECT c FROM Compra c WHERE c.aplicacion = :aplicacion"),
    @NamedQuery(name = "Compra.findByContable", query = "SELECT c FROM Compra c WHERE c.contable = :contable"),
    @NamedQuery(name = "Compra.findByEliminado", query = "SELECT c FROM Compra c WHERE c.eliminado = :eliminado"),
    @NamedQuery(name = "Compra.findByExcluidoCompra", query = "SELECT c FROM Compra c WHERE c.excluidoCompra = :excluidoCompra"),
    @NamedQuery(name = "Compra.findByFechaCompra", query = "SELECT c FROM Compra c WHERE c.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Compra.findByImportacionExenta", query = "SELECT c FROM Compra c WHERE c.importacionExenta = :importacionExenta"),
    @NamedQuery(name = "Compra.findByImportacionGravada", query = "SELECT c FROM Compra c WHERE c.importacionGravada = :importacionGravada"),
    @NamedQuery(name = "Compra.findByInternaExenta", query = "SELECT c FROM Compra c WHERE c.internaExenta = :internaExenta"),
    @NamedQuery(name = "Compra.findByInternaGravada", query = "SELECT c FROM Compra c WHERE c.internaGravada = :internaGravada"),
    @NamedQuery(name = "Compra.findByIvaCompra", query = "SELECT c FROM Compra c WHERE c.ivaCompra = :ivaCompra"),
    @NamedQuery(name = "Compra.findByMesAnhoCompra", query = "SELECT c FROM Compra c WHERE c.mesAnhoCompra = :mesAnhoCompra"),
    @NamedQuery(name = "Compra.findByMontoImp", query = "SELECT c FROM Compra c WHERE c.montoImp = :montoImp"),
    @NamedQuery(name = "Compra.findByNCompCompra", query = "SELECT c FROM Compra c WHERE c.nCompCompra = :nCompCompra"),
    @NamedQuery(name = "Compra.findByNumCompra", query = "SELECT c FROM Compra c WHERE c.numCompra = :numCompra"),
    @NamedQuery(name = "Compra.findByPercepcionIvaCompra", query = "SELECT c FROM Compra c WHERE c.percepcionIvaCompra = :percepcionIvaCompra"),
    @NamedQuery(name = "Compra.findByRetencionIvaCompra", query = "SELECT c FROM Compra c WHERE c.retencionIvaCompra = :retencionIvaCompra"),
    @NamedQuery(name = "Compra.findByRetencionTercero", query = "SELECT c FROM Compra c WHERE c.retencionTercero = :retencionTercero"),
    @NamedQuery(name = "Compra.findByTotalCompra", query = "SELECT c FROM Compra c WHERE c.totalCompra = :totalCompra")})
public class Compra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMPRA", nullable = false)
    private Integer idCompra;
    @Column(name = "APLICACION")
    private Boolean aplicacion;
    @Column(name = "CONTABLE")
    private Boolean contable;
    @Column(name = "ELIMINADO")
    private Boolean eliminado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXCLUIDO_COMPRA", precision = 8, scale = 2)
    private BigDecimal excluidoCompra;
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "IMPORTACION_EXENTA", precision = 8, scale = 2)
    private BigDecimal importacionExenta;
    @Column(name = "IMPORTACION_GRAVADA", precision = 8, scale = 2)
    private BigDecimal importacionGravada;
    @Column(name = "INTERNA_EXENTA", precision = 8, scale = 2)
    private BigDecimal internaExenta;
    @Column(name = "INTERNA_GRAVADA", precision = 8, scale = 2)
    private BigDecimal internaGravada;
    @Column(name = "IVA_COMPRA", precision = 8, scale = 2)
    private BigDecimal ivaCompra;
    @Column(name = "MES_ANHO_COMPRA", length = 6)
    private String mesAnhoCompra;
    @Column(name = "MONTO_IMP", precision = 8, scale = 2)
    private BigDecimal montoImp;
    @Column(name = "N_COMP_COMPRA", length = 20)
    private String nCompCompra;
    @Column(name = "NUM_COMPRA")
    private Integer numCompra;
    @Column(name = "PERCEPCION_IVA_COMPRA", precision = 8, scale = 2)
    private BigDecimal percepcionIvaCompra;
    @Column(name = "RETENCION_IVA_COMPRA", precision = 8, scale = 2)
    private BigDecimal retencionIvaCompra;
    @Column(name = "RETENCION_TERCERO", precision = 8, scale = 2)
    private BigDecimal retencionTercero;
    @Column(name = "TOTAL_COMPRA", precision = 8, scale = 2)
    private BigDecimal totalCompra;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "CODIGO_SUCURSAL", referencedColumnName = "CODIGO_SUCURSAL", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal codigoSucursal;
    @JoinColumn(name = "CODIGO_ORG", referencedColumnName = "CODIGO_ORG", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Organizacion codigoOrg;
    @JoinColumn(name = "ID_MODALIDAD", referencedColumnName = "ID_MODALIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modalidad idModalidad;
    @JoinColumn(name = "ID_DOC", referencedColumnName = "ID_DOC", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Documento idDoc;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        Integer oldIdCompra = this.idCompra;
        this.idCompra = idCompra;
        changeSupport.firePropertyChange("idCompra", oldIdCompra, idCompra);
    }

    public Boolean getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Boolean aplicacion) {
        Boolean oldAplicacion = this.aplicacion;
        this.aplicacion = aplicacion;
        changeSupport.firePropertyChange("aplicacion", oldAplicacion, aplicacion);
    }

    public Boolean getContable() {
        return contable;
    }

    public void setContable(Boolean contable) {
        Boolean oldContable = this.contable;
        this.contable = contable;
        changeSupport.firePropertyChange("contable", oldContable, contable);
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        Boolean oldEliminado = this.eliminado;
        this.eliminado = eliminado;
        changeSupport.firePropertyChange("eliminado", oldEliminado, eliminado);
    }

    public BigDecimal getExcluidoCompra() {
        return excluidoCompra;
    }

    public void setExcluidoCompra(BigDecimal excluidoCompra) {
        BigDecimal oldExcluidoCompra = this.excluidoCompra;
        this.excluidoCompra = excluidoCompra;
        changeSupport.firePropertyChange("excluidoCompra", oldExcluidoCompra, excluidoCompra);
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        Date oldFechaCompra = this.fechaCompra;
        this.fechaCompra = fechaCompra;
        changeSupport.firePropertyChange("fechaCompra", oldFechaCompra, fechaCompra);
    }

    public BigDecimal getImportacionExenta() {
        return importacionExenta;
    }

    public void setImportacionExenta(BigDecimal importacionExenta) {
        BigDecimal oldImportacionExenta = this.importacionExenta;
        this.importacionExenta = importacionExenta;
        changeSupport.firePropertyChange("importacionExenta", oldImportacionExenta, importacionExenta);
    }

    public BigDecimal getImportacionGravada() {
        return importacionGravada;
    }

    public void setImportacionGravada(BigDecimal importacionGravada) {
        BigDecimal oldImportacionGravada = this.importacionGravada;
        this.importacionGravada = importacionGravada;
        changeSupport.firePropertyChange("importacionGravada", oldImportacionGravada, importacionGravada);
    }

    public BigDecimal getInternaExenta() {
        return internaExenta;
    }

    public void setInternaExenta(BigDecimal internaExenta) {
        BigDecimal oldInternaExenta = this.internaExenta;
        this.internaExenta = internaExenta;
        changeSupport.firePropertyChange("internaExenta", oldInternaExenta, internaExenta);
    }

    public BigDecimal getInternaGravada() {
        return internaGravada;
    }

    public void setInternaGravada(BigDecimal internaGravada) {
        BigDecimal oldInternaGravada = this.internaGravada;
        this.internaGravada = internaGravada;
        changeSupport.firePropertyChange("internaGravada", oldInternaGravada, internaGravada);
    }

    public BigDecimal getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(BigDecimal ivaCompra) {
        BigDecimal oldIvaCompra = this.ivaCompra;
        this.ivaCompra = ivaCompra;
        changeSupport.firePropertyChange("ivaCompra", oldIvaCompra, ivaCompra);
    }

    public String getMesAnhoCompra() {
        return mesAnhoCompra;
    }

    public void setMesAnhoCompra(String mesAnhoCompra) {
        String oldMesAnhoCompra = this.mesAnhoCompra;
        this.mesAnhoCompra = mesAnhoCompra;
        changeSupport.firePropertyChange("mesAnhoCompra", oldMesAnhoCompra, mesAnhoCompra);
    }

    public BigDecimal getMontoImp() {
        return montoImp;
    }

    public void setMontoImp(BigDecimal montoImp) {
        BigDecimal oldMontoImp = this.montoImp;
        this.montoImp = montoImp;
        changeSupport.firePropertyChange("montoImp", oldMontoImp, montoImp);
    }

    public String getNCompCompra() {
        return nCompCompra;
    }

    public void setNCompCompra(String nCompCompra) {
        String oldNCompCompra = this.nCompCompra;
        this.nCompCompra = nCompCompra;
        changeSupport.firePropertyChange("NCompCompra", oldNCompCompra, nCompCompra);
    }

    public Integer getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(Integer numCompra) {
        Integer oldNumCompra = this.numCompra;
        this.numCompra = numCompra;
        changeSupport.firePropertyChange("numCompra", oldNumCompra, numCompra);
    }

    public BigDecimal getPercepcionIvaCompra() {
        return percepcionIvaCompra;
    }

    public void setPercepcionIvaCompra(BigDecimal percepcionIvaCompra) {
        BigDecimal oldPercepcionIvaCompra = this.percepcionIvaCompra;
        this.percepcionIvaCompra = percepcionIvaCompra;
        changeSupport.firePropertyChange("percepcionIvaCompra", oldPercepcionIvaCompra, percepcionIvaCompra);
    }

    public BigDecimal getRetencionIvaCompra() {
        return retencionIvaCompra;
    }

    public void setRetencionIvaCompra(BigDecimal retencionIvaCompra) {
        BigDecimal oldRetencionIvaCompra = this.retencionIvaCompra;
        this.retencionIvaCompra = retencionIvaCompra;
        changeSupport.firePropertyChange("retencionIvaCompra", oldRetencionIvaCompra, retencionIvaCompra);
    }

    public BigDecimal getRetencionTercero() {
        return retencionTercero;
    }

    public void setRetencionTercero(BigDecimal retencionTercero) {
        BigDecimal oldRetencionTercero = this.retencionTercero;
        this.retencionTercero = retencionTercero;
        changeSupport.firePropertyChange("retencionTercero", oldRetencionTercero, retencionTercero);
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        BigDecimal oldTotalCompra = this.totalCompra;
        this.totalCompra = totalCompra;
        changeSupport.firePropertyChange("totalCompra", oldTotalCompra, totalCompra);
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        Usuario oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    public Sucursal getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Sucursal codigoSucursal) {
        Sucursal oldCodigoSucursal = this.codigoSucursal;
        this.codigoSucursal = codigoSucursal;
        changeSupport.firePropertyChange("codigoSucursal", oldCodigoSucursal, codigoSucursal);
    }

    public Organizacion getCodigoOrg() {
        return codigoOrg;
    }

    public void setCodigoOrg(Organizacion codigoOrg) {
        Organizacion oldCodigoOrg = this.codigoOrg;
        this.codigoOrg = codigoOrg;
        changeSupport.firePropertyChange("codigoOrg", oldCodigoOrg, codigoOrg);
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        Modalidad oldIdModalidad = this.idModalidad;
        this.idModalidad = idModalidad;
        changeSupport.firePropertyChange("idModalidad", oldIdModalidad, idModalidad);
    }

    public Documento getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Documento idDoc) {
        Documento oldIdDoc = this.idDoc;
        this.idDoc = idDoc;
        changeSupport.firePropertyChange("idDoc", oldIdDoc, idDoc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Compra[ idCompra=" + idCompra + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
