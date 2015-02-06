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
@Table(name = "estado_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoGrupo.findAll", query = "SELECT e FROM EstadoGrupo e"),
    @NamedQuery(name = "EstadoGrupo.findByEstadoGrupoId", query = "SELECT e FROM EstadoGrupo e WHERE e.estadoGrupoId = :estadoGrupoId"),
    @NamedQuery(name = "EstadoGrupo.findByEstadoGrupoEstado", query = "SELECT e FROM EstadoGrupo e WHERE e.estadoGrupoEstado = :estadoGrupoEstado"),
    @NamedQuery(name = "EstadoGrupo.findByEstadoGrupoDescripcion", query = "SELECT e FROM EstadoGrupo e WHERE e.estadoGrupoDescripcion = :estadoGrupoDescripcion")})
public class EstadoGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estado_grupo_id")
    private Integer estadoGrupoId;
    @Size(max = 2147483647)
    @Column(name = "estado_grupo_estado")
    private String estadoGrupoEstado;
    @Size(max = 2147483647)
    @Column(name = "estado_grupo_descripcion")
    private String estadoGrupoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoGrupoId")
    private List<Grupo> grupoList;

    public EstadoGrupo() {
    }

    public EstadoGrupo(Integer estadoGrupoId) {
        this.estadoGrupoId = estadoGrupoId;
    }

    public Integer getEstadoGrupoId() {
        return estadoGrupoId;
    }

    public void setEstadoGrupoId(Integer estadoGrupoId) {
        this.estadoGrupoId = estadoGrupoId;
    }

    public String getEstadoGrupoEstado() {
        return estadoGrupoEstado;
    }

    public void setEstadoGrupoEstado(String estadoGrupoEstado) {
        this.estadoGrupoEstado = estadoGrupoEstado;
    }

    public String getEstadoGrupoDescripcion() {
        return estadoGrupoDescripcion;
    }

    public void setEstadoGrupoDescripcion(String estadoGrupoDescripcion) {
        this.estadoGrupoDescripcion = estadoGrupoDescripcion;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoGrupoId != null ? estadoGrupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoGrupo)) {
            return false;
        }
        EstadoGrupo other = (EstadoGrupo) object;
        if ((this.estadoGrupoId == null && other.estadoGrupoId != null) || (this.estadoGrupoId != null && !this.estadoGrupoId.equals(other.estadoGrupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.EstadoGrupo[ estadoGrupoId=" + estadoGrupoId + " ]";
    }
    
}
