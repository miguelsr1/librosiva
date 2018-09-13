/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanchez
 */
@Entity
@Table(name = "VENTA_CONSUMIDOR", catalog = "SKY_LIBROS_IVA", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaConsumidor.findAll", query = "SELECT v FROM VentaConsumidor v"),
    @NamedQuery(name = "VentaConsumidor.findByIdVentaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.idVentaConF = :idVentaConF"),
    @NamedQuery(name = "VentaConsumidor.findByAplicacionVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.aplicacionVtaConF = :aplicacionVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByContableVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.contableVtaConF = :contableVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByDesde", query = "SELECT v FROM VentaConsumidor v WHERE v.desde = :desde"),
    @NamedQuery(name = "VentaConsumidor.findByDiaVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.diaVtaConF = :diaVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByEliminado", query = "SELECT v FROM VentaConsumidor v WHERE v.eliminado = :eliminado"),
    @NamedQuery(name = "VentaConsumidor.findByExporVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.exporVtaConF = :exporVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByHasta", query = "SELECT v FROM VentaConsumidor v WHERE v.hasta = :hasta"),
    @NamedQuery(name = "VentaConsumidor.findByMaquina", query = "SELECT v FROM VentaConsumidor v WHERE v.maquina = :maquina"),
    @NamedQuery(name = "VentaConsumidor.findByMesAnhoVtaCf", query = "SELECT v FROM VentaConsumidor v WHERE v.mesAnhoVtaCf = :mesAnhoVtaCf"),
    @NamedQuery(name = "VentaConsumidor.findByNumVtaF", query = "SELECT v FROM VentaConsumidor v WHERE v.numVtaF = :numVtaF"),
    @NamedQuery(name = "VentaConsumidor.findByPercencionVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.percencionVtaConF = :percencionVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByRetencionVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.retencionVtaConF = :retencionVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByTercerosVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.tercerosVtaConF = :tercerosVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByTotalVtaConF", query = "SELECT v FROM VentaConsumidor v WHERE v.totalVtaConF = :totalVtaConF"),
    @NamedQuery(name = "VentaConsumidor.findByVtaExenConF", query = "SELECT v FROM VentaConsumidor v WHERE v.vtaExenConF = :vtaExenConF"),
    @NamedQuery(name = "VentaConsumidor.findByVtaGravConF", query = "SELECT v FROM VentaConsumidor v WHERE v.vtaGravConF = :vtaGravConF")})
public class VentaConsumidor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENTA_CON_F", nullable = false)
    private Integer idVentaConF;
    @Column(name = "APLICACION_VTA_CON_F")
    private Boolean aplicacionVtaConF;
    @Column(name = "CONTABLE_VTA_CON_F")
    private Boolean contableVtaConF;
    @Column(name = "DESDE", length = 12)
    private String desde;
    @Column(name = "DIA_VTA_CON_F")
    private Integer diaVtaConF;
    @Basic(optional = false)
    @Column(name = "ELIMINADO", nullable = false)
    private Boolean eliminado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXPOR_VTA_CON_F", precision = 8, scale = 2)
    private BigDecimal exporVtaConF;
    @Column(name = "HASTA", length = 12)
    private String hasta;
    @Column(name = "MAQUINA", length = 12)
    private String maquina;
    @Basic(optional = false)
    @Column(name = "MES_ANHO_VTA_CF", nullable = false, length = 6)
    private String mesAnhoVtaCf;
    @Column(name = "NUM_VTA_F")
    private Integer numVtaF;
    @Column(name = "PERCENCION_VTA_CON_F", precision = 8, scale = 2)
    private BigDecimal percencionVtaConF;
    @Column(name = "RETENCION_VTA_CON_F", precision = 8, scale = 2)
    private BigDecimal retencionVtaConF;
    @Column(name = "TERCEROS_VTA_CON_F", precision = 8, scale = 2)
    private BigDecimal tercerosVtaConF;
    @Column(name = "TOTAL_VTA_CON_F", precision = 8, scale = 2)
    private BigDecimal totalVtaConF;
    @Column(name = "VTA_EXEN_CON_F", precision = 8, scale = 2)
    private BigDecimal vtaExenConF;
    @Column(name = "VTA_GRAV_CON_F", precision = 8, scale = 2)
    private BigDecimal vtaGravConF;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "CODIGO_SUCURSAL", referencedColumnName = "CODIGO_SUCURSAL", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal codigoSucursal;

    public VentaConsumidor() {
    }

    public VentaConsumidor(Integer idVentaConF) {
        this.idVentaConF = idVentaConF;
    }

    public VentaConsumidor(Integer idVentaConF, Boolean eliminado, String mesAnhoVtaCf) {
        this.idVentaConF = idVentaConF;
        this.eliminado = eliminado;
        this.mesAnhoVtaCf = mesAnhoVtaCf;
    }

    public Integer getIdVentaConF() {
        return idVentaConF;
    }

    public void setIdVentaConF(Integer idVentaConF) {
        Integer oldIdVentaConF = this.idVentaConF;
        this.idVentaConF = idVentaConF;
        changeSupport.firePropertyChange("idVentaConF", oldIdVentaConF, idVentaConF);
    }

    public Boolean getAplicacionVtaConF() {
        return aplicacionVtaConF;
    }

    public void setAplicacionVtaConF(Boolean aplicacionVtaConF) {
        Boolean oldAplicacionVtaConF = this.aplicacionVtaConF;
        this.aplicacionVtaConF = aplicacionVtaConF;
        changeSupport.firePropertyChange("aplicacionVtaConF", oldAplicacionVtaConF, aplicacionVtaConF);
    }

    public Boolean getContableVtaConF() {
        return contableVtaConF;
    }

    public void setContableVtaConF(Boolean contableVtaConF) {
        Boolean oldContableVtaConF = this.contableVtaConF;
        this.contableVtaConF = contableVtaConF;
        changeSupport.firePropertyChange("contableVtaConF", oldContableVtaConF, contableVtaConF);
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        String oldDesde = this.desde;
        this.desde = desde;
        changeSupport.firePropertyChange("desde", oldDesde, desde);
    }

    public Integer getDiaVtaConF() {
        return diaVtaConF;
    }

    public void setDiaVtaConF(Integer diaVtaConF) {
        Integer oldDiaVtaConF = this.diaVtaConF;
        this.diaVtaConF = diaVtaConF;
        changeSupport.firePropertyChange("diaVtaConF", oldDiaVtaConF, diaVtaConF);
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        Boolean oldEliminado = this.eliminado;
        this.eliminado = eliminado;
        changeSupport.firePropertyChange("eliminado", oldEliminado, eliminado);
    }

    public BigDecimal getExporVtaConF() {
        return exporVtaConF;
    }

    public void setExporVtaConF(BigDecimal exporVtaConF) {
        BigDecimal oldExporVtaConF = this.exporVtaConF;
        this.exporVtaConF = exporVtaConF;
        changeSupport.firePropertyChange("exporVtaConF", oldExporVtaConF, exporVtaConF);
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        String oldHasta = this.hasta;
        this.hasta = hasta;
        changeSupport.firePropertyChange("hasta", oldHasta, hasta);
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        String oldMaquina = this.maquina;
        this.maquina = maquina;
        changeSupport.firePropertyChange("maquina", oldMaquina, maquina);
    }

    public String getMesAnhoVtaCf() {
        return mesAnhoVtaCf;
    }

    public void setMesAnhoVtaCf(String mesAnhoVtaCf) {
        String oldMesAnhoVtaCf = this.mesAnhoVtaCf;
        this.mesAnhoVtaCf = mesAnhoVtaCf;
        changeSupport.firePropertyChange("mesAnhoVtaCf", oldMesAnhoVtaCf, mesAnhoVtaCf);
    }

    public Integer getNumVtaF() {
        return numVtaF;
    }

    public void setNumVtaF(Integer numVtaF) {
        Integer oldNumVtaF = this.numVtaF;
        this.numVtaF = numVtaF;
        changeSupport.firePropertyChange("numVtaF", oldNumVtaF, numVtaF);
    }

    public BigDecimal getPercencionVtaConF() {
        return percencionVtaConF;
    }

    public void setPercencionVtaConF(BigDecimal percencionVtaConF) {
        BigDecimal oldPercencionVtaConF = this.percencionVtaConF;
        this.percencionVtaConF = percencionVtaConF;
        changeSupport.firePropertyChange("percencionVtaConF", oldPercencionVtaConF, percencionVtaConF);
    }

    public BigDecimal getRetencionVtaConF() {
        return retencionVtaConF;
    }

    public void setRetencionVtaConF(BigDecimal retencionVtaConF) {
        BigDecimal oldRetencionVtaConF = this.retencionVtaConF;
        this.retencionVtaConF = retencionVtaConF;
        changeSupport.firePropertyChange("retencionVtaConF", oldRetencionVtaConF, retencionVtaConF);
    }

    public BigDecimal getTercerosVtaConF() {
        return tercerosVtaConF;
    }

    public void setTercerosVtaConF(BigDecimal tercerosVtaConF) {
        BigDecimal oldTercerosVtaConF = this.tercerosVtaConF;
        this.tercerosVtaConF = tercerosVtaConF;
        changeSupport.firePropertyChange("tercerosVtaConF", oldTercerosVtaConF, tercerosVtaConF);
    }

    public BigDecimal getTotalVtaConF() {
        return totalVtaConF;
    }

    public void setTotalVtaConF(BigDecimal totalVtaConF) {
        BigDecimal oldTotalVtaConF = this.totalVtaConF;
        this.totalVtaConF = totalVtaConF;
        changeSupport.firePropertyChange("totalVtaConF", oldTotalVtaConF, totalVtaConF);
    }

    public BigDecimal getVtaExenConF() {
        return vtaExenConF;
    }

    public void setVtaExenConF(BigDecimal vtaExenConF) {
        BigDecimal oldVtaExenConF = this.vtaExenConF;
        this.vtaExenConF = vtaExenConF;
        changeSupport.firePropertyChange("vtaExenConF", oldVtaExenConF, vtaExenConF);
    }

    public BigDecimal getVtaGravConF() {
        return vtaGravConF;
    }

    public void setVtaGravConF(BigDecimal vtaGravConF) {
        BigDecimal oldVtaGravConF = this.vtaGravConF;
        this.vtaGravConF = vtaGravConF;
        changeSupport.firePropertyChange("vtaGravConF", oldVtaGravConF, vtaGravConF);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaConF != null ? idVentaConF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaConsumidor)) {
            return false;
        }
        VentaConsumidor other = (VentaConsumidor) object;
        if ((this.idVentaConF == null && other.idVentaConF != null) || (this.idVentaConF != null && !this.idVentaConF.equals(other.idVentaConF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.VentaConsumidor[ idVentaConF=" + idVentaConF + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
