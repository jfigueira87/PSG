/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_distc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandDistc.findAll", query = "SELECT h FROM HandDistc h"),
    @NamedQuery(name = "HandDistc.findById", query = "SELECT h FROM HandDistc h WHERE h.id = :id"),
    @NamedQuery(name = "HandDistc.findByDistanciaMedia", query = "SELECT h FROM HandDistc h WHERE h.distanciaMedia = :distanciaMedia"),
    @NamedQuery(name = "HandDistc.findByTiempoMedio", query = "SELECT h FROM HandDistc h WHERE h.tiempoMedio = :tiempoMedio")})
public class HandDistc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DISTANCIA_MEDIA")
    private int distanciaMedia;
    @Basic(optional = false)
    @Column(name = "TIEMPO_MEDIO")
    private int tiempoMedio;
    @JoinColumn(name = "CUADRANTE_1_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandCuadrante cuadrante1Id;
    @JoinColumn(name = "CUADRANTE_2_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandCuadrante cuadrante2Id;

    public HandDistc() {
    }

    public HandDistc(Integer id) {
        this.id = id;
    }

    public HandDistc(Integer id, int distanciaMedia, int tiempoMedio) {
        this.id = id;
        this.distanciaMedia = distanciaMedia;
        this.tiempoMedio = tiempoMedio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDistanciaMedia() {
        return distanciaMedia;
    }

    public void setDistanciaMedia(int distanciaMedia) {
        this.distanciaMedia = distanciaMedia;
    }

    public int getTiempoMedio() {
        return tiempoMedio;
    }

    public void setTiempoMedio(int tiempoMedio) {
        this.tiempoMedio = tiempoMedio;
    }

    public HandCuadrante getCuadrante1Id() {
        return cuadrante1Id;
    }

    public void setCuadrante1Id(HandCuadrante cuadrante1Id) {
        this.cuadrante1Id = cuadrante1Id;
    }

    public HandCuadrante getCuadrante2Id() {
        return cuadrante2Id;
    }

    public void setCuadrante2Id(HandCuadrante cuadrante2Id) {
        this.cuadrante2Id = cuadrante2Id;
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
        if (!(object instanceof HandDistc)) {
            return false;
        }
        HandDistc other = (HandDistc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandDistc[ id=" + id + " ]";
    }
    
}
