/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "hand_hreal_oper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandHrealOper.findAll", query = "SELECT h FROM HandHrealOper h"),
    @NamedQuery(name = "HandHrealOper.findByHrealId", query = "SELECT h FROM HandHrealOper h WHERE h.handHrealOperPK.hrealId = :hrealId"),
    @NamedQuery(name = "HandHrealOper.findByOperario", query = "SELECT h FROM HandHrealOper h WHERE h.handHrealOperPK.operario = :operario"),
    @NamedQuery(name = "HandHrealOper.findByTrabajado", query = "SELECT h FROM HandHrealOper h WHERE h.trabajado = :trabajado"),
    @NamedQuery(name = "HandHrealOper.findByHoraInicio", query = "SELECT h FROM HandHrealOper h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HandHrealOper.findByHoraFinal", query = "SELECT h FROM HandHrealOper h WHERE h.horaFinal = :horaFinal"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotales", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotales = :horasTotales"),
    @NamedQuery(name = "HandHrealOper.findByHoraInicioPausa1", query = "SELECT h FROM HandHrealOper h WHERE h.horaInicioPausa1 = :horaInicioPausa1"),
    @NamedQuery(name = "HandHrealOper.findByHoraFinPausa1", query = "SELECT h FROM HandHrealOper h WHERE h.horaFinPausa1 = :horaFinPausa1"),
    @NamedQuery(name = "HandHrealOper.findByHoraInicioPausa2", query = "SELECT h FROM HandHrealOper h WHERE h.horaInicioPausa2 = :horaInicioPausa2"),
    @NamedQuery(name = "HandHrealOper.findByHoraFinPausa2", query = "SELECT h FROM HandHrealOper h WHERE h.horaFinPausa2 = :horaFinPausa2"),
    @NamedQuery(name = "HandHrealOper.findByHorasExtraCliente", query = "SELECT h FROM HandHrealOper h WHERE h.horasExtraCliente = :horasExtraCliente"),
    @NamedQuery(name = "HandHrealOper.findByHorasExtraKn", query = "SELECT h FROM HandHrealOper h WHERE h.horasExtraKn = :horasExtraKn"),
    @NamedQuery(name = "HandHrealOper.findByComentarios", query = "SELECT h FROM HandHrealOper h WHERE h.comentarios = :comentarios"),
    @NamedQuery(name = "HandHrealOper.findByHoraIniMov", query = "SELECT h FROM HandHrealOper h WHERE h.horaIniMov = :horaIniMov"),
    @NamedQuery(name = "HandHrealOper.findByHoraFinMov", query = "SELECT h FROM HandHrealOper h WHERE h.horaFinMov = :horaFinMov"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalA", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalA = :horasTotalA"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalB", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalB = :horasTotalB"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalB1", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalB1 = :horasTotalB1"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalB2", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalB2 = :horasTotalB2"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalB3", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalB3 = :horasTotalB3"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC = :horasTotalC"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC1", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC1 = :horasTotalC1"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC2", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC2 = :horasTotalC2"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC3", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC3 = :horasTotalC3"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC4", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC4 = :horasTotalC4"),
    @NamedQuery(name = "HandHrealOper.findByHorasTotalC5", query = "SELECT h FROM HandHrealOper h WHERE h.horasTotalC5 = :horasTotalC5")})
public class HandHrealOper implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HandHrealOperPK handHrealOperPK;
    @Basic(optional = false)
    @Column(name = "TRABAJADO")
    private String trabajado;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "HORA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "HORAS_TOTALES")
    private BigDecimal horasTotales;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa1;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa1;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa2;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa2;
    @Basic(optional = false)
    @Column(name = "HORAS_EXTRA_CLIENTE")
    private BigDecimal horasExtraCliente;
    @Basic(optional = false)
    @Column(name = "HORAS_EXTRA_KN")
    private BigDecimal horasExtraKn;
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @Basic(optional = false)
    @Column(name = "HORA_INI_MOV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaIniMov;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_MOV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinMov;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_A")
    private int horasTotalA;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_B")
    private int horasTotalB;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_B1")
    private int horasTotalB1;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_B2")
    private int horasTotalB2;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_B3")
    private int horasTotalB3;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C")
    private int horasTotalC;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C1")
    private int horasTotalC1;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C2")
    private int horasTotalC2;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C3")
    private int horasTotalC3;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C4")
    private int horasTotalC4;
    @Basic(optional = false)
    @Column(name = "HORAS_TOTAL_C5")
    private int horasTotalC5;
    @JoinColumn(name = "EQUIPO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandEquipos equipoId;
    @JoinColumn(name = "MOTIVO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandMot motivoId;
    @JoinColumn(name = "TURNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private HandTurnos turnoId;
    @JoinColumn(name = "HREAL_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HandHreal handHreal;
    @JoinColumn(name = "OPERARIO", referencedColumnName = "USU_IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrUsuarios trUsuarios;

    public HandHrealOper() {
    }

    public HandHrealOper(HandHrealOperPK handHrealOperPK) {
        this.handHrealOperPK = handHrealOperPK;
    }

    public HandHrealOper(HandHrealOperPK handHrealOperPK, String trabajado, Date horaInicio, Date horaFinal, BigDecimal horasTotales, Date horaInicioPausa1, Date horaFinPausa1, Date horaInicioPausa2, Date horaFinPausa2, BigDecimal horasExtraCliente, BigDecimal horasExtraKn, Date horaIniMov, Date horaFinMov, int horasTotalA, int horasTotalB, int horasTotalB1, int horasTotalB2, int horasTotalB3, int horasTotalC, int horasTotalC1, int horasTotalC2, int horasTotalC3, int horasTotalC4, int horasTotalC5) {
        this.handHrealOperPK = handHrealOperPK;
        this.trabajado = trabajado;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.horasTotales = horasTotales;
        this.horaInicioPausa1 = horaInicioPausa1;
        this.horaFinPausa1 = horaFinPausa1;
        this.horaInicioPausa2 = horaInicioPausa2;
        this.horaFinPausa2 = horaFinPausa2;
        this.horasExtraCliente = horasExtraCliente;
        this.horasExtraKn = horasExtraKn;
        this.horaIniMov = horaIniMov;
        this.horaFinMov = horaFinMov;
        this.horasTotalA = horasTotalA;
        this.horasTotalB = horasTotalB;
        this.horasTotalB1 = horasTotalB1;
        this.horasTotalB2 = horasTotalB2;
        this.horasTotalB3 = horasTotalB3;
        this.horasTotalC = horasTotalC;
        this.horasTotalC1 = horasTotalC1;
        this.horasTotalC2 = horasTotalC2;
        this.horasTotalC3 = horasTotalC3;
        this.horasTotalC4 = horasTotalC4;
        this.horasTotalC5 = horasTotalC5;
    }

    public HandHrealOper(int hrealId, String operario) {
        this.handHrealOperPK = new HandHrealOperPK(hrealId, operario);
    }

    public HandHrealOperPK getHandHrealOperPK() {
        return handHrealOperPK;
    }

    public void setHandHrealOperPK(HandHrealOperPK handHrealOperPK) {
        this.handHrealOperPK = handHrealOperPK;
    }

    public String getTrabajado() {
        return trabajado;
    }

    public void setTrabajado(String trabajado) {
        this.trabajado = trabajado;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public BigDecimal getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(BigDecimal horasTotales) {
        this.horasTotales = horasTotales;
    }

    public Date getHoraInicioPausa1() {
        return horaInicioPausa1;
    }

    public void setHoraInicioPausa1(Date horaInicioPausa1) {
        this.horaInicioPausa1 = horaInicioPausa1;
    }

    public Date getHoraFinPausa1() {
        return horaFinPausa1;
    }

    public void setHoraFinPausa1(Date horaFinPausa1) {
        this.horaFinPausa1 = horaFinPausa1;
    }

    public Date getHoraInicioPausa2() {
        return horaInicioPausa2;
    }

    public void setHoraInicioPausa2(Date horaInicioPausa2) {
        this.horaInicioPausa2 = horaInicioPausa2;
    }

    public Date getHoraFinPausa2() {
        return horaFinPausa2;
    }

    public void setHoraFinPausa2(Date horaFinPausa2) {
        this.horaFinPausa2 = horaFinPausa2;
    }

    public BigDecimal getHorasExtraCliente() {
        return horasExtraCliente;
    }

    public void setHorasExtraCliente(BigDecimal horasExtraCliente) {
        this.horasExtraCliente = horasExtraCliente;
    }

    public BigDecimal getHorasExtraKn() {
        return horasExtraKn;
    }

    public void setHorasExtraKn(BigDecimal horasExtraKn) {
        this.horasExtraKn = horasExtraKn;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getHoraIniMov() {
        return horaIniMov;
    }

    public void setHoraIniMov(Date horaIniMov) {
        this.horaIniMov = horaIniMov;
    }

    public Date getHoraFinMov() {
        return horaFinMov;
    }

    public void setHoraFinMov(Date horaFinMov) {
        this.horaFinMov = horaFinMov;
    }

    public int getHorasTotalA() {
        return horasTotalA;
    }

    public void setHorasTotalA(int horasTotalA) {
        this.horasTotalA = horasTotalA;
    }

    public int getHorasTotalB() {
        return horasTotalB;
    }

    public void setHorasTotalB(int horasTotalB) {
        this.horasTotalB = horasTotalB;
    }

    public int getHorasTotalB1() {
        return horasTotalB1;
    }

    public void setHorasTotalB1(int horasTotalB1) {
        this.horasTotalB1 = horasTotalB1;
    }

    public int getHorasTotalB2() {
        return horasTotalB2;
    }

    public void setHorasTotalB2(int horasTotalB2) {
        this.horasTotalB2 = horasTotalB2;
    }

    public int getHorasTotalB3() {
        return horasTotalB3;
    }

    public void setHorasTotalB3(int horasTotalB3) {
        this.horasTotalB3 = horasTotalB3;
    }

    public int getHorasTotalC() {
        return horasTotalC;
    }

    public void setHorasTotalC(int horasTotalC) {
        this.horasTotalC = horasTotalC;
    }

    public int getHorasTotalC1() {
        return horasTotalC1;
    }

    public void setHorasTotalC1(int horasTotalC1) {
        this.horasTotalC1 = horasTotalC1;
    }

    public int getHorasTotalC2() {
        return horasTotalC2;
    }

    public void setHorasTotalC2(int horasTotalC2) {
        this.horasTotalC2 = horasTotalC2;
    }

    public int getHorasTotalC3() {
        return horasTotalC3;
    }

    public void setHorasTotalC3(int horasTotalC3) {
        this.horasTotalC3 = horasTotalC3;
    }

    public int getHorasTotalC4() {
        return horasTotalC4;
    }

    public void setHorasTotalC4(int horasTotalC4) {
        this.horasTotalC4 = horasTotalC4;
    }

    public int getHorasTotalC5() {
        return horasTotalC5;
    }

    public void setHorasTotalC5(int horasTotalC5) {
        this.horasTotalC5 = horasTotalC5;
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

    public HandTurnos getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(HandTurnos turnoId) {
        this.turnoId = turnoId;
    }

    public HandHreal getHandHreal() {
        return handHreal;
    }

    public void setHandHreal(HandHreal handHreal) {
        this.handHreal = handHreal;
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
        hash += (handHrealOperPK != null ? handHrealOperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandHrealOper)) {
            return false;
        }
        HandHrealOper other = (HandHrealOper) object;
        if ((this.handHrealOperPK == null && other.handHrealOperPK != null) || (this.handHrealOperPK != null && !this.handHrealOperPK.equals(other.handHrealOperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandHrealOper[ handHrealOperPK=" + handHrealOperPK + " ]";
    }
    
}
