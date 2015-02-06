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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByPreguntaId", query = "SELECT p FROM Pregunta p WHERE p.preguntaId = :preguntaId"),
    @NamedQuery(name = "Pregunta.findByPreguntaEnunciado", query = "SELECT p FROM Pregunta p WHERE p.preguntaEnunciado = :preguntaEnunciado"),
    @NamedQuery(name = "Pregunta.findByPreguntaOpcionA", query = "SELECT p FROM Pregunta p WHERE p.preguntaOpcionA = :preguntaOpcionA"),
    @NamedQuery(name = "Pregunta.findByPreguntaOpcionB", query = "SELECT p FROM Pregunta p WHERE p.preguntaOpcionB = :preguntaOpcionB"),
    @NamedQuery(name = "Pregunta.findByPreguntaOpcionC", query = "SELECT p FROM Pregunta p WHERE p.preguntaOpcionC = :preguntaOpcionC"),
    @NamedQuery(name = "Pregunta.findByPreguntaOpcionD", query = "SELECT p FROM Pregunta p WHERE p.preguntaOpcionD = :preguntaOpcionD"),
    @NamedQuery(name = "Pregunta.findByPreguntaRespuesta", query = "SELECT p FROM Pregunta p WHERE p.preguntaRespuesta = :preguntaRespuesta")})
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pregunta_id")
    private Integer preguntaId;
    @Size(max = 2147483647)
    @Column(name = "pregunta_enunciado")
    private String preguntaEnunciado;
    @Size(max = 2147483647)
    @Column(name = "pregunta_opcion_a")
    private String preguntaOpcionA;
    @Size(max = 2147483647)
    @Column(name = "pregunta_opcion_b")
    private String preguntaOpcionB;
    @Size(max = 2147483647)
    @Column(name = "pregunta_opcion_c")
    private String preguntaOpcionC;
    @Size(max = 2147483647)
    @Column(name = "pregunta_opcion_d")
    private String preguntaOpcionD;
    @Size(max = 2147483647)
    @Column(name = "pregunta_respuesta")
    private String preguntaRespuesta;
    @JoinColumn(name = "evaluacion_id", referencedColumnName = "evaluacion_id")
    @ManyToOne(optional = false)
    private Evaluacion evaluacionId;

    public Pregunta() {
    }

    public Pregunta(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getPreguntaEnunciado() {
        return preguntaEnunciado;
    }

    public void setPreguntaEnunciado(String preguntaEnunciado) {
        this.preguntaEnunciado = preguntaEnunciado;
    }

    public String getPreguntaOpcionA() {
        return preguntaOpcionA;
    }

    public void setPreguntaOpcionA(String preguntaOpcionA) {
        this.preguntaOpcionA = preguntaOpcionA;
    }

    public String getPreguntaOpcionB() {
        return preguntaOpcionB;
    }

    public void setPreguntaOpcionB(String preguntaOpcionB) {
        this.preguntaOpcionB = preguntaOpcionB;
    }

    public String getPreguntaOpcionC() {
        return preguntaOpcionC;
    }

    public void setPreguntaOpcionC(String preguntaOpcionC) {
        this.preguntaOpcionC = preguntaOpcionC;
    }

    public String getPreguntaOpcionD() {
        return preguntaOpcionD;
    }

    public void setPreguntaOpcionD(String preguntaOpcionD) {
        this.preguntaOpcionD = preguntaOpcionD;
    }

    public String getPreguntaRespuesta() {
        return preguntaRespuesta;
    }

    public void setPreguntaRespuesta(String preguntaRespuesta) {
        this.preguntaRespuesta = preguntaRespuesta;
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
        hash += (preguntaId != null ? preguntaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaId == null && other.preguntaId != null) || (this.preguntaId != null && !this.preguntaId.equals(other.preguntaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Pregunta[ preguntaId=" + preguntaId + " ]";
    }
    
}
