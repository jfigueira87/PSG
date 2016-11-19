/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "nombre_retos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NombreRetos.findAll", query = "SELECT n FROM NombreRetos n"),
    @NamedQuery(name = "NombreRetos.findByIdactividades", query = "SELECT n FROM NombreRetos n WHERE n.idactividades = :idactividades"),
    @NamedQuery(name = "NombreRetos.findByNombreReto", query = "SELECT n FROM NombreRetos n WHERE n.nombreReto = :nombreReto")})
public class NombreRetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactividades")
    private Integer idactividades;
    @Column(name = "nombre_reto")
    private String nombreReto;

    public NombreRetos() {
    }

    public NombreRetos(Integer idactividades) {
        this.idactividades = idactividades;
    }

    public Integer getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(Integer idactividades) {
        this.idactividades = idactividades;
    }

    public String getNombreReto() {
        return nombreReto;
    }

    public void setNombreReto(String nombreReto) {
        this.nombreReto = nombreReto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactividades != null ? idactividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NombreRetos)) {
            return false;
        }
        NombreRetos other = (NombreRetos) object;
        if ((this.idactividades == null && other.idactividades != null) || (this.idactividades != null && !this.idactividades.equals(other.idactividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.NombreRetos[ idactividades=" + idactividades + " ]";
    }
    
}
