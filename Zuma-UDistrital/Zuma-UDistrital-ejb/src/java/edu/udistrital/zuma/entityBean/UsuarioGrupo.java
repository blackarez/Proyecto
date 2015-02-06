/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.entityBean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "usuario_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioGrupo.findAll", query = "SELECT u FROM UsuarioGrupo u"),
    @NamedQuery(name = "UsuarioGrupo.findByUsuarioGrupoId", query = "SELECT u FROM UsuarioGrupo u WHERE u.usuarioGrupoId = :usuarioGrupoId")})
public class UsuarioGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_grupo_id")
    private Integer usuarioGrupoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
    @ManyToOne(optional = false)
    private Grupo grupoId;

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(Integer usuarioGrupoId) {
        this.usuarioGrupoId = usuarioGrupoId;
    }

    public Integer getUsuarioGrupoId() {
        return usuarioGrupoId;
    }

    public void setUsuarioGrupoId(Integer usuarioGrupoId) {
        this.usuarioGrupoId = usuarioGrupoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioGrupoId != null ? usuarioGrupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioGrupo)) {
            return false;
        }
        UsuarioGrupo other = (UsuarioGrupo) object;
        if ((this.usuarioGrupoId == null && other.usuarioGrupoId != null) || (this.usuarioGrupoId != null && !this.usuarioGrupoId.equals(other.usuarioGrupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.UsuarioGrupo[ usuarioGrupoId=" + usuarioGrupoId + " ]";
    }
    
}
