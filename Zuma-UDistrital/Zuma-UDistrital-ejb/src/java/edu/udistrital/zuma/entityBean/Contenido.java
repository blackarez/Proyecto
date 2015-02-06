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
@Table(name = "contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c"),
    @NamedQuery(name = "Contenido.findByContenidoId", query = "SELECT c FROM Contenido c WHERE c.contenidoId = :contenidoId"),
    @NamedQuery(name = "Contenido.findByContenidoTitulo", query = "SELECT c FROM Contenido c WHERE c.contenidoTitulo = :contenidoTitulo"),
    @NamedQuery(name = "Contenido.findByContenidoTema", query = "SELECT c FROM Contenido c WHERE c.contenidoTema = :contenidoTema"),
    @NamedQuery(name = "Contenido.findByContenidoIntroduccion", query = "SELECT c FROM Contenido c WHERE c.contenidoIntroduccion = :contenidoIntroduccion"),
    @NamedQuery(name = "Contenido.findByContenidoResumen", query = "SELECT c FROM Contenido c WHERE c.contenidoResumen = :contenidoResumen"),
    @NamedQuery(name = "Contenido.findByContenidoExplicacion", query = "SELECT c FROM Contenido c WHERE c.contenidoExplicacion = :contenidoExplicacion")})
public class Contenido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contenido_id")
    private Integer contenidoId;
    @Size(max = 2147483647)
    @Column(name = "contenido_titulo")
    private String contenidoTitulo;
    @Size(max = 2147483647)
    @Column(name = "contenido_tema")
    private String contenidoTema;
    @Size(max = 2147483647)
    @Column(name = "contenido_introduccion")
    private String contenidoIntroduccion;
    @Size(max = 2147483647)
    @Column(name = "contenido_resumen")
    private String contenidoResumen;
    @Size(max = 2147483647)
    @Column(name = "contenido_explicacion")
    private String contenidoExplicacion;
    @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
    @ManyToOne(optional = false)
    private Grupo grupoId;

    public Contenido() {
    }

    public Contenido(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

    public Integer getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

    public String getContenidoTitulo() {
        return contenidoTitulo;
    }

    public void setContenidoTitulo(String contenidoTitulo) {
        this.contenidoTitulo = contenidoTitulo;
    }

    public String getContenidoTema() {
        return contenidoTema;
    }

    public void setContenidoTema(String contenidoTema) {
        this.contenidoTema = contenidoTema;
    }

    public String getContenidoIntroduccion() {
        return contenidoIntroduccion;
    }

    public void setContenidoIntroduccion(String contenidoIntroduccion) {
        this.contenidoIntroduccion = contenidoIntroduccion;
    }

    public String getContenidoResumen() {
        return contenidoResumen;
    }

    public void setContenidoResumen(String contenidoResumen) {
        this.contenidoResumen = contenidoResumen;
    }

    public String getContenidoExplicacion() {
        return contenidoExplicacion;
    }

    public void setContenidoExplicacion(String contenidoExplicacion) {
        this.contenidoExplicacion = contenidoExplicacion;
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
        hash += (contenidoId != null ? contenidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.contenidoId == null && other.contenidoId != null) || (this.contenidoId != null && !this.contenidoId.equals(other.contenidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Contenido[ contenidoId=" + contenidoId + " ]";
    }
    
}
