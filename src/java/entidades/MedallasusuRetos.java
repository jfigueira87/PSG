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
@Table(name = "medallasusu_retos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedallasusuRetos.findAll", query = "SELECT m FROM MedallasusuRetos m"),
    @NamedQuery(name = "MedallasusuRetos.findByIdmedallasUsuRetos", query = "SELECT m FROM MedallasusuRetos m WHERE m.idmedallasUsuRetos = :idmedallasUsuRetos"),
    @NamedQuery(name = "MedallasusuRetos.findByValorMin", query = "SELECT m FROM MedallasusuRetos m WHERE m.valorMin = :valorMin"),
    @NamedQuery(name = "MedallasusuRetos.findByValorMax", query = "SELECT m FROM MedallasusuRetos m WHERE m.valorMax = :valorMax")})
public class MedallasusuRetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedallasUsuRetos")
    private Integer idmedallasUsuRetos;
    @Column(name = "valor_min")
    private String valorMin;
    @Column(name = "valor_max")
    private String valorMax;
    @JoinColumn(name = "idmedallas", referencedColumnName = "idmedallas")
    @ManyToOne
    private MedallasUsuario idmedallas;

    public MedallasusuRetos() {
    }

    public MedallasusuRetos(Integer idmedallasUsuRetos) {
        this.idmedallasUsuRetos = idmedallasUsuRetos;
    }

    public Integer getIdmedallasUsuRetos() {
        return idmedallasUsuRetos;
    }

    public void setIdmedallasUsuRetos(Integer idmedallasUsuRetos) {
        this.idmedallasUsuRetos = idmedallasUsuRetos;
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

    public MedallasUsuario getIdmedallas() {
        return idmedallas;
    }

    public void setIdmedallas(MedallasUsuario idmedallas) {
        this.idmedallas = idmedallas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedallasUsuRetos != null ? idmedallasUsuRetos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedallasusuRetos)) {
            return false;
        }
        MedallasusuRetos other = (MedallasusuRetos) object;
        if ((this.idmedallasUsuRetos == null && other.idmedallasUsuRetos != null) || (this.idmedallasUsuRetos != null && !this.idmedallasUsuRetos.equals(other.idmedallasUsuRetos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MedallasusuRetos[ idmedallasUsuRetos=" + idmedallasUsuRetos + " ]";
    }
    
}
