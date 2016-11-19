/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "hand_mot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandMot.findAll", query = "SELECT h FROM HandMot h"),
    @NamedQuery(name = "HandMot.findById", query = "SELECT h FROM HandMot h WHERE h.id = :id"),
    @NamedQuery(name = "HandMot.findByNombre", query = "SELECT h FROM HandMot h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HandMot.findByDescripcion", query = "SELECT h FROM HandMot h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HandMot.findByColorHexadecimal", query = "SELECT h FROM HandMot h WHERE h.colorHexadecimal = :colorHexadecimal"),
    @NamedQuery(name = "HandMot.findByMostrar", query = "SELECT h FROM HandMot h WHERE h.mostrar = :mostrar")})
public class HandMot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "COLOR_HEXADECIMAL")
    private String colorHexadecimal;
    @Basic(optional = false)
    @Column(name = "MOSTRAR")
    private int mostrar;
    @OneToMany(mappedBy = "motivoId")
    private Collection<HandHrealOper> handHrealOperCollection;
    @OneToMany(mappedBy = "motivoId")
    private Collection<HandExcep> handExcepCollection;

    public HandMot() {
    }

    public HandMot(Integer id) {
        this.id = id;
    }

    public HandMot(Integer id, String nombre, String descripcion, String colorHexadecimal, int mostrar) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.colorHexadecimal = colorHexadecimal;
        this.mostrar = mostrar;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColorHexadecimal() {
        return colorHexadecimal;
    }

    public void setColorHexadecimal(String colorHexadecimal) {
        this.colorHexadecimal = colorHexadecimal;
    }

    public int getMostrar() {
        return mostrar;
    }

    public void setMostrar(int mostrar) {
        this.mostrar = mostrar;
    }

    @XmlTransient
    public Collection<HandHrealOper> getHandHrealOperCollection() {
        return handHrealOperCollection;
    }

    public void setHandHrealOperCollection(Collection<HandHrealOper> handHrealOperCollection) {
        this.handHrealOperCollection = handHrealOperCollection;
    }

    @XmlTransient
    public Collection<HandExcep> getHandExcepCollection() {
        return handExcepCollection;
    }

    public void setHandExcepCollection(Collection<HandExcep> handExcepCollection) {
        this.handExcepCollection = handExcepCollection;
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
        if (!(object instanceof HandMot)) {
            return false;
        }
        HandMot other = (HandMot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandMot[ id=" + id + " ]";
    }
    
}
