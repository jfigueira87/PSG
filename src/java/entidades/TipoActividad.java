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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipo_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t"),
    @NamedQuery(name = "TipoActividad.findByIdtipoActividad", query = "SELECT t FROM TipoActividad t WHERE t.idtipoActividad = :idtipoActividad"),
    @NamedQuery(name = "TipoActividad.findByCantidadInicial", query = "SELECT t FROM TipoActividad t WHERE t.cantidadInicial = :cantidadInicial"),
    @NamedQuery(name = "TipoActividad.findByCantidadFinal", query = "SELECT t FROM TipoActividad t WHERE t.cantidadFinal = :cantidadFinal"),
    @NamedQuery(name = "TipoActividad.findByFechaInicial", query = "SELECT t FROM TipoActividad t WHERE t.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "TipoActividad.findByFechaFinal", query = "SELECT t FROM TipoActividad t WHERE t.fechaFinal = :fechaFinal")})
public class TipoActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_actividad")
    private Integer idtipoActividad;
    @Column(name = "cantidad_inicial")
    private Integer cantidadInicial;
    @Column(name = "cantidad_final")
    private Integer cantidadFinal;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @JoinColumn(name = "descripci\u00f3n", referencedColumnName = "nivel")
    @ManyToOne
    private NivelesActividad descripción;

    public TipoActividad() {
    }

    public TipoActividad(Integer idtipoActividad) {
        this.idtipoActividad = idtipoActividad;
    }

    public Integer getIdtipoActividad() {
        return idtipoActividad;
    }

    public void setIdtipoActividad(Integer idtipoActividad) {
        this.idtipoActividad = idtipoActividad;
    }

    public Integer getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(Integer cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Integer getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(Integer cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public NivelesActividad getDescripción() {
        return descripción;
    }

    public void setDescripción(NivelesActividad descripción) {
        this.descripción = descripción;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoActividad != null ? idtipoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.idtipoActividad == null && other.idtipoActividad != null) || (this.idtipoActividad != null && !this.idtipoActividad.equals(other.idtipoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoActividad[ idtipoActividad=" + idtipoActividad + " ]";
    }
    
}
