/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ORGANIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizacion.findAll", query = "SELECT o FROM Organizacion o"),
    @NamedQuery(name = "Organizacion.findByCodigoOrg", query = "SELECT o FROM Organizacion o WHERE o.codigoOrg = :codigoOrg"),
    @NamedQuery(name = "Organizacion.findByDireccionOrg", query = "SELECT o FROM Organizacion o WHERE o.direccionOrg = :direccionOrg"),
    @NamedQuery(name = "Organizacion.findByEliminado", query = "SELECT o FROM Organizacion o WHERE o.eliminado = :eliminado"),
    @NamedQuery(name = "Organizacion.findByFaxOrg", query = "SELECT o FROM Organizacion o WHERE o.faxOrg = :faxOrg"),
    @NamedQuery(name = "Organizacion.findByNitOrg", query = "SELECT o FROM Organizacion o WHERE o.nitOrg = :nitOrg"),
    @NamedQuery(name = "Organizacion.findByNombreOrg", query = "SELECT o FROM Organizacion o WHERE o.nombreOrg = :nombreOrg"),
    @NamedQuery(name = "Organizacion.findByRegIvaOrg", query = "SELECT o FROM Organizacion o WHERE o.regIvaOrg = :regIvaOrg"),
    @NamedQuery(name = "Organizacion.findByTelefonoOrg", query = "SELECT o FROM Organizacion o WHERE o.telefonoOrg = :telefonoOrg")})
public class Organizacion implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ORG")
    private String codigoOrg;
    @Column(name = "DIRECCION_ORG")
    private String direccionOrg;
    @Basic(optional = false)
    @Column(name = "ELIMINADO")
    private Boolean eliminado;
    @Column(name = "FAX_ORG")
    private String faxOrg;
    @Column(name = "NIT_ORG")
    private String nitOrg;
    @Column(name = "NOMBRE_ORG")
    private String nombreOrg;
    @Column(name = "REG_IVA_ORG")
    private String regIvaOrg;
    @Column(name = "TELEFONO_ORG")
    private String telefonoOrg;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "ID_TIPO_ORG", referencedColumnName = "ID_TIPO_ORG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoOrganizacion idTipoOrg;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOrg", fetch = FetchType.LAZY)
    private List<VentaContribuyente> ventaContribuyenteList;*/

    public Organizacion() {
    }

    public Organizacion(String codigoOrg) {
        this.codigoOrg = codigoOrg;
    }

    public Organizacion(String codigoOrg, Boolean eliminado) {
        this.codigoOrg = codigoOrg;
        this.eliminado = eliminado;
    }

    public String getCodigoOrg() {
        return codigoOrg;
    }

    public void setCodigoOrg(String codigoOrg) {
        this.codigoOrg = codigoOrg;
    }

    public String getDireccionOrg() {
        return direccionOrg;
    }

    public void setDireccionOrg(String direccionOrg) {
        this.direccionOrg = direccionOrg;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getFaxOrg() {
        return faxOrg;
    }

    public void setFaxOrg(String faxOrg) {
        this.faxOrg = faxOrg;
    }

    public String getNitOrg() {
        return nitOrg;
    }

    public void setNitOrg(String nitOrg) {
        this.nitOrg = nitOrg;
    }

    public String getNombreOrg() {
        return nombreOrg;
    }

    public void setNombreOrg(String nombreOrg) {
        this.nombreOrg = nombreOrg;
    }

    public String getRegIvaOrg() {
        return regIvaOrg;
    }

    public void setRegIvaOrg(String regIvaOrg) {
        this.regIvaOrg = regIvaOrg;
    }

    public String getTelefonoOrg() {
        return telefonoOrg;
    }

    public void setTelefonoOrg(String telefonoOrg) {
        String oldTelefono = this.telefonoOrg;
        this.telefonoOrg = telefonoOrg;
        changeSupport.firePropertyChange("telefonoOrg", oldTelefono, telefonoOrg);
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        Usuario oldUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldUsuario, idUsuario);
    }

    public TipoOrganizacion getIdTipoOrg() {
        return idTipoOrg;
    }

    public void setIdTipoOrg(TipoOrganizacion idTipoOrg) {
        TipoOrganizacion oldIdTipoOrg = this.idTipoOrg;
        this.idTipoOrg = idTipoOrg;
        changeSupport.firePropertyChange("idTipoOrg", oldIdTipoOrg, idTipoOrg);
    }

    /*@XmlTransient
    public List<VentaContribuyente> getVentaContribuyenteList() {
        return ventaContribuyenteList;
    }

    public void setVentaContribuyenteList(List<VentaContribuyente> ventaContribuyenteList) {
        this.ventaContribuyenteList = ventaContribuyenteList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOrg != null ? codigoOrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacion)) {
            return false;
        }
        Organizacion other = (Organizacion) object;
        if ((this.codigoOrg == null && other.codigoOrg != null) || (this.codigoOrg != null && !this.codigoOrg.equals(other.codigoOrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoOrg;
    }
    
}
