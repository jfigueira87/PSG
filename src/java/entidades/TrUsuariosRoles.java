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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonnatha
 */
@Entity
@Table(name = "tr_usuarios_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrUsuariosRoles.findAll", query = "SELECT t FROM TrUsuariosRoles t"),
    @NamedQuery(name = "TrUsuariosRoles.findByUsuIdusuario", query = "SELECT t FROM TrUsuariosRoles t WHERE t.usuIdusuario = :usuIdusuario"),
    @NamedQuery(name = "TrUsuariosRoles.findByRolId", query = "SELECT t FROM TrUsuariosRoles t WHERE t.rolId = :rolId")})
public class TrUsuariosRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USU_IDUSUARIO")
    private String usuIdusuario;
    @Basic(optional = false)
    @Column(name = "ROL_ID")
    private String rolId;
    @JoinColumn(name = "USU_IDUSUARIO", referencedColumnName = "USU_IDUSUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TrUsuarios trUsuarios;

    public TrUsuariosRoles() {
    }

    public TrUsuariosRoles(String usuIdusuario) {
        this.usuIdusuario = usuIdusuario;
    }

    public TrUsuariosRoles(String usuIdusuario, String rolId) {
        this.usuIdusuario = usuIdusuario;
        this.rolId = rolId;
    }

    public String getUsuIdusuario() {
        return usuIdusuario;
    }

    public void setUsuIdusuario(String usuIdusuario) {
        this.usuIdusuario = usuIdusuario;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
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
        hash += (usuIdusuario != null ? usuIdusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrUsuariosRoles)) {
            return false;
        }
        TrUsuariosRoles other = (TrUsuariosRoles) object;
        if ((this.usuIdusuario == null && other.usuIdusuario != null) || (this.usuIdusuario != null && !this.usuIdusuario.equals(other.usuIdusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TrUsuariosRoles[ usuIdusuario=" + usuIdusuario + " ]";
    }
    
}
