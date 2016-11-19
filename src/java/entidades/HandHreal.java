/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_hreal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandHreal.findAll", query = "SELECT h FROM HandHreal h"),
    @NamedQuery(name = "HandHreal.findById", query = "SELECT h FROM HandHreal h WHERE h.id = :id"),
    @NamedQuery(name = "HandHreal.findByDiaCierre", query = "SELECT h FROM HandHreal h WHERE h.diaCierre = :diaCierre"),
    @NamedQuery(name = "HandHreal.findByCerrado", query = "SELECT h FROM HandHreal h WHERE h.cerrado = :cerrado"),
    @NamedQuery(name = "HandHreal.findByValidado", query = "SELECT h FROM HandHreal h WHERE h.validado = :validado")})
public class HandHreal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DIA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date diaCierre;
    @Basic(optional = false)
    @Column(name = "CERRADO")
    private int cerrado;
    @Basic(optional = false)
    @Column(name = "VALIDADO")
    private int validado;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handHreal")
    private Collection<HandHrealOper> handHrealOperCollection;

    public HandHreal() {
    }

    public HandHreal(Integer id) {
        this.id = id;
    }

    public HandHreal(Integer id, Date diaCierre, int cerrado, int validado) {
        this.id = id;
        this.diaCierre = diaCierre;
        this.cerrado = cerrado;
        this.validado = validado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiaCierre() {
        return diaCierre;
    }

    public void setDiaCierre(Date diaCierre) {
        this.diaCierre = diaCierre;
    }

    public int getCerrado() {
        return cerrado;
    }

    public void setCerrado(int cerrado) {
        this.cerrado = cerrado;
    }

    public int getValidado() {
        return validado;
    }

    public void setValidado(int validado) {
        this.validado = validado;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    @XmlTransient
    public Collection<HandHrealOper> getHandHrealOperCollection() {
        return handHrealOperCollection;
    }

    public void setHandHrealOperCollection(Collection<HandHrealOper> handHrealOperCollection) {
        this.handHrealOperCollection = handHrealOperCollection;
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
        if (!(object instanceof HandHreal)) {
            return false;
        }
        HandHreal other = (HandHreal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandHreal[ id=" + id + " ]";
    }
    
}
