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
@Table(name = "hand_equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandEquipos.findAll", query = "SELECT h FROM HandEquipos h"),
    @NamedQuery(name = "HandEquipos.findById", query = "SELECT h FROM HandEquipos h WHERE h.id = :id"),
    @NamedQuery(name = "HandEquipos.findByNombre", query = "SELECT h FROM HandEquipos h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HandEquipos.findByDescripcion", query = "SELECT h FROM HandEquipos h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HandEquipos.findByMostrar", query = "SELECT h FROM HandEquipos h WHERE h.mostrar = :mostrar"),
    @NamedQuery(name = "HandEquipos.findByBorrado", query = "SELECT h FROM HandEquipos h WHERE h.borrado = :borrado")})
public class HandEquipos implements Serializable {

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
    @Column(name = "MOSTRAR")
    private int mostrar;
    @Basic(optional = false)
    @Column(name = "BORRADO")
    private int borrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoId")
    private Collection<HandPlanifHist> handPlanifHistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoId")
    private Collection<HandPlanif> handPlanifCollection;
    @OneToMany(mappedBy = "equipoId")
    private Collection<HandHrealOper> handHrealOperCollection;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @JoinColumn(name = "COD_HAND_CATEGORIA_EQUIPO", referencedColumnName = "COD_HAND_CATEGORIA_EQUIPO")
    @ManyToOne(optional = false)
    private HandCategoriaEquipo codHandCategoriaEquipo;
    @OneToMany(mappedBy = "equipoId")
    private Collection<HandExcep> handExcepCollection;

    public HandEquipos() {
    }

    public HandEquipos(Integer id) {
        this.id = id;
    }

    public HandEquipos(Integer id, String nombre, String descripcion, int mostrar, int borrado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mostrar = mostrar;
        this.borrado = borrado;
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

    public int getMostrar() {
        return mostrar;
    }

    public void setMostrar(int mostrar) {
        this.mostrar = mostrar;
    }

    public int getBorrado() {
        return borrado;
    }

    public void setBorrado(int borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<HandPlanifHist> getHandPlanifHistCollection() {
        return handPlanifHistCollection;
    }

    public void setHandPlanifHistCollection(Collection<HandPlanifHist> handPlanifHistCollection) {
        this.handPlanifHistCollection = handPlanifHistCollection;
    }

    @XmlTransient
    public Collection<HandPlanif> getHandPlanifCollection() {
        return handPlanifCollection;
    }

    public void setHandPlanifCollection(Collection<HandPlanif> handPlanifCollection) {
        this.handPlanifCollection = handPlanifCollection;
    }

    @XmlTransient
    public Collection<HandHrealOper> getHandHrealOperCollection() {
        return handHrealOperCollection;
    }

    public void setHandHrealOperCollection(Collection<HandHrealOper> handHrealOperCollection) {
        this.handHrealOperCollection = handHrealOperCollection;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    public HandCategoriaEquipo getCodHandCategoriaEquipo() {
        return codHandCategoriaEquipo;
    }

    public void setCodHandCategoriaEquipo(HandCategoriaEquipo codHandCategoriaEquipo) {
        this.codHandCategoriaEquipo = codHandCategoriaEquipo;
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
        if (!(object instanceof HandEquipos)) {
            return false;
        }
        HandEquipos other = (HandEquipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandEquipos[ id=" + id + " ]";
    }
    
}
