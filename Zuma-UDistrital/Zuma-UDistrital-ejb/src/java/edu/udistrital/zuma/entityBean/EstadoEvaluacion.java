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
@Table(name = "estado_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEvaluacion.findAll", query = "SELECT e FROM EstadoEvaluacion e"),
    @NamedQuery(name = "EstadoEvaluacion.findByEstadoEvaluacionId", query = "SELECT e FROM EstadoEvaluacion e WHERE e.estadoEvaluacionId = :estadoEvaluacionId"),
    @NamedQuery(name = "EstadoEvaluacion.findByEstadoEvaluacionEstado", query = "SELECT e FROM EstadoEvaluacion e WHERE e.estadoEvaluacionEstado = :estadoEvaluacionEstado"),
    @NamedQuery(name = "EstadoEvaluacion.findByEstadoEvaluacionDescripcion", query = "SELECT e FROM EstadoEvaluacion e WHERE e.estadoEvaluacionDescripcion = :estadoEvaluacionDescripcion")})
public class EstadoEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estado_evaluacion_id")
    private Integer estadoEvaluacionId;
    @Size(max = 2147483647)
    @Column(name = "estado_evaluacion_estado")
    private String estadoEvaluacionEstado;
    @Size(max = 2147483647)
    @Column(name = "estado_evaluacion_descripcion")
    private String estadoEvaluacionDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoEvaluacionId")
    private List<Evaluacion> evaluacionList;

    public EstadoEvaluacion() {
    }

    public EstadoEvaluacion(Integer estadoEvaluacionId) {
        this.estadoEvaluacionId = estadoEvaluacionId;
    }

    public Integer getEstadoEvaluacionId() {
        return estadoEvaluacionId;
    }

    public void setEstadoEvaluacionId(Integer estadoEvaluacionId) {
        this.estadoEvaluacionId = estadoEvaluacionId;
    }

    public String getEstadoEvaluacionEstado() {
        return estadoEvaluacionEstado;
    }

    public void setEstadoEvaluacionEstado(String estadoEvaluacionEstado) {
        this.estadoEvaluacionEstado = estadoEvaluacionEstado;
    }

    public String getEstadoEvaluacionDescripcion() {
        return estadoEvaluacionDescripcion;
    }

    public void setEstadoEvaluacionDescripcion(String estadoEvaluacionDescripcion) {
        this.estadoEvaluacionDescripcion = estadoEvaluacionDescripcion;
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
        hash += (estadoEvaluacionId != null ? estadoEvaluacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEvaluacion)) {
            return false;
        }
        EstadoEvaluacion other = (EstadoEvaluacion) object;
        if ((this.estadoEvaluacionId == null && other.estadoEvaluacionId != null) || (this.estadoEvaluacionId != null && !this.estadoEvaluacionId.equals(other.estadoEvaluacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.EstadoEvaluacion[ estadoEvaluacionId=" + estadoEvaluacionId + " ]";
    }
    
}
