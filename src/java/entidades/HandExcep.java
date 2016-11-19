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
@Table(name = "hand_excep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandExcep.findAll", query = "SELECT h FROM HandExcep h"),
    @NamedQuery(name = "HandExcep.findById", query = "SELECT h FROM HandExcep h WHERE h.id = :id"),
    @NamedQuery(name = "HandExcep.findByFechaExcepcion", query = "SELECT h FROM HandExcep h WHERE h.fechaExcepcion = :fechaExcepcion"),
    @NamedQuery(name = "HandExcep.findByTrabajado", query = "SELECT h FROM HandExcep h WHERE h.trabajado = :trabajado"),
    @NamedQuery(name = "HandExcep.findByHoraInicio", query = "SELECT h FROM HandExcep h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HandExcep.findByHoraFin", query = "SELECT h FROM HandExcep h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "HandExcep.findByHandExcepcol", query = "SELECT h FROM HandExcep h WHERE h.handExcepcol = :handExcepcol")})
public class HandExcep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FECHA_EXCEPCION")
    @Temporal(TemporalType.DATE)
    private Date fechaExcepcion;
    @Basic(optional = false)
    @Column(name = "TRABAJADO")
    private int trabajado;
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date horaInicio;
    @Column(name = "HORA_FIN")
    @Temporal(TemporalType.DATE)
    private Date horaFin;
    @Column(name = "hand_excepcol")
    private String handExcepcol;
    @JoinColumn(name = "EQUIPO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandEquipos equipoId;
    @JoinColumn(name = "MOTIVO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandMot motivoId;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @JoinColumn(name = "TURNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandTurnos turnoId;
    @JoinColumn(name = "OPERARIO", referencedColumnName = "USU_IDUSUARIO")
    @ManyToOne(optional = false)
    private TrUsuarios operario;

    public HandExcep() {
    }

    public HandExcep(Integer id) {
        this.id = id;
    }

    public HandExcep(Integer id, Date fechaExcepcion, int trabajado) {
        this.id = id;
        this.fechaExcepcion = fechaExcepcion;
        this.trabajado = trabajado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaExcepcion() {
        return fechaExcepcion;
    }

    public void setFechaExcepcion(Date fechaExcepcion) {
        this.fechaExcepcion = fechaExcepcion;
    }

    public int getTrabajado() {
        return trabajado;
    }

    public void setTrabajado(int trabajado) {
        this.trabajado = trabajado;
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

    public String getHandExcepcol() {
        return handExcepcol;
    }

    public void setHandExcepcol(String handExcepcol) {
        this.handExcepcol = handExcepcol;
    }

    public HandEquipos getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(HandEquipos equipoId) {
        this.equipoId = equipoId;
    }

    public HandMot getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(HandMot motivoId) {
        this.motivoId = motivoId;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    public HandTurnos getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(HandTurnos turnoId) {
        this.turnoId = turnoId;
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
        if (!(object instanceof HandExcep)) {
            return false;
        }
        HandExcep other = (HandExcep) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandExcep[ id=" + id + " ]";
    }
    
}
