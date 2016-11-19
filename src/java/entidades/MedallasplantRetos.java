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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "medallasplant_retos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedallasplantRetos.findAll", query = "SELECT m FROM MedallasplantRetos m"),
    @NamedQuery(name = "MedallasplantRetos.findByIdmedallasPlantasRetos", query = "SELECT m FROM MedallasplantRetos m WHERE m.idmedallasPlantasRetos = :idmedallasPlantasRetos"),
    @NamedQuery(name = "MedallasplantRetos.findByValorMin", query = "SELECT m FROM MedallasplantRetos m WHERE m.valorMin = :valorMin"),
    @NamedQuery(name = "MedallasplantRetos.findByValorMax", query = "SELECT m FROM MedallasplantRetos m WHERE m.valorMax = :valorMax")})
public class MedallasplantRetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedallasPlantasRetos")
    private Integer idmedallasPlantasRetos;
    @Column(name = "valor_min")
    private String valorMin;
    @Column(name = "valor_max")
    private String valorMax;
    @JoinColumn(name = "idmedallas", referencedColumnName = "idmedallas")
    @ManyToOne
    private MedallasAlmacen idmedallas;

    public MedallasplantRetos() {
    }

    public MedallasplantRetos(Integer idmedallasPlantasRetos) {
        this.idmedallasPlantasRetos = idmedallasPlantasRetos;
    }

    public Integer getIdmedallasPlantasRetos() {
        return idmedallasPlantasRetos;
    }

    public void setIdmedallasPlantasRetos(Integer idmedallasPlantasRetos) {
        this.idmedallasPlantasRetos = idmedallasPlantasRetos;
    }

    public String getValorMin() {
        return valorMin;
    }

    public void setValorMin(String valorMin) {
        this.valorMin = valorMin;
    }

    public String getValorMax() {
        return valorMax;
    }

    public void setValorMax(String valorMax) {
        this.valorMax = valorMax;
    }

    public MedallasAlmacen getIdmedallas() {
        return idmedallas;
    }

    public void setIdmedallas(MedallasAlmacen idmedallas) {
        this.idmedallas = idmedallas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedallasPlantasRetos != null ? idmedallasPlantasRetos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedallasplantRetos)) {
            return false;
        }
        MedallasplantRetos other = (MedallasplantRetos) object;
        if ((this.idmedallasPlantasRetos == null && other.idmedallasPlantasRetos != null) || (this.idmedallasPlantasRetos != null && !this.idmedallasPlantasRetos.equals(other.idmedallasPlantasRetos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MedallasplantRetos[ idmedallasPlantasRetos=" + idmedallasPlantasRetos + " ]";
    }
    
}
