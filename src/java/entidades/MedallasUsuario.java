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
@Table(name = "medallas_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedallasUsuario.findAll", query = "SELECT m FROM MedallasUsuario m"),
    @NamedQuery(name = "MedallasUsuario.findByIdmedallas", query = "SELECT m FROM MedallasUsuario m WHERE m.idmedallas = :idmedallas"),
    @NamedQuery(name = "MedallasUsuario.findByNombre", query = "SELECT m FROM MedallasUsuario m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MedallasUsuario.findByFechaMin", query = "SELECT m FROM MedallasUsuario m WHERE m.fechaMin = :fechaMin"),
    @NamedQuery(name = "MedallasUsuario.findByFechaMax", query = "SELECT m FROM MedallasUsuario m WHERE m.fechaMax = :fechaMax"),
    @NamedQuery(name = "MedallasUsuario.findByPuntos", query = "SELECT m FROM MedallasUsuario m WHERE m.puntos = :puntos"),
    @NamedQuery(name = "MedallasUsuario.findByUrlLogo", query = "SELECT m FROM MedallasUsuario m WHERE m.urlLogo = :urlLogo"),
    @NamedQuery(name = "MedallasUsuario.findByCentro", query = "SELECT m FROM MedallasUsuario m WHERE m.centro = :centro")})
public class MedallasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedallas")
    private Integer idmedallas;
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
    @Column(name = "centro")
    private String centro;
    @OneToMany(mappedBy = "idmedallas")
    private Collection<MedallasusuRetos> medallasusuRetosCollection;

    public MedallasUsuario() {
    }

    public MedallasUsuario(Integer idmedallas) {
        this.idmedallas = idmedallas;
    }

    public Integer getIdmedallas() {
        return idmedallas;
    }

    public void setIdmedallas(Integer idmedallas) {
        this.idmedallas = idmedallas;
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

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    @XmlTransient
    public Collection<MedallasusuRetos> getMedallasusuRetosCollection() {
        return medallasusuRetosCollection;
    }

    public void setMedallasusuRetosCollection(Collection<MedallasusuRetos> medallasusuRetosCollection) {
        this.medallasusuRetosCollection = medallasusuRetosCollection;
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
        if (!(object instanceof MedallasUsuario)) {
            return false;
        }
        MedallasUsuario other = (MedallasUsuario) object;
        if ((this.idmedallas == null && other.idmedallas != null) || (this.idmedallas != null && !this.idmedallas.equals(other.idmedallas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MedallasUsuario[ idmedallas=" + idmedallas + " ]";
    }
    
}
