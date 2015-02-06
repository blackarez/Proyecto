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
@Table(name = "estado_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCodigo.findAll", query = "SELECT e FROM EstadoCodigo e"),
    @NamedQuery(name = "EstadoCodigo.findByEstadoCodigoId", query = "SELECT e FROM EstadoCodigo e WHERE e.estadoCodigoId = :estadoCodigoId"),
    @NamedQuery(name = "EstadoCodigo.findByEstadoCodigoEstado", query = "SELECT e FROM EstadoCodigo e WHERE e.estadoCodigoEstado = :estadoCodigoEstado"),
    @NamedQuery(name = "EstadoCodigo.findByEstadoCodigoDescripcion", query = "SELECT e FROM EstadoCodigo e WHERE e.estadoCodigoDescripcion = :estadoCodigoDescripcion")})
public class EstadoCodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estado_codigo_id")
    private Integer estadoCodigoId;
    @Size(max = 2147483647)
    @Column(name = "estado_codigo_estado")
    private String estadoCodigoEstado;
    @Size(max = 2147483647)
    @Column(name = "estado_codigo_descripcion")
    private String estadoCodigoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCodigoId")
    private List<Codigo> codigoList;

    public EstadoCodigo() {
    }

    public EstadoCodigo(Integer estadoCodigoId) {
        this.estadoCodigoId = estadoCodigoId;
    }

    public Integer getEstadoCodigoId() {
        return estadoCodigoId;
    }

    public void setEstadoCodigoId(Integer estadoCodigoId) {
        this.estadoCodigoId = estadoCodigoId;
    }

    public String getEstadoCodigoEstado() {
        return estadoCodigoEstado;
    }

    public void setEstadoCodigoEstado(String estadoCodigoEstado) {
        this.estadoCodigoEstado = estadoCodigoEstado;
    }

    public String getEstadoCodigoDescripcion() {
        return estadoCodigoDescripcion;
    }

    public void setEstadoCodigoDescripcion(String estadoCodigoDescripcion) {
        this.estadoCodigoDescripcion = estadoCodigoDescripcion;
    }

    @XmlTransient
    public List<Codigo> getCodigoList() {
        return codigoList;
    }

    public void setCodigoList(List<Codigo> codigoList) {
        this.codigoList = codigoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoCodigoId != null ? estadoCodigoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCodigo)) {
            return false;
        }
        EstadoCodigo other = (EstadoCodigo) object;
        if ((this.estadoCodigoId == null && other.estadoCodigoId != null) || (this.estadoCodigoId != null && !this.estadoCodigoId.equals(other.estadoCodigoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.EstadoCodigo[ estadoCodigoId=" + estadoCodigoId + " ]";
    }
    
}
