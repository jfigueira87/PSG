/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jonnatha
 */
@Embeddable
public class HandPlanifPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PLT_CC")
    private String pltCc;
    @Basic(optional = false)
    @Column(name = "OPERARIO")
    private String operario;

    public HandPlanifPK() {
    }

    public HandPlanifPK(String pltCc, String operario) {
        this.pltCc = pltCc;
        this.operario = operario;
    }

    public String getPltCc() {
        return pltCc;
    }

    public void setPltCc(String pltCc) {
        this.pltCc = pltCc;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pltCc != null ? pltCc.hashCode() : 0);
        hash += (operario != null ? operario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandPlanifPK)) {
            return false;
        }
        HandPlanifPK other = (HandPlanifPK) object;
        if ((this.pltCc == null && other.pltCc != null) || (this.pltCc != null && !this.pltCc.equals(other.pltCc))) {
            return false;
        }
        if ((this.operario == null && other.operario != null) || (this.operario != null && !this.operario.equals(other.operario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandPlanifPK[ pltCc=" + pltCc + ", operario=" + operario + " ]";
    }
    
}
