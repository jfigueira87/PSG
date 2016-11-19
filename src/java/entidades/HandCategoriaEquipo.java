/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_categoria_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandCategoriaEquipo.findAll", query = "SELECT h FROM HandCategoriaEquipo h"),
    @NamedQuery(name = "HandCategoriaEquipo.findByCodHandCategoriaEquipo", query = "SELECT h FROM HandCategoriaEquipo h WHERE h.codHandCategoriaEquipo = :codHandCategoriaEquipo"),
    @NamedQuery(name = "HandCategoriaEquipo.findByDescripcion", query = "SELECT h FROM HandCategoriaEquipo h WHERE h.descripcion = :descripcion")})
public class HandCategoriaEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_HAND_CATEGORIA_EQUIPO")
    private Integer codHandCategoriaEquipo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codHandCategoriaEquipo")
    private Collection<HandEquipos> handEquiposCollection;

    public HandCategoriaEquipo() {
    }

    public HandCategoriaEquipo(Integer codHandCategoriaEquipo) {
        this.codHandCategoriaEquipo = codHandCategoriaEquipo;
    }

    public HandCategoriaEquipo(Integer codHandCategoriaEquipo, String descripcion) {
        this.codHandCategoriaEquipo = codHandCategoriaEquipo;
        this.descripcion = descripcion;
    }

    public Integer getCodHandCategoriaEquipo() {
        return codHandCategoriaEquipo;
    }

    public void setCodHandCategoriaEquipo(Integer codHandCategoriaEquipo) {
        this.codHandCategoriaEquipo = codHandCategoriaEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<HandEquipos> getHandEquiposCollection() {
        return handEquiposCollection;
    }

    public void setHandEquiposCollection(Collection<HandEquipos> handEquiposCollection) {
        this.handEquiposCollection = handEquiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codHandCategoriaEquipo != null ? codHandCategoriaEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandCategoriaEquipo)) {
            return false;
        }
        HandCategoriaEquipo other = (HandCategoriaEquipo) object;
        if ((this.codHandCategoriaEquipo == null && other.codHandCategoriaEquipo != null) || (this.codHandCategoriaEquipo != null && !this.codHandCategoriaEquipo.equals(other.codHandCategoriaEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandCategoriaEquipo[ codHandCategoriaEquipo=" + codHandCategoriaEquipo + " ]";
    }
    
}
