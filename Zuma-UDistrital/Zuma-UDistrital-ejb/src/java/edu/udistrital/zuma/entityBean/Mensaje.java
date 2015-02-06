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
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByMensajeId", query = "SELECT m FROM Mensaje m WHERE m.mensajeId = :mensajeId"),
    @NamedQuery(name = "Mensaje.findByMensajeContacto", query = "SELECT m FROM Mensaje m WHERE m.mensajeContacto = :mensajeContacto"),
    @NamedQuery(name = "Mensaje.findByMensajeContenido", query = "SELECT m FROM Mensaje m WHERE m.mensajeContenido = :mensajeContenido"),
    @NamedQuery(name = "Mensaje.findByMensajeAsunto", query = "SELECT m FROM Mensaje m WHERE m.mensajeAsunto = :mensajeAsunto")})
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mensaje_id")
    private Integer mensajeId;
    @Size(max = 2147483647)
    @Column(name = "mensaje_contacto")
    private String mensajeContacto;
    @Size(max = 2147483647)
    @Column(name = "mensaje_contenido")
    private String mensajeContenido;
    @Size(max = 2147483647)
    @Column(name = "mensaje_asunto")
    private String mensajeAsunto;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "tipo_mensaje_id", referencedColumnName = "tipo_mensaje_id")
    @ManyToOne(optional = false)
    private TipoMensaje tipoMensajeId;

    public Mensaje() {
    }

    public Mensaje(Integer mensajeId) {
        this.mensajeId = mensajeId;
    }

    public Integer getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Integer mensajeId) {
        this.mensajeId = mensajeId;
    }

    public String getMensajeContacto() {
        return mensajeContacto;
    }

    public void setMensajeContacto(String mensajeContacto) {
        this.mensajeContacto = mensajeContacto;
    }

    public String getMensajeContenido() {
        return mensajeContenido;
    }

    public void setMensajeContenido(String mensajeContenido) {
        this.mensajeContenido = mensajeContenido;
    }

    public String getMensajeAsunto() {
        return mensajeAsunto;
    }

    public void setMensajeAsunto(String mensajeAsunto) {
        this.mensajeAsunto = mensajeAsunto;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TipoMensaje getTipoMensajeId() {
        return tipoMensajeId;
    }

    public void setTipoMensajeId(TipoMensaje tipoMensajeId) {
        this.tipoMensajeId = tipoMensajeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajeId != null ? mensajeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.mensajeId == null && other.mensajeId != null) || (this.mensajeId != null && !this.mensajeId.equals(other.mensajeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Mensaje[ mensajeId=" + mensajeId + " ]";
    }
    
}
