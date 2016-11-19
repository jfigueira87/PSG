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
@Table(name = "hand_desvios_tiempos2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandDesviosTiempos2.findAll", query = "SELECT h FROM HandDesviosTiempos2 h"),
    @NamedQuery(name = "HandDesviosTiempos2.findByIdDesvios", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.idDesvios = :idDesvios"),
    @NamedQuery(name = "HandDesviosTiempos2.findByPltCc", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.pltCc = :pltCc"),
    @NamedQuery(name = "HandDesviosTiempos2.findByOperario", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.operario = :operario"),
    @NamedQuery(name = "HandDesviosTiempos2.findByEstacionInicioId", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.estacionInicioId = :estacionInicioId"),
    @NamedQuery(name = "HandDesviosTiempos2.findByEstacionFinId", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.estacionFinId = :estacionFinId"),
    @NamedQuery(name = "HandDesviosTiempos2.findByHoraInicio", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HandDesviosTiempos2.findByHoraFin", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "HandDesviosTiempos2.findByTiempoTotal", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.tiempoTotal = :tiempoTotal"),
    @NamedQuery(name = "HandDesviosTiempos2.findByTiempoMedio", query = "SELECT h FROM HandDesviosTiempos2 h WHERE h.tiempoMedio = :tiempoMedio")})
public class HandDesviosTiempos2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDesvios")
    private Integer idDesvios;
    @Basic(optional = false)
    @Column(name = "PLT_CC")
    private String pltCc;
    @Basic(optional = false)
    @Column(name = "OPERARIO")
    private String operario;
    @Basic(optional = false)
    @Column(name = "ESTACION_INICIO_ID")
    private int estacionInicioId;
    @Basic(optional = false)
    @Column(name = "ESTACION_FIN_ID")
    private int estacionFinId;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Basic(optional = false)
    @Column(name = "TIEMPO_TOTAL")
    private int tiempoTotal;
    @Basic(optional = false)
    @Column(name = "TIEMPO_MEDIO")
    private int tiempoMedio;

    public HandDesviosTiempos2() {
    }

    public HandDesviosTiempos2(Integer idDesvios) {
        this.idDesvios = idDesvios;
    }

    public HandDesviosTiempos2(Integer idDesvios, String pltCc, String operario, int estacionInicioId, int estacionFinId, Date horaInicio, Date horaFin, int tiempoTotal, int tiempoMedio) {
        this.idDesvios = idDesvios;
        this.pltCc = pltCc;
        this.operario = operario;
        this.estacionInicioId = estacionInicioId;
        this.estacionFinId = estacionFinId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tiempoTotal = tiempoTotal;
        this.tiempoMedio = tiempoMedio;
    }

    public Integer getIdDesvios() {
        return idDesvios;
    }

    public void setIdDesvios(Integer idDesvios) {
        this.idDesvios = idDesvios;
    }

    public String getPltCc() {
        return pltCc;
    }

    public void setPltCc(String pltCc) {
        this.pltCc = pltCc;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public int getEstacionInicioId() {
        return estacionInicioId;
    }

    public void setEstacionInicioId(int estacionInicioId) {
        this.estacionInicioId = estacionInicioId;
    }

    public int getEstacionFinId() {
        return estacionFinId;
    }

    public void setEstacionFinId(int estacionFinId) {
        this.estacionFinId = estacionFinId;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public int getTiempoMedio() {
        return tiempoMedio;
    }

    public void setTiempoMedio(int tiempoMedio) {
        this.tiempoMedio = tiempoMedio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesvios != null ? idDesvios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandDesviosTiempos2)) {
            return false;
        }
        HandDesviosTiempos2 other = (HandDesviosTiempos2) object;
        if ((this.idDesvios == null && other.idDesvios != null) || (this.idDesvios != null && !this.idDesvios.equals(other.idDesvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandDesviosTiempos2[ idDesvios=" + idDesvios + " ]";
    }
    
}
