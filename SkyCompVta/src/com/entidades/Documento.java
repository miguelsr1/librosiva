/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIdDoc", query = "SELECT d FROM Documento d WHERE d.idDoc = :idDoc"),
    @NamedQuery(name = "Documento.findByNombreDocumento", query = "SELECT d FROM Documento d WHERE d.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "Documento.findByVenta", query = "SELECT d FROM Documento d WHERE d.venta = :venta")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DOC")
    private Integer idDoc;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    @Basic(optional = false)
    @Column(name = "VENTA")
    private Boolean venta;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    private List<VentaContribuyente> ventaContribuyenteList;*/

    public Documento() {
    }

    public Documento(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Documento(Integer idDoc, String nombreDocumento, Boolean venta) {
        this.idDoc = idDoc;
        this.nombreDocumento = nombreDocumento;
        this.venta = venta;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public Boolean getVenta() {
        return venta;
    }

    public void setVenta(Boolean venta) {
        this.venta = venta;
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
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreDocumento;
    }
    
}
