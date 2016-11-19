/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "tr_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrUsuarios.findAll", query = "SELECT t FROM TrUsuarios t"),
    @NamedQuery(name = "TrUsuarios.findByUsuIdusuario", query = "SELECT t FROM TrUsuarios t WHERE t.usuIdusuario = :usuIdusuario"),
    @NamedQuery(name = "TrUsuarios.findByUsuClaveacceso", query = "SELECT t FROM TrUsuarios t WHERE t.usuClaveacceso = :usuClaveacceso"),
    @NamedQuery(name = "TrUsuarios.findByUsuNombre", query = "SELECT t FROM TrUsuarios t WHERE t.usuNombre = :usuNombre"),
    @NamedQuery(name = "TrUsuarios.findByUsuApellido1", query = "SELECT t FROM TrUsuarios t WHERE t.usuApellido1 = :usuApellido1"),
    @NamedQuery(name = "TrUsuarios.findByUsuApellido2", query = "SELECT t FROM TrUsuarios t WHERE t.usuApellido2 = :usuApellido2"),
    @NamedQuery(name = "TrUsuarios.findByUsuEmail", query = "SELECT t FROM TrUsuarios t WHERE t.usuEmail = :usuEmail"),
    @NamedQuery(name = "TrUsuarios.findByUsuTelefono", query = "SELECT t FROM TrUsuarios t WHERE t.usuTelefono = :usuTelefono"),
    @NamedQuery(name = "TrUsuarios.findByCodMlsIdioma", query = "SELECT t FROM TrUsuarios t WHERE t.codMlsIdioma = :codMlsIdioma"),
    @NamedQuery(name = "TrUsuarios.findByUrlfotoUsuario", query = "SELECT t FROM TrUsuarios t WHERE t.urlfotoUsuario = :urlfotoUsuario"),
    @NamedQuery(name = "TrUsuarios.findByRol", query = "SELECT t FROM TrUsuarios t WHERE t.rol = :rol")})
public class TrUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USU_IDUSUARIO")
    private String usuIdusuario;
    @Basic(optional = false)
    @Column(name = "USU_CLAVEACCESO")
    private String usuClaveacceso;
    @Basic(optional = false)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Basic(optional = false)
    @Column(name = "USU_APELLIDO1")
    private String usuApellido1;
    @Column(name = "USU_APELLIDO2")
    private String usuApellido2;
    @Column(name = "USU_EMAIL")
    private String usuEmail;
    @Column(name = "USU_TELEFONO")
    private String usuTelefono;
    @Basic(optional = false)
    @Column(name = "COD_MLS_IDIOMA")
    private String codMlsIdioma;
    @Column(name = "url_fotoUsuario")
    private String urlfotoUsuario;
    @Column(name = "rol")
    private String rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operario")
    private Collection<HandPlanifHist> handPlanifHistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trUsuarios")
    private Collection<HandPlanif> handPlanifCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operario")
    private Collection<HandTiempos> handTiemposCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trUsuarios")
    private Collection<HandHrealOper> handHrealOperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operario")
    private Collection<HandExcep> handExcepCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trUsuarios")
    private TrUsuariosRoles trUsuariosRoles;

    public TrUsuarios() {
    }

    public TrUsuarios(String usuIdusuario) {
        this.usuIdusuario = usuIdusuario;
    }

    public TrUsuarios(String usuIdusuario, String usuClaveacceso, String usuNombre, String usuApellido1, String codMlsIdioma) {
        this.usuIdusuario = usuIdusuario;
        this.usuClaveacceso = usuClaveacceso;
        this.usuNombre = usuNombre;
        this.usuApellido1 = usuApellido1;
        this.codMlsIdioma = codMlsIdioma;
    }

    public String getUsuIdusuario() {
        return usuIdusuario;
    }

    public void setUsuIdusuario(String usuIdusuario) {
        this.usuIdusuario = usuIdusuario;
    }

    public String getUsuClaveacceso() {
        return usuClaveacceso;
    }

    public void setUsuClaveacceso(String usuClaveacceso) {
        this.usuClaveacceso = usuClaveacceso;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido1() {
        return usuApellido1;
    }

    public void setUsuApellido1(String usuApellido1) {
        this.usuApellido1 = usuApellido1;
    }

    public String getUsuApellido2() {
        return usuApellido2;
    }

    public void setUsuApellido2(String usuApellido2) {
        this.usuApellido2 = usuApellido2;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public String getCodMlsIdioma() {
        return codMlsIdioma;
    }

    public void setCodMlsIdioma(String codMlsIdioma) {
        this.codMlsIdioma = codMlsIdioma;
    }

    public String getUrlfotoUsuario() {
        return urlfotoUsuario;
    }

    public void setUrlfotoUsuario(String urlfotoUsuario) {
        this.urlfotoUsuario = urlfotoUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<HandPlanifHist> getHandPlanifHistCollection() {
        return handPlanifHistCollection;
    }

    public void setHandPlanifHistCollection(Collection<HandPlanifHist> handPlanifHistCollection) {
        this.handPlanifHistCollection = handPlanifHistCollection;
    }

    @XmlTransient
    public Collection<HandPlanif> getHandPlanifCollection() {
        return handPlanifCollection;
    }

    public void setHandPlanifCollection(Collection<HandPlanif> handPlanifCollection) {
        this.handPlanifCollection = handPlanifCollection;
    }

    @XmlTransient
    public Collection<HandTiempos> getHandTiemposCollection() {
        return handTiemposCollection;
    }

    public void setHandTiemposCollection(Collection<HandTiempos> handTiemposCollection) {
        this.handTiemposCollection = handTiemposCollection;
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

    public TrUsuariosRoles getTrUsuariosRoles() {
        return trUsuariosRoles;
    }

    public void setTrUsuariosRoles(TrUsuariosRoles trUsuariosRoles) {
        this.trUsuariosRoles = trUsuariosRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdusuario != null ? usuIdusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrUsuarios)) {
            return false;
        }
        TrUsuarios other = (TrUsuarios) object;
        if ((this.usuIdusuario == null && other.usuIdusuario != null) || (this.usuIdusuario != null && !this.usuIdusuario.equals(other.usuIdusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TrUsuarios[ usuIdusuario=" + usuIdusuario + " ]";
    }
    
}
