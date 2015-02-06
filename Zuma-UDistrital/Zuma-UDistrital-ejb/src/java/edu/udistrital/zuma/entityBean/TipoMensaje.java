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
@Table(name = "tipo_mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMensaje.findAll", query = "SELECT t FROM TipoMensaje t"),
    @NamedQuery(name = "TipoMensaje.findByTipoMensajeId", query = "SELECT t FROM TipoMensaje t WHERE t.tipoMensajeId = :tipoMensajeId"),
    @NamedQuery(name = "TipoMensaje.findByTipoMensajeTipo", query = "SELECT t FROM TipoMensaje t WHERE t.tipoMensajeTipo = :tipoMensajeTipo"),
    @NamedQuery(name = "TipoMensaje.findByTipoMensajeDescripcion", query = "SELECT t FROM TipoMensaje t WHERE t.tipoMensajeDescripcion = :tipoMensajeDescripcion")})
public class TipoMensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_mensaje_id")
    private Integer tipoMensajeId;
    @Size(max = 2147483647)
    @Column(name = "tipo_mensaje_tipo")
    private String tipoMensajeTipo;
    @Size(max = 2147483647)
    @Column(name = "tipo_mensaje_descripcion")
    private String tipoMensajeDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMensajeId")
    private List<Mensaje> mensajeList;

    public TipoMensaje() {
    }

    public TipoMensaje(Integer tipoMensajeId) {
        this.tipoMensajeId = tipoMensajeId;
    }

    public Integer getTipoMensajeId() {
        return tipoMensajeId;
    }

    public void setTipoMensajeId(Integer tipoMensajeId) {
        this.tipoMensajeId = tipoMensajeId;
    }

    public String getTipoMensajeTipo() {
        return tipoMensajeTipo;
    }

    public void setTipoMensajeTipo(String tipoMensajeTipo) {
        this.tipoMensajeTipo = tipoMensajeTipo;
    }

    public String getTipoMensajeDescripcion() {
        return tipoMensajeDescripcion;
    }

    public void setTipoMensajeDescripcion(String tipoMensajeDescripcion) {
        this.tipoMensajeDescripcion = tipoMensajeDescripcion;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoMensajeId != null ? tipoMensajeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMensaje)) {
            return false;
        }
        TipoMensaje other = (TipoMensaje) object;
        if ((this.tipoMensajeId == null && other.tipoMensajeId != null) || (this.tipoMensajeId != null && !this.tipoMensajeId.equals(other.tipoMensajeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.TipoMensaje[ tipoMensajeId=" + tipoMensajeId + " ]";
    }
    
}
