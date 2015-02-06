/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.entityBean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "estado_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuario.findAll", query = "SELECT e FROM EstadoUsuario e"),
    @NamedQuery(name = "EstadoUsuario.findByEstadoUsuarioId", query = "SELECT e FROM EstadoUsuario e WHERE e.estadoUsuarioId = :estadoUsuarioId"),
    @NamedQuery(name = "EstadoUsuario.findByEstadoUsuarioEstado", query = "SELECT e FROM EstadoUsuario e WHERE e.estadoUsuarioEstado = :estadoUsuarioEstado"),
    @NamedQuery(name = "EstadoUsuario.findByEstadoUsuarioDescripcion", query = "SELECT e FROM EstadoUsuario e WHERE e.estadoUsuarioDescripcion = :estadoUsuarioDescripcion")})
public class EstadoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estado_usuario_id")
    private Integer estadoUsuarioId;
    @Size(max = 2147483647)
    @Column(name = "estado_usuario_estado")
    private String estadoUsuarioEstado;
    @Size(max = 2147483647)
    @Column(name = "estado_usuario_descripcion")
    private String estadoUsuarioDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUsuario")
    private List<Usuario> usuarioList;

    public EstadoUsuario() {
    }

    public EstadoUsuario(Integer estadoUsuarioId) {
        this.estadoUsuarioId = estadoUsuarioId;
    }

    public Integer getEstadoUsuarioId() {
        return estadoUsuarioId;
    }

    public void setEstadoUsuarioId(Integer estadoUsuarioId) {
        this.estadoUsuarioId = estadoUsuarioId;
    }

    public String getEstadoUsuarioEstado() {
        return estadoUsuarioEstado;
    }

    public void setEstadoUsuarioEstado(String estadoUsuarioEstado) {
        this.estadoUsuarioEstado = estadoUsuarioEstado;
    }

    public String getEstadoUsuarioDescripcion() {
        return estadoUsuarioDescripcion;
    }

    public void setEstadoUsuarioDescripcion(String estadoUsuarioDescripcion) {
        this.estadoUsuarioDescripcion = estadoUsuarioDescripcion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoUsuarioId != null ? estadoUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuario)) {
            return false;
        }
        EstadoUsuario other = (EstadoUsuario) object;
        if ((this.estadoUsuarioId == null && other.estadoUsuarioId != null) || (this.estadoUsuarioId != null && !this.estadoUsuarioId.equals(other.estadoUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.EstadoUsuario[ estadoUsuarioId=" + estadoUsuarioId + " ]";
    }
    
}
