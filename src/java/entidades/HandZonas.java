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
@Table(name = "hand_zonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandZonas.findAll", query = "SELECT h FROM HandZonas h"),
    @NamedQuery(name = "HandZonas.findByZonCc", query = "SELECT h FROM HandZonas h WHERE h.zonCc = :zonCc"),
    @NamedQuery(name = "HandZonas.findByZonDes", query = "SELECT h FROM HandZonas h WHERE h.zonDes = :zonDes")})
public class HandZonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ZON_CC")
    private Integer zonCc;
    @Basic(optional = false)
    @Column(name = "ZON_DES")
    private String zonDes;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonCc")
    private Collection<HandEstaciones> handEstacionesCollection;

    public HandZonas() {
    }

    public HandZonas(Integer zonCc) {
        this.zonCc = zonCc;
    }

    public HandZonas(Integer zonCc, String zonDes) {
        this.zonCc = zonCc;
        this.zonDes = zonDes;
    }

    public Integer getZonCc() {
        return zonCc;
    }

    public void setZonCc(Integer zonCc) {
        this.zonCc = zonCc;
    }

    public String getZonDes() {
        return zonDes;
    }

    public void setZonDes(String zonDes) {
        this.zonDes = zonDes;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
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
        hash += (zonCc != null ? zonCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandZonas)) {
            return false;
        }
        HandZonas other = (HandZonas) object;
        if ((this.zonCc == null && other.zonCc != null) || (this.zonCc != null && !this.zonCc.equals(other.zonCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandZonas[ zonCc=" + zonCc + " ]";
    }
    
}
