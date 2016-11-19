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
@Table(name = "niveles_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelesActividad.findAll", query = "SELECT n FROM NivelesActividad n"),
    @NamedQuery(name = "NivelesActividad.findByNivel", query = "SELECT n FROM NivelesActividad n WHERE n.nivel = :nivel")})
public class NivelesActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @OneToMany(mappedBy = "descripci\u00f3n")
    private Collection<TipoActividad> tipoActividadCollection;

    public NivelesActividad() {
    }

    public NivelesActividad(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public Collection<TipoActividad> getTipoActividadCollection() {
        return tipoActividadCollection;
    }

    public void setTipoActividadCollection(Collection<TipoActividad> tipoActividadCollection) {
        this.tipoActividadCollection = tipoActividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivel != null ? nivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelesActividad)) {
            return false;
        }
        NivelesActividad other = (NivelesActividad) object;
        if ((this.nivel == null && other.nivel != null) || (this.nivel != null && !this.nivel.equals(other.nivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.NivelesActividad[ nivel=" + nivel + " ]";
    }
    
}
