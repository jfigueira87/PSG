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
@Table(name = "v_hand_desvios_tiempos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHandDesviosTiempos.findAll", query = "SELECT v FROM VHandDesviosTiempos v"),
    @NamedQuery(name = "VHandDesviosTiempos.findByPltCc", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.pltCc = :pltCc"),
    @NamedQuery(name = "VHandDesviosTiempos.findByOperario", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.operario = :operario"),
    @NamedQuery(name = "VHandDesviosTiempos.findByEstacionInicioId", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.estacionInicioId = :estacionInicioId"),
    @NamedQuery(name = "VHandDesviosTiempos.findByEstacionFinId", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.estacionFinId = :estacionFinId"),
    @NamedQuery(name = "VHandDesviosTiempos.findByHoraInicio", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.horaInicio = :horaInicio"),
    @NamedQuery(name = "VHandDesviosTiempos.findByHoraFin", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.horaFin = :horaFin"),
    @NamedQuery(name = "VHandDesviosTiempos.findByTiempoTotal", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.tiempoTotal = :tiempoTotal"),
    @NamedQuery(name = "VHandDesviosTiempos.findByTiempoMedio", query = "SELECT v FROM VHandDesviosTiempos v WHERE v.tiempoMedio = :tiempoMedio")})
public class VHandDesviosTiempos implements Serializable {

    private static final long serialVersionUID = 1L;
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

    public VHandDesviosTiempos() {
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
    
}
