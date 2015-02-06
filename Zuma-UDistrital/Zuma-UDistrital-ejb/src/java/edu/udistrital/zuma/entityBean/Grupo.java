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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGrupoId", query = "SELECT g FROM Grupo g WHERE g.grupoId = :grupoId"),
    @NamedQuery(name = "Grupo.findByGrupoNombre", query = "SELECT g FROM Grupo g WHERE g.grupoNombre = :grupoNombre"),
    @NamedQuery(name = "Grupo.findByGrupoDescripcion", query = "SELECT g FROM Grupo g WHERE g.grupoDescripcion = :grupoDescripcion"),
    @NamedQuery(name = "Grupo.findByGrupoPrerrequisitos", query = "SELECT g FROM Grupo g WHERE g.grupoPrerrequisitos = :grupoPrerrequisitos")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_id")
    private Integer grupoId;
    @Size(max = 2147483647)
    @Column(name = "grupo_nombre")
    private String grupoNombre;
    @Size(max = 2147483647)
    @Column(name = "grupo_descripcion")
    private String grupoDescripcion;
    @Size(max = 2147483647)
    @Column(name = "grupo_prerrequisitos")
    private String grupoPrerrequisitos;
    @JoinColumn(name = "estado_grupo_id", referencedColumnName = "estado_grupo_id")
    @ManyToOne(optional = false)
    private EstadoGrupo estadoGrupoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private List<Contenido> contenidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private List<UsuarioGrupo> usuarioGrupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private List<LibroMagico> libroMagicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private List<Evaluacion> evaluacionList;

    public Grupo() {
    }

    public Grupo(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public String getGrupoDescripcion() {
        return grupoDescripcion;
    }

    public void setGrupoDescripcion(String grupoDescripcion) {
        this.grupoDescripcion = grupoDescripcion;
    }

    public String getGrupoPrerrequisitos() {
        return grupoPrerrequisitos;
    }

    public void setGrupoPrerrequisitos(String grupoPrerrequisitos) {
        this.grupoPrerrequisitos = grupoPrerrequisitos;
    }

    public EstadoGrupo getEstadoGrupoId() {
        return estadoGrupoId;
    }

    public void setEstadoGrupoId(EstadoGrupo estadoGrupoId) {
        this.estadoGrupoId = estadoGrupoId;
    }

    @XmlTransient
    public List<Contenido> getContenidoList() {
        return contenidoList;
    }

    public void setContenidoList(List<Contenido> contenidoList) {
        this.contenidoList = contenidoList;
    }

    @XmlTransient
    public List<UsuarioGrupo> getUsuarioGrupoList() {
        return usuarioGrupoList;
    }

    public void setUsuarioGrupoList(List<UsuarioGrupo> usuarioGrupoList) {
        this.usuarioGrupoList = usuarioGrupoList;
    }

    @XmlTransient
    public List<LibroMagico> getLibroMagicoList() {
        return libroMagicoList;
    }

    public void setLibroMagicoList(List<LibroMagico> libroMagicoList) {
        this.libroMagicoList = libroMagicoList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Grupo[ grupoId=" + grupoId + " ]";
    }
    
}
