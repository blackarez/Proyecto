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
@Table(name = "codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigo.findAll", query = "SELECT c FROM Codigo c"),
    @NamedQuery(name = "Codigo.findByCodigoId", query = "SELECT c FROM Codigo c WHERE c.codigoId = :codigoId"),
    @NamedQuery(name = "Codigo.findByCodigoNombre", query = "SELECT c FROM Codigo c WHERE c.codigoNombre = :codigoNombre"),
    @NamedQuery(name = "Codigo.findByCodigoDescripcion", query = "SELECT c FROM Codigo c WHERE c.codigoDescripcion = :codigoDescripcion"),
    @NamedQuery(name = "Codigo.findByCodigoRutaImagen", query = "SELECT c FROM Codigo c WHERE c.codigoRutaImagen = :codigoRutaImagen")})
public class Codigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_id")
    private Integer codigoId;
    @Size(max = 2147483647)
    @Column(name = "codigo_nombre")
    private String codigoNombre;
    @Size(max = 2147483647)
    @Column(name = "codigo_descripcion")
    private String codigoDescripcion;
    @Size(max = 2147483647)
    @Column(name = "codigo_ruta_imagen")
    private String codigoRutaImagen;
    @JoinColumn(name = "tipo_codigo_id", referencedColumnName = "tipo_codigo_id")
    @ManyToOne(optional = false)
    private TipoCodigo tipoCodigoId;
    @JoinColumn(name = "estado_codigo_id", referencedColumnName = "estado_codigo_id")
    @ManyToOne(optional = false)
    private EstadoCodigo estadoCodigoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoId")
    private List<LibroMagicoCodigo> libroMagicoCodigoList;

    public Codigo() {
    }

    public Codigo(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public String getCodigoNombre() {
        return codigoNombre;
    }

    public void setCodigoNombre(String codigoNombre) {
        this.codigoNombre = codigoNombre;
    }

    public String getCodigoDescripcion() {
        return codigoDescripcion;
    }

    public void setCodigoDescripcion(String codigoDescripcion) {
        this.codigoDescripcion = codigoDescripcion;
    }

    public String getCodigoRutaImagen() {
        return codigoRutaImagen;
    }

    public void setCodigoRutaImagen(String codigoRutaImagen) {
        this.codigoRutaImagen = codigoRutaImagen;
    }

    public TipoCodigo getTipoCodigoId() {
        return tipoCodigoId;
    }

    public void setTipoCodigoId(TipoCodigo tipoCodigoId) {
        this.tipoCodigoId = tipoCodigoId;
    }

    public EstadoCodigo getEstadoCodigoId() {
        return estadoCodigoId;
    }

    public void setEstadoCodigoId(EstadoCodigo estadoCodigoId) {
        this.estadoCodigoId = estadoCodigoId;
    }

    @XmlTransient
    public List<LibroMagicoCodigo> getLibroMagicoCodigoList() {
        return libroMagicoCodigoList;
    }

    public void setLibroMagicoCodigoList(List<LibroMagicoCodigo> libroMagicoCodigoList) {
        this.libroMagicoCodigoList = libroMagicoCodigoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoId != null ? codigoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigo)) {
            return false;
        }
        Codigo other = (Codigo) object;
        if ((this.codigoId == null && other.codigoId != null) || (this.codigoId != null && !this.codigoId.equals(other.codigoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Codigo[ codigoId=" + codigoId + " ]";
    }

}
