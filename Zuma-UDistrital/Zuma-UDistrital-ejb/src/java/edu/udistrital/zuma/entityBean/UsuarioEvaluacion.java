/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.entityBean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "usuario_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEvaluacion.findAll", query = "SELECT u FROM UsuarioEvaluacion u"),
    @NamedQuery(name = "UsuarioEvaluacion.findByUsuarioEvaluacionId", query = "SELECT u FROM UsuarioEvaluacion u WHERE u.usuarioEvaluacionId = :usuarioEvaluacionId"),
    @NamedQuery(name = "UsuarioEvaluacion.findByUsuarioEvaluacionNota", query = "SELECT u FROM UsuarioEvaluacion u WHERE u.usuarioEvaluacionNota = :usuarioEvaluacionNota"),
    @NamedQuery(name = "UsuarioEvaluacion.findByUsuarioEvaluacionFechaRealizacion", query = "SELECT u FROM UsuarioEvaluacion u WHERE u.usuarioEvaluacionFechaRealizacion = :usuarioEvaluacionFechaRealizacion")})
public class UsuarioEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_evaluacion_id")
    private Integer usuarioEvaluacionId;
    @Size(max = 2147483647)
    @Column(name = "usuario_evaluacion_nota")
    private String usuarioEvaluacionNota;
    @Column(name = "usuario_evaluacion_fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date usuarioEvaluacionFechaRealizacion;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "evaluacion_id", referencedColumnName = "evaluacion_id")
    @ManyToOne(optional = false)
    private Evaluacion evaluacionId;

    public UsuarioEvaluacion() {
    }

    public UsuarioEvaluacion(Integer usuarioEvaluacionId) {
        this.usuarioEvaluacionId = usuarioEvaluacionId;
    }

    public Integer getUsuarioEvaluacionId() {
        return usuarioEvaluacionId;
    }

    public void setUsuarioEvaluacionId(Integer usuarioEvaluacionId) {
        this.usuarioEvaluacionId = usuarioEvaluacionId;
    }

    public String getUsuarioEvaluacionNota() {
        return usuarioEvaluacionNota;
    }

    public void setUsuarioEvaluacionNota(String usuarioEvaluacionNota) {
        this.usuarioEvaluacionNota = usuarioEvaluacionNota;
    }

    public Date getUsuarioEvaluacionFechaRealizacion() {
        return usuarioEvaluacionFechaRealizacion;
    }

    public void setUsuarioEvaluacionFechaRealizacion(Date usuarioEvaluacionFechaRealizacion) {
        this.usuarioEvaluacionFechaRealizacion = usuarioEvaluacionFechaRealizacion;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Evaluacion getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Evaluacion evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioEvaluacionId != null ? usuarioEvaluacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEvaluacion)) {
            return false;
        }
        UsuarioEvaluacion other = (UsuarioEvaluacion) object;
        if ((this.usuarioEvaluacionId == null && other.usuarioEvaluacionId != null) || (this.usuarioEvaluacionId != null && !this.usuarioEvaluacionId.equals(other.usuarioEvaluacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.UsuarioEvaluacion[ usuarioEvaluacionId=" + usuarioEvaluacionId + " ]";
    }
    
}
