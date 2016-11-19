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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "medallas_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedallasAlmacen.findAll", query = "SELECT m FROM MedallasAlmacen m"),
    @NamedQuery(name = "MedallasAlmacen.findByIdmedallas", query = "SELECT m FROM MedallasAlmacen m WHERE m.idmedallas = :idmedallas"),
    @NamedQuery(name = "MedallasAlmacen.findByAlmacen", query = "SELECT m FROM MedallasAlmacen m WHERE m.almacen = :almacen"),
    @NamedQuery(name = "MedallasAlmacen.findByNombre", query = "SELECT m FROM MedallasAlmacen m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MedallasAlmacen.findByFechaMin", query = "SELECT m FROM MedallasAlmacen m WHERE m.fechaMin = :fechaMin"),
    @NamedQuery(name = "MedallasAlmacen.findByFechaMax", query = "SELECT m FROM MedallasAlmacen m WHERE m.fechaMax = :fechaMax"),
    @NamedQuery(name = "MedallasAlmacen.findByPuntos", query = "SELECT m FROM MedallasAlmacen m WHERE m.puntos = :puntos"),
    @NamedQuery(name = "MedallasAlmacen.findByUrlLogo", query = "SELECT m FROM MedallasAlmacen m WHERE m.urlLogo = :urlLogo")})
public class MedallasAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedallas")
    private Integer idmedallas;
    @Column(name = "almacen")
    private String almacen;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_min")
    @Temporal(TemporalType.DATE)
    private Date fechaMin;
    @Column(name = "fecha_max")
    @Temporal(TemporalType.DATE)
    private Date fechaMax;
    @Column(name = "puntos")
    private String puntos;
    @Column(name = "url_logo")
    private String urlLogo;
    @OneToMany(mappedBy = "idmedallas")
    private Collection<MedallasplantRetos> medallasplantRetosCollection;

    public MedallasAlmacen() {
    }

    public MedallasAlmacen(Integer idmedallas) {
        this.idmedallas = idmedallas;
    }

    public Integer getIdmedallas() {
        return idmedallas;
    }

    public void setIdmedallas(Integer idmedallas) {
        this.idmedallas = idmedallas;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(Date fechaMin) {
        this.fechaMin = fechaMin;
    }

    public Date getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(Date fechaMax) {
        this.fechaMax = fechaMax;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    @XmlTransient
    public Collection<MedallasplantRetos> getMedallasplantRetosCollection() {
        return medallasplantRetosCollection;
    }

    public void setMedallasplantRetosCollection(Collection<MedallasplantRetos> medallasplantRetosCollection) {
        this.medallasplantRetosCollection = medallasplantRetosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedallas != null ? idmedallas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedallasAlmacen)) {
            return false;
        }
        MedallasAlmacen other = (MedallasAlmacen) object;
        if ((this.idmedallas == null && other.idmedallas != null) || (this.idmedallas != null && !this.idmedallas.equals(other.idmedallas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MedallasAlmacen[ idmedallas=" + idmedallas + " ]";
    }
    
}
