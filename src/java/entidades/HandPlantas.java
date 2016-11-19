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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_plantas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandPlantas.findAll", query = "SELECT h FROM HandPlantas h"),
    @NamedQuery(name = "HandPlantas.findByPltCc", query = "SELECT h FROM HandPlantas h WHERE h.pltCc = :pltCc"),
    @NamedQuery(name = "HandPlantas.findByPltDes", query = "SELECT h FROM HandPlantas h WHERE h.pltDes = :pltDes"),
    @NamedQuery(name = "HandPlantas.findByUrllogoPlanta", query = "SELECT h FROM HandPlantas h WHERE h.urllogoPlanta = :urllogoPlanta")})
public class HandPlantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PLT_CC")
    private String pltCc;
    @Basic(optional = false)
    @Column(name = "PLT_DES")
    private String pltDes;
    @Column(name = "url_logoPlanta")
    private String urllogoPlanta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandPlanifHist> handPlanifHistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandZonas> handZonasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandHreal> handHrealCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandTurnos> handTurnosCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "handPlantas")
    private HandPlantaEstCuad handPlantaEstCuad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handPlantas")
    private Collection<HandPlanif> handPlanifCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandTiempos> handTiemposCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandCuadrante> handCuadranteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandEquipos> handEquiposCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pltCc")
    private Collection<HandExcep> handExcepCollection;

    public HandPlantas() {
    }

    public HandPlantas(String pltCc) {
        this.pltCc = pltCc;
    }

    public HandPlantas(String pltCc, String pltDes) {
        this.pltCc = pltCc;
        this.pltDes = pltDes;
    }

    public String getPltCc() {
        return pltCc;
    }

    public void setPltCc(String pltCc) {
        this.pltCc = pltCc;
    }

    public String getPltDes() {
        return pltDes;
    }

    public void setPltDes(String pltDes) {
        this.pltDes = pltDes;
    }

    public String getUrllogoPlanta() {
        return urllogoPlanta;
    }

    public void setUrllogoPlanta(String urllogoPlanta) {
        this.urllogoPlanta = urllogoPlanta;
    }

    @XmlTransient
    public Collection<HandPlanifHist> getHandPlanifHistCollection() {
        return handPlanifHistCollection;
    }

    public void setHandPlanifHistCollection(Collection<HandPlanifHist> handPlanifHistCollection) {
        this.handPlanifHistCollection = handPlanifHistCollection;
    }

    @XmlTransient
    public Collection<HandZonas> getHandZonasCollection() {
        return handZonasCollection;
    }

    public void setHandZonasCollection(Collection<HandZonas> handZonasCollection) {
        this.handZonasCollection = handZonasCollection;
    }

    @XmlTransient
    public Collection<HandHreal> getHandHrealCollection() {
        return handHrealCollection;
    }

    public void setHandHrealCollection(Collection<HandHreal> handHrealCollection) {
        this.handHrealCollection = handHrealCollection;
    }

    @XmlTransient
    public Collection<HandTurnos> getHandTurnosCollection() {
        return handTurnosCollection;
    }

    public void setHandTurnosCollection(Collection<HandTurnos> handTurnosCollection) {
        this.handTurnosCollection = handTurnosCollection;
    }

    public HandPlantaEstCuad getHandPlantaEstCuad() {
        return handPlantaEstCuad;
    }

    public void setHandPlantaEstCuad(HandPlantaEstCuad handPlantaEstCuad) {
        this.handPlantaEstCuad = handPlantaEstCuad;
    }

    @XmlTransient
    public Collection<HandPlanif> getHandPlanifCollection() {
        return handPlanifCollection;
    }

    public void setHandPlanifCollection(Collection<HandPlanif> handPlanifCollection) {
        this.handPlanifCollection = handPlanifCollection;
    }

    @XmlTransient
    public Collection<HandTiempos> getHandTiemposCollection() {
        return handTiemposCollection;
    }

    public void setHandTiemposCollection(Collection<HandTiempos> handTiemposCollection) {
        this.handTiemposCollection = handTiemposCollection;
    }

    @XmlTransient
    public Collection<HandCuadrante> getHandCuadranteCollection() {
        return handCuadranteCollection;
    }

    public void setHandCuadranteCollection(Collection<HandCuadrante> handCuadranteCollection) {
        this.handCuadranteCollection = handCuadranteCollection;
    }

    @XmlTransient
    public Collection<HandEquipos> getHandEquiposCollection() {
        return handEquiposCollection;
    }

    public void setHandEquiposCollection(Collection<HandEquipos> handEquiposCollection) {
        this.handEquiposCollection = handEquiposCollection;
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
        hash += (pltCc != null ? pltCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandPlantas)) {
            return false;
        }
        HandPlantas other = (HandPlantas) object;
        if ((this.pltCc == null && other.pltCc != null) || (this.pltCc != null && !this.pltCc.equals(other.pltCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandPlantas[ pltCc=" + pltCc + " ]";
    }
    
}
