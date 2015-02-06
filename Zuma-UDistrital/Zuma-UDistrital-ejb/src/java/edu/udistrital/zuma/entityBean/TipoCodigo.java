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
@Table(name = "tipo_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCodigo.findAll", query = "SELECT t FROM TipoCodigo t"),
    @NamedQuery(name = "TipoCodigo.findByTipoCodigoId", query = "SELECT t FROM TipoCodigo t WHERE t.tipoCodigoId = :tipoCodigoId"),
    @NamedQuery(name = "TipoCodigo.findByTipoCodigoTipo", query = "SELECT t FROM TipoCodigo t WHERE t.tipoCodigoTipo = :tipoCodigoTipo"),
    @NamedQuery(name = "TipoCodigo.findByTipoCodigoDescripcion", query = "SELECT t FROM TipoCodigo t WHERE t.tipoCodigoDescripcion = :tipoCodigoDescripcion")})
public class TipoCodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_codigo_id")
    private Integer tipoCodigoId;
    @Size(max = 2147483647)
    @Column(name = "tipo_codigo_tipo")
    private String tipoCodigoTipo;
    @Size(max = 2147483647)
    @Column(name = "tipo_codigo_descripcion")
    private String tipoCodigoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCodigoId")
    private List<Codigo> codigoList;

    public TipoCodigo() {
    }

    public TipoCodigo(Integer tipoCodigoId) {
        this.tipoCodigoId = tipoCodigoId;
    }

    public Integer getTipoCodigoId() {
        return tipoCodigoId;
    }

    public void setTipoCodigoId(Integer tipoCodigoId) {
        this.tipoCodigoId = tipoCodigoId;
    }

    public String getTipoCodigoTipo() {
        return tipoCodigoTipo;
    }

    public void setTipoCodigoTipo(String tipoCodigoTipo) {
        this.tipoCodigoTipo = tipoCodigoTipo;
    }

    public String getTipoCodigoDescripcion() {
        return tipoCodigoDescripcion;
    }

    public void setTipoCodigoDescripcion(String tipoCodigoDescripcion) {
        this.tipoCodigoDescripcion = tipoCodigoDescripcion;
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
        hash += (tipoCodigoId != null ? tipoCodigoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCodigo)) {
            return false;
        }
        TipoCodigo other = (TipoCodigo) object;
        if ((this.tipoCodigoId == null && other.tipoCodigoId != null) || (this.tipoCodigoId != null && !this.tipoCodigoId.equals(other.tipoCodigoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.TipoCodigo[ tipoCodigoId=" + tipoCodigoId + " ]";
    }
    
}
