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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hand_planif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandPlanif.findAll", query = "SELECT h FROM HandPlanif h"),
    @NamedQuery(name = "HandPlanif.findByPltCc", query = "SELECT h FROM HandPlanif h WHERE h.handPlanifPK.pltCc = :pltCc"),
    @NamedQuery(name = "HandPlanif.findByOperario", query = "SELECT h FROM HandPlanif h WHERE h.handPlanifPK.operario = :operario"),
    @NamedQuery(name = "HandPlanif.findByPerteneceCentro", query = "SELECT h FROM HandPlanif h WHERE h.perteneceCentro = :perteneceCentro"),
    @NamedQuery(name = "HandPlanif.findByActivo", query = "SELECT h FROM HandPlanif h WHERE h.activo = :activo"),
    @NamedQuery(name = "HandPlanif.findByNuevoEquipoId", query = "SELECT h FROM HandPlanif h WHERE h.nuevoEquipoId = :nuevoEquipoId"),
    @NamedQuery(name = "HandPlanif.findByNuevoTurnoId", query = "SELECT h FROM HandPlanif h WHERE h.nuevoTurnoId = :nuevoTurnoId"),
    @NamedQuery(name = "HandPlanif.findByFechaAplicacionCambio", query = "SELECT h FROM HandPlanif h WHERE h.fechaAplicacionCambio = :fechaAplicacionCambio"),
    @NamedQuery(name = "HandPlanif.findByFechaAlta", query = "SELECT h FROM HandPlanif h WHERE h.fechaAlta = :fechaAlta")})
public class HandPlanif implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HandPlanifPK handPlanifPK;
    @Basic(optional = false)
    @Column(name = "PERTENECE_CENTRO")
    private int perteneceCentro;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private int activo;
    @Column(name = "NUEVO_EQUIPO_ID")
    private Integer nuevoEquipoId;
    @Column(name = "NUEVO_TURNO_ID")
    private Integer nuevoTurnoId;
    @Basic(optional = false)
    @Column(name = "FECHA_APLICACION_CAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAplicacionCambio;
    @Basic(optional = false)
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handPlanif")
    private Collection<HandPlanifHist> handPlanifHistCollection;
    @JoinColumn(name = "EQUIPO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandEquipos equipoId;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HandPlantas handPlantas;
    @JoinColumn(name = "TURNO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HandTurnos turnoId;
    @JoinColumn(name = "OPERARIO", referencedColumnName = "USU_IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrUsuarios trUsuarios;

    public HandPlanif() {
    }

    public HandPlanif(HandPlanifPK handPlanifPK) {
        this.handPlanifPK = handPlanifPK;
    }

    public HandPlanif(HandPlanifPK handPlanifPK, int perteneceCentro, int activo, Date fechaAplicacionCambio, Date fechaAlta) {
        this.handPlanifPK = handPlanifPK;
        this.perteneceCentro = perteneceCentro;
        this.activo = activo;
        this.fechaAplicacionCambio = fechaAplicacionCambio;
        this.fechaAlta = fechaAlta;
    }

    public HandPlanif(String pltCc, String operario) {
        this.handPlanifPK = new HandPlanifPK(pltCc, operario);
    }

    public HandPlanifPK getHandPlanifPK() {
        return handPlanifPK;
    }

    public void setHandPlanifPK(HandPlanifPK handPlanifPK) {
        this.handPlanifPK = handPlanifPK;
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

    public Integer getNuevoEquipoId() {
        return nuevoEquipoId;
    }

    public void setNuevoEquipoId(Integer nuevoEquipoId) {
        this.nuevoEquipoId = nuevoEquipoId;
    }

    public Integer getNuevoTurnoId() {
        return nuevoTurnoId;
    }

    public void setNuevoTurnoId(Integer nuevoTurnoId) {
        this.nuevoTurnoId = nuevoTurnoId;
    }

    public Date getFechaAplicacionCambio() {
        return fechaAplicacionCambio;
    }

    public void setFechaAplicacionCambio(Date fechaAplicacionCambio) {
        this.fechaAplicacionCambio = fechaAplicacionCambio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @XmlTransient
    public Collection<HandPlanifHist> getHandPlanifHistCollection() {
        return handPlanifHistCollection;
    }

    public void setHandPlanifHistCollection(Collection<HandPlanifHist> handPlanifHistCollection) {
        this.handPlanifHistCollection = handPlanifHistCollection;
    }

    public HandEquipos getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(HandEquipos equipoId) {
        this.equipoId = equipoId;
    }

    public HandPlantas getHandPlantas() {
        return handPlantas;
    }

    public void setHandPlantas(HandPlantas handPlantas) {
        this.handPlantas = handPlantas;
    }

    public HandTurnos getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(HandTurnos turnoId) {
        this.turnoId = turnoId;
    }

    public TrUsuarios getTrUsuarios() {
        return trUsuarios;
    }

    public void setTrUsuarios(TrUsuarios trUsuarios) {
        this.trUsuarios = trUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (handPlanifPK != null ? handPlanifPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandPlanif)) {
            return false;
        }
        HandPlanif other = (HandPlanif) object;
        if ((this.handPlanifPK == null && other.handPlanifPK != null) || (this.handPlanifPK != null && !this.handPlanifPK.equals(other.handPlanifPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandPlanif[ handPlanifPK=" + handPlanifPK + " ]";
    }
    
}
