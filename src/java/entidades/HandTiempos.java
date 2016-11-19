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
@Table(name = "hand_tiempos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandTiempos.findAll", query = "SELECT h FROM HandTiempos h"),
    @NamedQuery(name = "HandTiempos.findById", query = "SELECT h FROM HandTiempos h WHERE h.id = :id"),
    @NamedQuery(name = "HandTiempos.findByHoraInicio", query = "SELECT h FROM HandTiempos h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HandTiempos.findByHoraFin", query = "SELECT h FROM HandTiempos h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "HandTiempos.findByTiempoTotal", query = "SELECT h FROM HandTiempos h WHERE h.tiempoTotal = :tiempoTotal")})
public class HandTiempos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
    @JoinColumn(name = "ESTACION_INICIO_ID", referencedColumnName = "EST_CC")
    @ManyToOne(optional = false)
    private HandEstaciones estacionInicioId;
    @JoinColumn(name = "ESTACION_FIN_ID", referencedColumnName = "EST_CC")
    @ManyToOne(optional = false)
    private HandEstaciones estacionFinId;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @JoinColumn(name = "TIPO_MOVIMIENTO", referencedColumnName = "ID_HAND_MOVIMIENTO")
    @ManyToOne
    private HandTipoMovimientos tipoMovimiento;
    @JoinColumn(name = "TIPO_TIEMPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandTipoTiempo tipoTiempo;
    @JoinColumn(name = "OPERARIO", referencedColumnName = "USU_IDUSUARIO")
    @ManyToOne(optional = false)
    private TrUsuarios operario;

    public HandTiempos() {
    }

    public HandTiempos(Integer id) {
        this.id = id;
    }

    public HandTiempos(Integer id, Date horaInicio, Date horaFin, int tiempoTotal) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tiempoTotal = tiempoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public HandEstaciones getEstacionInicioId() {
        return estacionInicioId;
    }

    public void setEstacionInicioId(HandEstaciones estacionInicioId) {
        this.estacionInicioId = estacionInicioId;
    }

    public HandEstaciones getEstacionFinId() {
        return estacionFinId;
    }

    public void setEstacionFinId(HandEstaciones estacionFinId) {
        this.estacionFinId = estacionFinId;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    public HandTipoMovimientos getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(HandTipoMovimientos tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public HandTipoTiempo getTipoTiempo() {
        return tipoTiempo;
    }

    public void setTipoTiempo(HandTipoTiempo tipoTiempo) {
        this.tipoTiempo = tipoTiempo;
    }

    public TrUsuarios getOperario() {
        return operario;
    }

    public void setOperario(TrUsuarios operario) {
        this.operario = operario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandTiempos)) {
            return false;
        }
        HandTiempos other = (HandTiempos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandTiempos[ id=" + id + " ]";
    }
    
}
