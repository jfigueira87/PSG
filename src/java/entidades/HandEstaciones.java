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
@Table(name = "hand_estaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandEstaciones.findAll", query = "SELECT h FROM HandEstaciones h"),
    @NamedQuery(name = "HandEstaciones.findByEstCc", query = "SELECT h FROM HandEstaciones h WHERE h.estCc = :estCc"),
    @NamedQuery(name = "HandEstaciones.findByEstDes", query = "SELECT h FROM HandEstaciones h WHERE h.estDes = :estDes")})
public class HandEstaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EST_CC")
    private Integer estCc;
    @Basic(optional = false)
    @Column(name = "EST_DES")
    private String estDes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionInicioId")
    private Collection<HandPlantaEstCuad> handPlantaEstCuadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionFinId")
    private Collection<HandPlantaEstCuad> handPlantaEstCuadCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionInicioId")
    private Collection<HandTiempos> handTiemposCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacionFinId")
    private Collection<HandTiempos> handTiemposCollection1;
    @JoinColumn(name = "CUADRANTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandCuadrante cuadranteId;
    @JoinColumn(name = "ZON_CC", referencedColumnName = "ZON_CC")
    @ManyToOne(optional = false)
    private HandZonas zonCc;

    public HandEstaciones() {
    }

    public HandEstaciones(Integer estCc) {
        this.estCc = estCc;
    }

    public HandEstaciones(Integer estCc, String estDes) {
        this.estCc = estCc;
        this.estDes = estDes;
    }

    public Integer getEstCc() {
        return estCc;
    }

    public void setEstCc(Integer estCc) {
        this.estCc = estCc;
    }

    public String getEstDes() {
        return estDes;
    }

    public void setEstDes(String estDes) {
        this.estDes = estDes;
    }

    @XmlTransient
    public Collection<HandPlantaEstCuad> getHandPlantaEstCuadCollection() {
        return handPlantaEstCuadCollection;
    }

    public void setHandPlantaEstCuadCollection(Collection<HandPlantaEstCuad> handPlantaEstCuadCollection) {
        this.handPlantaEstCuadCollection = handPlantaEstCuadCollection;
    }

    @XmlTransient
    public Collection<HandPlantaEstCuad> getHandPlantaEstCuadCollection1() {
        return handPlantaEstCuadCollection1;
    }

    public void setHandPlantaEstCuadCollection1(Collection<HandPlantaEstCuad> handPlantaEstCuadCollection1) {
        this.handPlantaEstCuadCollection1 = handPlantaEstCuadCollection1;
    }

    @XmlTransient
    public Collection<HandTiempos> getHandTiemposCollection() {
        return handTiemposCollection;
    }

    public void setHandTiemposCollection(Collection<HandTiempos> handTiemposCollection) {
        this.handTiemposCollection = handTiemposCollection;
    }

    @XmlTransient
    public Collection<HandTiempos> getHandTiemposCollection1() {
        return handTiemposCollection1;
    }

    public void setHandTiemposCollection1(Collection<HandTiempos> handTiemposCollection1) {
        this.handTiemposCollection1 = handTiemposCollection1;
    }

    public HandCuadrante getCuadranteId() {
        return cuadranteId;
    }

    public void setCuadranteId(HandCuadrante cuadranteId) {
        this.cuadranteId = cuadranteId;
    }

    public HandZonas getZonCc() {
        return zonCc;
    }

    public void setZonCc(HandZonas zonCc) {
        this.zonCc = zonCc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estCc != null ? estCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandEstaciones)) {
            return false;
        }
        HandEstaciones other = (HandEstaciones) object;
        if ((this.estCc == null && other.estCc != null) || (this.estCc != null && !this.estCc.equals(other.estCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandEstaciones[ estCc=" + estCc + " ]";
    }
    
}
