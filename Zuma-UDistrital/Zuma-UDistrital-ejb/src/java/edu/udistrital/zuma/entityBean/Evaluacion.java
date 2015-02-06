/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.entityBean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionId", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionId = :evaluacionId"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionTema", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionTema = :evaluacionTema"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionDescripcion", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionDescripcion = :evaluacionDescripcion"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionFechaInicio", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionFechaInicio = :evaluacionFechaInicio"),
    @NamedQuery(name = "Evaluacion.findByEvaliacionFechaFin", query = "SELECT e FROM Evaluacion e WHERE e.evaliacionFechaFin = :evaliacionFechaFin"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionTiempo", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionTiempo = :evaluacionTiempo")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluacion_id")
    private Integer evaluacionId;
    @Size(max = 2147483647)
    @Column(name = "evaluacion_tema")
    private String evaluacionTema;
    @Size(max = 2147483647)
    @Column(name = "evaluacion_descripcion")
    private String evaluacionDescripcion;
    @Column(name = "evaluacion_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date evaluacionFechaInicio;
    @Column(name = "evaliacion_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date evaliacionFechaFin;
    @Column(name = "evaluacion_tiempo")
    private Integer evaluacionTiempo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacionId")
    private List<UsuarioEvaluacion> usuarioEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacionId")
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
    @ManyToOne(optional = false)
    private Grupo grupoId;
    @JoinColumn(name = "estado_evaluacion_id", referencedColumnName = "estado_evaluacion_id")
    @ManyToOne(optional = false)
    private EstadoEvaluacion estadoEvaluacionId;

    public Evaluacion() {
    }

    public Evaluacion(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getEvaluacionTema() {
        return evaluacionTema;
    }

    public void setEvaluacionTema(String evaluacionTema) {
        this.evaluacionTema = evaluacionTema;
    }

    public String getEvaluacionDescripcion() {
        return evaluacionDescripcion;
    }

    public void setEvaluacionDescripcion(String evaluacionDescripcion) {
        this.evaluacionDescripcion = evaluacionDescripcion;
    }

    public Date getEvaluacionFechaInicio() {
        return evaluacionFechaInicio;
    }

    public void setEvaluacionFechaInicio(Date evaluacionFechaInicio) {
        this.evaluacionFechaInicio = evaluacionFechaInicio;
    }

    public Date getEvaliacionFechaFin() {
        return evaliacionFechaFin;
    }

    public void setEvaliacionFechaFin(Date evaliacionFechaFin) {
        this.evaliacionFechaFin = evaliacionFechaFin;
    }

    public Integer getEvaluacionTiempo() {
        return evaluacionTiempo;
    }

    public void setEvaluacionTiempo(Integer evaluacionTiempo) {
        this.evaluacionTiempo = evaluacionTiempo;
    }

    @XmlTransient
    public List<UsuarioEvaluacion> getUsuarioEvaluacionList() {
        return usuarioEvaluacionList;
    }

    public void setUsuarioEvaluacionList(List<UsuarioEvaluacion> usuarioEvaluacionList) {
        this.usuarioEvaluacionList = usuarioEvaluacionList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
    }

    public EstadoEvaluacion getEstadoEvaluacionId() {
        return estadoEvaluacionId;
    }

    public void setEstadoEvaluacionId(EstadoEvaluacion estadoEvaluacionId) {
        this.estadoEvaluacionId = estadoEvaluacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionId != null ? evaluacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.evaluacionId == null && other.evaluacionId != null) || (this.evaluacionId != null && !this.evaluacionId.equals(other.evaluacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Evaluacion[ evaluacionId=" + evaluacionId + " ]";
    }
    
}
