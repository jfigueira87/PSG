/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "hand_tipo_movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandTipoMovimientos.findAll", query = "SELECT h FROM HandTipoMovimientos h"),
    @NamedQuery(name = "HandTipoMovimientos.findByIdHandMovimiento", query = "SELECT h FROM HandTipoMovimientos h WHERE h.idHandMovimiento = :idHandMovimiento"),
    @NamedQuery(name = "HandTipoMovimientos.findByDescripcion", query = "SELECT h FROM HandTipoMovimientos h WHERE h.descripcion = :descripcion")})
public class HandTipoMovimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_HAND_MOVIMIENTO")
    private Integer idHandMovimiento;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipoMovimiento")
    private Collection<HandTiempos> handTiemposCollection;

    public HandTipoMovimientos() {
    }

    public HandTipoMovimientos(Integer idHandMovimiento) {
        this.idHandMovimiento = idHandMovimiento;
    }

    public HandTipoMovimientos(Integer idHandMovimiento, String descripcion) {
        this.idHandMovimiento = idHandMovimiento;
        this.descripcion = descripcion;
    }

    public Integer getIdHandMovimiento() {
        return idHandMovimiento;
    }

    public void setIdHandMovimiento(Integer idHandMovimiento) {
        this.idHandMovimiento = idHandMovimiento;
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
        hash += (idHandMovimiento != null ? idHandMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandTipoMovimientos)) {
            return false;
        }
        HandTipoMovimientos other = (HandTipoMovimientos) object;
        if ((this.idHandMovimiento == null && other.idHandMovimiento != null) || (this.idHandMovimiento != null && !this.idHandMovimiento.equals(other.idHandMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandTipoMovimientos[ idHandMovimiento=" + idHandMovimiento + " ]";
    }
    
}
