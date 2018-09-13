/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sanchez
 */
@Entity
@Table(name = "MODALIDAD", catalog = "SKY_LIBROS_IVA", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m"),
    @NamedQuery(name = "Modalidad.findByIdModalidad", query = "SELECT m FROM Modalidad m WHERE m.idModalidad = :idModalidad"),
    @NamedQuery(name = "Modalidad.findByDescripcionModalidad", query = "SELECT m FROM Modalidad m WHERE m.descripcionModalidad = :descripcionModalidad")})
public class Modalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MODALIDAD", nullable = false)
    private Integer idModalidad;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_MODALIDAD", nullable = false, length = 25)
    private String descripcionModalidad;
    @OneToMany(mappedBy = "idModalidad", fetch = FetchType.LAZY)
    private List<Compra> compraList;

    public Modalidad() {
    }

    public Modalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Modalidad(Integer idModalidad, String descripcionModalidad) {
        this.idModalidad = idModalidad;
        this.descripcionModalidad = descripcionModalidad;
    }

    public Integer getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getDescripcionModalidad() {
        return descripcionModalidad;
    }

    public void setDescripcionModalidad(String descripcionModalidad) {
        this.descripcionModalidad = descripcionModalidad;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidad != null ? idModalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.idModalidad == null && other.idModalidad != null) || (this.idModalidad != null && !this.idModalidad.equals(other.idModalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcionModalidad;
    }
    
}
