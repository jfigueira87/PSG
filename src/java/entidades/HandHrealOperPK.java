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
public class HandHrealOperPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "HREAL_ID")
    private int hrealId;
    @Basic(optional = false)
    @Column(name = "OPERARIO")
    private String operario;

    public HandHrealOperPK() {
    }

    public HandHrealOperPK(int hrealId, String operario) {
        this.hrealId = hrealId;
        this.operario = operario;
    }

    public int getHrealId() {
        return hrealId;
    }

    public void setHrealId(int hrealId) {
        this.hrealId = hrealId;
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
        hash += (int) hrealId;
        hash += (operario != null ? operario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandHrealOperPK)) {
            return false;
        }
        HandHrealOperPK other = (HandHrealOperPK) object;
        if (this.hrealId != other.hrealId) {
            return false;
        }
        if ((this.operario == null && other.operario != null) || (this.operario != null && !this.operario.equals(other.operario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandHrealOperPK[ hrealId=" + hrealId + ", operario=" + operario + " ]";
    }
    
}
