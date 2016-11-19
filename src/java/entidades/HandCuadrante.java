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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hand_cuadrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandCuadrante.findAll", query = "SELECT h FROM HandCuadrante h"),
    @NamedQuery(name = "HandCuadrante.findById", query = "SELECT h FROM HandCuadrante h WHERE h.id = :id"),
    @NamedQuery(name = "HandCuadrante.findByNombre", query = "SELECT h FROM HandCuadrante h WHERE h.nombre = :nombre")})
public class HandCuadrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuadrante1Id")
    private Collection<HandDistc> handDistcCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuadrante2Id")
    private Collection<HandDistc> handDistcCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuadranteId")
    private Collection<HandEstaciones> handEstacionesCollection;

    public HandCuadrante() {
    }

    public HandCuadrante(Integer id) {
        this.id = id;
    }

    public HandCuadrante(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    @XmlTransient
    public Collection<HandDistc> getHandDistcCollection() {
        return handDistcCollection;
    }

    public void setHandDistcCollection(Collection<HandDistc> handDistcCollection) {
        this.handDistcCollection = handDistcCollection;
    }

    @XmlTransient
    public Collection<HandDistc> getHandDistcCollection1() {
        return handDistcCollection1;
    }

    public void setHandDistcCollection1(Collection<HandDistc> handDistcCollection1) {
        this.handDistcCollection1 = handDistcCollection1;
    }

    @XmlTransient
    public Collection<HandEstaciones> getHandEstacionesCollection() {
        return handEstacionesCollection;
    }

    public void setHandEstacionesCollection(Collection<HandEstaciones> handEstacionesCollection) {
        this.handEstacionesCollection = handEstacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandCuadrante)) {
            return false;
        }
        HandCuadrante other = (HandCuadrante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandCuadrante[ id=" + id + " ]";
    }
    
}
