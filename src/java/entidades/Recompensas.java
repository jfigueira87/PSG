/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "recompensas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recompensas.findAll", query = "SELECT r FROM Recompensas r"),
    @NamedQuery(name = "Recompensas.findByIdrecompensas", query = "SELECT r FROM Recompensas r WHERE r.idrecompensas = :idrecompensas"),
    @NamedQuery(name = "Recompensas.findByRecompensa", query = "SELECT r FROM Recompensas r WHERE r.recompensa = :recompensa"),
    @NamedQuery(name = "Recompensas.findByFechaInicio", query = "SELECT r FROM Recompensas r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Recompensas.findByFechaFin", query = "SELECT r FROM Recompensas r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "Recompensas.findByMedallas", query = "SELECT r FROM Recompensas r WHERE r.medallas = :medallas")})
public class Recompensas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecompensas")
    private Integer idrecompensas;
    @Column(name = "recompensa")
    private String recompensa;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "medallas")
    private String medallas;

    public Recompensas() {
    }

    public Recompensas(Integer idrecompensas) {
        this.idrecompensas = idrecompensas;
    }

    public Integer getIdrecompensas() {
        return idrecompensas;
    }

    public void setIdrecompensas(Integer idrecompensas) {
        this.idrecompensas = idrecompensas;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMedallas() {
        return medallas;
    }

    public void setMedallas(String medallas) {
        this.medallas = medallas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecompensas != null ? idrecompensas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recompensas)) {
            return false;
        }
        Recompensas other = (Recompensas) object;
        if ((this.idrecompensas == null && other.idrecompensas != null) || (this.idrecompensas != null && !this.idrecompensas.equals(other.idrecompensas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Recompensas[ idrecompensas=" + idrecompensas + " ]";
    }
    
}
