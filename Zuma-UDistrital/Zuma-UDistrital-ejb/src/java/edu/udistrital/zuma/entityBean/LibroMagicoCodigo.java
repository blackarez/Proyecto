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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "libro_magico_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroMagicoCodigo.findAll", query = "SELECT l FROM LibroMagicoCodigo l"),
    @NamedQuery(name = "LibroMagicoCodigo.findByLibroMagicoCodigoId", query = "SELECT l FROM LibroMagicoCodigo l WHERE l.libroMagicoCodigoId = :libroMagicoCodigoId")})
public class LibroMagicoCodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "libro_magico_codigo_id")
    private Integer libroMagicoCodigoId;
    @JoinColumn(name = "libro_magico_id", referencedColumnName = "libro_magico_id")
    @ManyToOne(optional = false)
    private LibroMagico libroMagicoId;
    @JoinColumn(name = "codigo_id", referencedColumnName = "codigo_id")
    @ManyToOne(optional = false)
    private Codigo codigoId;

    public LibroMagicoCodigo() {
    }

    public LibroMagicoCodigo(Integer libroMagicoCodigoId) {
        this.libroMagicoCodigoId = libroMagicoCodigoId;
    }

    public Integer getLibroMagicoCodigoId() {
        return libroMagicoCodigoId;
    }

    public void setLibroMagicoCodigoId(Integer libroMagicoCodigoId) {
        this.libroMagicoCodigoId = libroMagicoCodigoId;
    }

    public LibroMagico getLibroMagicoId() {
        return libroMagicoId;
    }

    public void setLibroMagicoId(LibroMagico libroMagicoId) {
        this.libroMagicoId = libroMagicoId;
    }

    public Codigo getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Codigo codigoId) {
        this.codigoId = codigoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroMagicoCodigoId != null ? libroMagicoCodigoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroMagicoCodigo)) {
            return false;
        }
        LibroMagicoCodigo other = (LibroMagicoCodigo) object;
        if ((this.libroMagicoCodigoId == null && other.libroMagicoCodigoId != null) || (this.libroMagicoCodigoId != null && !this.libroMagicoCodigoId.equals(other.libroMagicoCodigoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.LibroMagicoCodigo[ libroMagicoCodigoId=" + libroMagicoCodigoId + " ]";
    }
    
}
