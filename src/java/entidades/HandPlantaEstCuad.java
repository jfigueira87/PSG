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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_planta_est_cuad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandPlantaEstCuad.findAll", query = "SELECT h FROM HandPlantaEstCuad h"),
    @NamedQuery(name = "HandPlantaEstCuad.findByPltCc", query = "SELECT h FROM HandPlantaEstCuad h WHERE h.pltCc = :pltCc")})
public class HandPlantaEstCuad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PLT_CC")
    private String pltCc;
    @JoinColumn(name = "ESTACION_INICIO_ID", referencedColumnName = "EST_CC")
    @ManyToOne(optional = false)
    private HandEstaciones estacionInicioId;
    @JoinColumn(name = "ESTACION_FIN_ID", referencedColumnName = "EST_CC")
    @ManyToOne(optional = false)
    private HandEstaciones estacionFinId;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private HandPlantas handPlantas;

    public HandPlantaEstCuad() {
    }

    public HandPlantaEstCuad(String pltCc) {
        this.pltCc = pltCc;
    }

    public String getPltCc() {
        return pltCc;
    }

    public void setPltCc(String pltCc) {
        this.pltCc = pltCc;
    }

    public HandEstaciones getEstacionInicioId() {
        return estacionInicioId;
    }

    public void setEstacionInicioId(HandEstaciones estacionInicioId) {
        this.estacionInicioId = estacionInicioId;
    }

    public HandEstaciones getEstacionFinId() {
        return estacionFinId;
    }

    public void setEstacionFinId(HandEstaciones estacionFinId) {
        this.estacionFinId = estacionFinId;
    }

    public HandPlantas getHandPlantas() {
        return handPlantas;
    }

    public void setHandPlantas(HandPlantas handPlantas) {
        this.handPlantas = handPlantas;
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
        if (!(object instanceof HandPlantaEstCuad)) {
            return false;
        }
        HandPlantaEstCuad other = (HandPlantaEstCuad) object;
        if ((this.pltCc == null && other.pltCc != null) || (this.pltCc != null && !this.pltCc.equals(other.pltCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandPlantaEstCuad[ pltCc=" + pltCc + " ]";
    }
    
}
