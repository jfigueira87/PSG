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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "hand_turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandTurnos.findAll", query = "SELECT h FROM HandTurnos h"),
    @NamedQuery(name = "HandTurnos.findById", query = "SELECT h FROM HandTurnos h WHERE h.id = :id"),
    @NamedQuery(name = "HandTurnos.findByNombre", query = "SELECT h FROM HandTurnos h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HandTurnos.findByDescripcion", query = "SELECT h FROM HandTurnos h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HandTurnos.findByRotativo", query = "SELECT h FROM HandTurnos h WHERE h.rotativo = :rotativo"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioA", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioA = :horaInicioA"),
    @NamedQuery(name = "HandTurnos.findByHoraFinA", query = "SELECT h FROM HandTurnos h WHERE h.horaFinA = :horaFinA"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa1A", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa1A = :horaInicioPausa1A"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa1A", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa1A = :horaFinPausa1A"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa2A", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa2A = :horaInicioPausa2A"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa2A", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa2A = :horaFinPausa2A"),
    @NamedQuery(name = "HandTurnos.findByFechaPrimeraRotacion", query = "SELECT h FROM HandTurnos h WHERE h.fechaPrimeraRotacion = :fechaPrimeraRotacion"),
    @NamedQuery(name = "HandTurnos.findByRotacion", query = "SELECT h FROM HandTurnos h WHERE h.rotacion = :rotacion"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioB", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioB = :horaInicioB"),
    @NamedQuery(name = "HandTurnos.findByHoraFinB", query = "SELECT h FROM HandTurnos h WHERE h.horaFinB = :horaFinB"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa1B", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa1B = :horaInicioPausa1B"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa1B", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa1B = :horaFinPausa1B"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa2B", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa2B = :horaInicioPausa2B"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa2B", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa2B = :horaFinPausa2B"),
    @NamedQuery(name = "HandTurnos.findByBorrado", query = "SELECT h FROM HandTurnos h WHERE h.borrado = :borrado"),
    @NamedQuery(name = "HandTurnos.findByMostrar", query = "SELECT h FROM HandTurnos h WHERE h.mostrar = :mostrar"),
    @NamedQuery(name = "HandTurnos.findByRotativoVariable", query = "SELECT h FROM HandTurnos h WHERE h.rotativoVariable = :rotativoVariable"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioC", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioC = :horaInicioC"),
    @NamedQuery(name = "HandTurnos.findByHoraFinC", query = "SELECT h FROM HandTurnos h WHERE h.horaFinC = :horaFinC"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa1C", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa1C = :horaInicioPausa1C"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa1C", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa1C = :horaFinPausa1C"),
    @NamedQuery(name = "HandTurnos.findByHoraInicioPausa2C", query = "SELECT h FROM HandTurnos h WHERE h.horaInicioPausa2C = :horaInicioPausa2C"),
    @NamedQuery(name = "HandTurnos.findByHoraFinPausa2C", query = "SELECT h FROM HandTurnos h WHERE h.horaFinPausa2C = :horaFinPausa2C"),
    @NamedQuery(name = "HandTurnos.findByRotacionDos", query = "SELECT h FROM HandTurnos h WHERE h.rotacionDos = :rotacionDos"),
    @NamedQuery(name = "HandTurnos.findByRotacionTres", query = "SELECT h FROM HandTurnos h WHERE h.rotacionTres = :rotacionTres"),
    @NamedQuery(name = "HandTurnos.findByNumeroRotaciones", query = "SELECT h FROM HandTurnos h WHERE h.numeroRotaciones = :numeroRotaciones")})
public class HandTurnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ROTATIVO")
    private int rotativo;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioA;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinA;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_1_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa1A;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_1_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa1A;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_2_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa2A;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_2_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa2A;
    @Column(name = "FECHA_PRIMERA_ROTACION")
    @Temporal(TemporalType.DATE)
    private Date fechaPrimeraRotacion;
    @Column(name = "ROTACION")
    private Integer rotacion;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioB;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinB;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_1_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa1B;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_1_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa1B;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_2_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa2B;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_2_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa2B;
    @Basic(optional = false)
    @Column(name = "BORRADO")
    private int borrado;
    @Basic(optional = false)
    @Column(name = "MOSTRAR")
    private int mostrar;
    @Basic(optional = false)
    @Column(name = "ROTATIVO_VARIABLE")
    private int rotativoVariable;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioC;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinC;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_1_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa1C;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_1_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa1C;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO_PAUSA_2_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPausa2C;
    @Basic(optional = false)
    @Column(name = "HORA_FIN_PAUSA_2_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPausa2C;
    @Column(name = "ROTACION_DOS")
    private Integer rotacionDos;
    @Column(name = "ROTACION_TRES")
    private Integer rotacionTres;
    @Column(name = "NUMERO_ROTACIONES")
    private Integer numeroRotaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnoId")
    private Collection<HandPlanifHist> handPlanifHistCollection;
    @JoinColumn(name = "PLT_CC", referencedColumnName = "PLT_CC")
    @ManyToOne(optional = false)
    private HandPlantas pltCc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnoId")
    private Collection<HandPlanif> handPlanifCollection;
    @OneToMany(mappedBy = "turnoId")
    private Collection<HandHrealOper> handHrealOperCollection;
    @OneToMany(mappedBy = "turnoId")
    private Collection<HandExcep> handExcepCollection;

    public HandTurnos() {
    }

    public HandTurnos(Integer id) {
        this.id = id;
    }

    public HandTurnos(Integer id, String nombre, String descripcion, int rotativo, Date horaInicioA, Date horaFinA, Date horaInicioPausa1A, Date horaFinPausa1A, Date horaInicioPausa2A, Date horaFinPausa2A, Date horaInicioB, Date horaFinB, Date horaInicioPausa1B, Date horaFinPausa1B, Date horaInicioPausa2B, Date horaFinPausa2B, int borrado, int mostrar, int rotativoVariable, Date horaInicioC, Date horaFinC, Date horaInicioPausa1C, Date horaFinPausa1C, Date horaInicioPausa2C, Date horaFinPausa2C) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rotativo = rotativo;
        this.horaInicioA = horaInicioA;
        this.horaFinA = horaFinA;
        this.horaInicioPausa1A = horaInicioPausa1A;
        this.horaFinPausa1A = horaFinPausa1A;
        this.horaInicioPausa2A = horaInicioPausa2A;
        this.horaFinPausa2A = horaFinPausa2A;
        this.horaInicioB = horaInicioB;
        this.horaFinB = horaFinB;
        this.horaInicioPausa1B = horaInicioPausa1B;
        this.horaFinPausa1B = horaFinPausa1B;
        this.horaInicioPausa2B = horaInicioPausa2B;
        this.horaFinPausa2B = horaFinPausa2B;
        this.borrado = borrado;
        this.mostrar = mostrar;
        this.rotativoVariable = rotativoVariable;
        this.horaInicioC = horaInicioC;
        this.horaFinC = horaFinC;
        this.horaInicioPausa1C = horaInicioPausa1C;
        this.horaFinPausa1C = horaFinPausa1C;
        this.horaInicioPausa2C = horaInicioPausa2C;
        this.horaFinPausa2C = horaFinPausa2C;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRotativo() {
        return rotativo;
    }

    public void setRotativo(int rotativo) {
        this.rotativo = rotativo;
    }

    public Date getHoraInicioA() {
        return horaInicioA;
    }

    public void setHoraInicioA(Date horaInicioA) {
        this.horaInicioA = horaInicioA;
    }

    public Date getHoraFinA() {
        return horaFinA;
    }

    public void setHoraFinA(Date horaFinA) {
        this.horaFinA = horaFinA;
    }

    public Date getHoraInicioPausa1A() {
        return horaInicioPausa1A;
    }

    public void setHoraInicioPausa1A(Date horaInicioPausa1A) {
        this.horaInicioPausa1A = horaInicioPausa1A;
    }

    public Date getHoraFinPausa1A() {
        return horaFinPausa1A;
    }

    public void setHoraFinPausa1A(Date horaFinPausa1A) {
        this.horaFinPausa1A = horaFinPausa1A;
    }

    public Date getHoraInicioPausa2A() {
        return horaInicioPausa2A;
    }

    public void setHoraInicioPausa2A(Date horaInicioPausa2A) {
        this.horaInicioPausa2A = horaInicioPausa2A;
    }

    public Date getHoraFinPausa2A() {
        return horaFinPausa2A;
    }

    public void setHoraFinPausa2A(Date horaFinPausa2A) {
        this.horaFinPausa2A = horaFinPausa2A;
    }

    public Date getFechaPrimeraRotacion() {
        return fechaPrimeraRotacion;
    }

    public void setFechaPrimeraRotacion(Date fechaPrimeraRotacion) {
        this.fechaPrimeraRotacion = fechaPrimeraRotacion;
    }

    public Integer getRotacion() {
        return rotacion;
    }

    public void setRotacion(Integer rotacion) {
        this.rotacion = rotacion;
    }

    public Date getHoraInicioB() {
        return horaInicioB;
    }

    public void setHoraInicioB(Date horaInicioB) {
        this.horaInicioB = horaInicioB;
    }

    public Date getHoraFinB() {
        return horaFinB;
    }

    public void setHoraFinB(Date horaFinB) {
        this.horaFinB = horaFinB;
    }

    public Date getHoraInicioPausa1B() {
        return horaInicioPausa1B;
    }

    public void setHoraInicioPausa1B(Date horaInicioPausa1B) {
        this.horaInicioPausa1B = horaInicioPausa1B;
    }

    public Date getHoraFinPausa1B() {
        return horaFinPausa1B;
    }

    public void setHoraFinPausa1B(Date horaFinPausa1B) {
        this.horaFinPausa1B = horaFinPausa1B;
    }

    public Date getHoraInicioPausa2B() {
        return horaInicioPausa2B;
    }

    public void setHoraInicioPausa2B(Date horaInicioPausa2B) {
        this.horaInicioPausa2B = horaInicioPausa2B;
    }

    public Date getHoraFinPausa2B() {
        return horaFinPausa2B;
    }

    public void setHoraFinPausa2B(Date horaFinPausa2B) {
        this.horaFinPausa2B = horaFinPausa2B;
    }

    public int getBorrado() {
        return borrado;
    }

    public void setBorrado(int borrado) {
        this.borrado = borrado;
    }

    public int getMostrar() {
        return mostrar;
    }

    public void setMostrar(int mostrar) {
        this.mostrar = mostrar;
    }

    public int getRotativoVariable() {
        return rotativoVariable;
    }

    public void setRotativoVariable(int rotativoVariable) {
        this.rotativoVariable = rotativoVariable;
    }

    public Date getHoraInicioC() {
        return horaInicioC;
    }

    public void setHoraInicioC(Date horaInicioC) {
        this.horaInicioC = horaInicioC;
    }

    public Date getHoraFinC() {
        return horaFinC;
    }

    public void setHoraFinC(Date horaFinC) {
        this.horaFinC = horaFinC;
    }

    public Date getHoraInicioPausa1C() {
        return horaInicioPausa1C;
    }

    public void setHoraInicioPausa1C(Date horaInicioPausa1C) {
        this.horaInicioPausa1C = horaInicioPausa1C;
    }

    public Date getHoraFinPausa1C() {
        return horaFinPausa1C;
    }

    public void setHoraFinPausa1C(Date horaFinPausa1C) {
        this.horaFinPausa1C = horaFinPausa1C;
    }

    public Date getHoraInicioPausa2C() {
        return horaInicioPausa2C;
    }

    public void setHoraInicioPausa2C(Date horaInicioPausa2C) {
        this.horaInicioPausa2C = horaInicioPausa2C;
    }

    public Date getHoraFinPausa2C() {
        return horaFinPausa2C;
    }

    public void setHoraFinPausa2C(Date horaFinPausa2C) {
        this.horaFinPausa2C = horaFinPausa2C;
    }

    public Integer getRotacionDos() {
        return rotacionDos;
    }

    public void setRotacionDos(Integer rotacionDos) {
        this.rotacionDos = rotacionDos;
    }

    public Integer getRotacionTres() {
        return rotacionTres;
    }

    public void setRotacionTres(Integer rotacionTres) {
        this.rotacionTres = rotacionTres;
    }

    public Integer getNumeroRotaciones() {
        return numeroRotaciones;
    }

    public void setNumeroRotaciones(Integer numeroRotaciones) {
        this.numeroRotaciones = numeroRotaciones;
    }

    @XmlTransient
    public Collection<HandPlanifHist> getHandPlanifHistCollection() {
        return handPlanifHistCollection;
    }

    public void setHandPlanifHistCollection(Collection<HandPlanifHist> handPlanifHistCollection) {
        this.handPlanifHistCollection = handPlanifHistCollection;
    }

    public HandPlantas getPltCc() {
        return pltCc;
    }

    public void setPltCc(HandPlantas pltCc) {
        this.pltCc = pltCc;
    }

    @XmlTransient
    public Collection<HandPlanif> getHandPlanifCollection() {
        return handPlanifCollection;
    }

    public void setHandPlanifCollection(Collection<HandPlanif> handPlanifCollection) {
        this.handPlanifCollection = handPlanifCollection;
    }

    @XmlTransient
    public Collection<HandHrealOper> getHandHrealOperCollection() {
        return handHrealOperCollection;
    }

    public void setHandHrealOperCollection(Collection<HandHrealOper> handHrealOperCollection) {
        this.handHrealOperCollection = handHrealOperCollection;
    }

    @XmlTransient
    public Collection<HandExcep> getHandExcepCollection() {
        return handExcepCollection;
    }

    public void setHandExcepCollection(Collection<HandExcep> handExcepCollection) {
        this.handExcepCollection = handExcepCollection;
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
        if (!(object instanceof HandTurnos)) {
            return false;
        }
        HandTurnos other = (HandTurnos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HandTurnos[ id=" + id + " ]";
    }
    
}
