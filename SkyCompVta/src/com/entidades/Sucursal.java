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
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByCodigoSucursal", query = "SELECT s FROM Sucursal s WHERE s.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "Sucursal.findByNombreSucursal", query = "SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_SUCURSAL")
    private String codigoSucursal;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoSucursal", fetch = FetchType.LAZY)
    private List<VentaContribuyente> ventaContribuyenteList;

    public Sucursal() {
    }

    public Sucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Sucursal(String codigoSucursal, String nombreSucursal) {
        this.codigoSucursal = codigoSucursal;
        this.nombreSucursal = nombreSucursal;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    @XmlTransient
    public List<VentaContribuyente> getVentaContribuyenteList() {
        return ventaContribuyenteList;
    }

    public void setVentaContribuyenteList(List<VentaContribuyente> ventaContribuyenteList) {
        this.ventaContribuyenteList = ventaContribuyenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSucursal != null ? codigoSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.codigoSucursal == null && other.codigoSucursal != null) || (this.codigoSucursal != null && !this.codigoSucursal.equals(other.codigoSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreSucursal;
    }
    
}
