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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "hand_tipo_tiempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandTipoTiempo.findAll", query = "SELECT h FROM HandTipoTiempo h"),
    @NamedQuery(name = "HandTipoTiempo.findById", query = "SELECT h FROM HandTipoTiempo h WHERE h.id = :id"),
    @NamedQuery(name = "HandTipoTiempo.findByDescripcion", query = "SELECT h FROM HandTipoTiempo h WHERE h.descripcion = :descripcion")})
public class HandTipoTiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTiempo")
    private Collection<HandTiempos> handTiemposCollection;

    public HandTipoTiempo() {
    }

    public HandTipoTiempo(String id) {
        this.id = id;
    }

    public HandTipoTiempo(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<HandTiempos> getHandTiemposCollection() {
        return handTiemposCollection;
    }

    public void setHandTiemposCollection(Collection<HandTiempos> handTiemposCollection) {
        this.handTiemposCollection = handTiemposCollection;
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
        if (!(object instanceof HandTipoTiempo)) {
            return false;
        }
        HandTipoTiempo other = (HandTipoTiempo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandTipoTiempo[ id=" + id + " ]";
    }
    
}
