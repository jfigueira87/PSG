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
import javax.persistence.JoinColumns;
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
@Table(name = "hand_planif_hist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandPlanifHist.findAll", query = "SELECT h FROM HandPlanifHist h"),
    @NamedQuery(name = "HandPlanifHist.findById", query = "SELECT h FROM HandPlanifHist h WHERE h.id = :id"),
    @NamedQuery(name = "HandPlanifHist.findByPerteneceCentro", query = "SELECT h FROM HandPlanifHist h WHERE h.perteneceCentro = :perteneceCentro"),
    @NamedQuery(name = "HandPlanifHist.findByActivo", query = "SELECT h FROM HandPlanifHist h WHERE h.activo = :activo"),
    @NamedQuery(name = "HandPlanifHist.findByFechaIni", query = "SELECT h FROM HandPlanifHist h WHERE h.fechaIni = :fechaIni"),
    @NamedQuery(name = "HandPlanifHist.findByFechaFin", query = "SELECT h FROM HandPlanifHist h WHERE h.fechaFin = :fechaFin")})
public class HandPlanifHist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PERTENECE_CENTRO")
    private int perteneceCentro;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private int activo;
    @Basic(optional = false)
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @JoinColumn(name = "EQUIPO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandEquipos equipoId;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @JoinColumns({
        @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC"),
        @JoinColumn(name = "OPERARIO", referencedColumnName = "OPERARIO")})
    @ManyToOne(optional = false)
    private HandPlanif handPlanif;
    @JoinColumn(name = "TURNO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandTurnos turnoId;
    @JoinColumn(name = "OPERARIO", referencedColumnName = "USU_IDUSUARIO")
    @ManyToOne(optional = false)
    private TrUsuarios operario;

    public HandPlanifHist() {
    }

    public HandPlanifHist(Integer id) {
        this.id = id;
    }

    public HandPlanifHist(Integer id, int perteneceCentro, int activo, Date fechaIni, Date fechaFin) {
        this.id = id;
        this.perteneceCentro = perteneceCentro;
        this.activo = activo;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPerteneceCentro() {
        return perteneceCentro;
    }

    public void setPerteneceCentro(int perteneceCentro) {
        this.perteneceCentro = perteneceCentro;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public HandEquipos getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(HandEquipos equipoId) {
        this.equipoId = equipoId;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    public HandPlanif getHandPlanif() {
        return handPlanif;
    }

    public void setHandPlanif(HandPlanif handPlanif) {
        this.handPlanif = handPlanif;
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
        if (!(object instanceof HandPlanifHist)) {
            return false;
        }
        HandPlanifHist other = (HandPlanifHist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandPlanifHist[ id=" + id + " ]";
    }
    
}
