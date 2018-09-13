/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "TIPO_ORGANIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrganizacion.findAll", query = "SELECT t FROM TipoOrganizacion t"),
    @NamedQuery(name = "TipoOrganizacion.findByIdTipoOrg", query = "SELECT t FROM TipoOrganizacion t WHERE t.idTipoOrg = :idTipoOrg"),
    @NamedQuery(name = "TipoOrganizacion.findByDescripcionOrg", query = "SELECT t FROM TipoOrganizacion t WHERE t.descripcionOrg = :descripcionOrg")})
public class TipoOrganizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ORG")
    private Integer idTipoOrg;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_ORG")
    private String descripcionOrg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoOrg", fetch = FetchType.LAZY)
    private List<Organizacion> organizacionList;

    public TipoOrganizacion() {
    }

    public TipoOrganizacion(Integer idTipoOrg) {
        this.idTipoOrg = idTipoOrg;
    }

    public TipoOrganizacion(Integer idTipoOrg, String descripcionOrg) {
        this.idTipoOrg = idTipoOrg;
        this.descripcionOrg = descripcionOrg;
    }

    public Integer getIdTipoOrg() {
        return idTipoOrg;
    }

    public void setIdTipoOrg(Integer idTipoOrg) {
        this.idTipoOrg = idTipoOrg;
    }

    public String getDescripcionOrg() {
        return descripcionOrg;
    }

    public void setDescripcionOrg(String descripcionOrg) {
        this.descripcionOrg = descripcionOrg;
    }

    @XmlTransient
    public List<Organizacion> getOrganizacionList() {
        return organizacionList;
    }

    public void setOrganizacionList(List<Organizacion> organizacionList) {
        this.organizacionList = organizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOrg != null ? idTipoOrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOrganizacion)) {
            return false;
        }
        TipoOrganizacion other = (TipoOrganizacion) object;
        if ((this.idTipoOrg == null && other.idTipoOrg != null) || (this.idTipoOrg != null && !this.idTipoOrg.equals(other.idTipoOrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.TipoOrganizacion[ idTipoOrg=" + idTipoOrg + " ]";
    }
    
}
