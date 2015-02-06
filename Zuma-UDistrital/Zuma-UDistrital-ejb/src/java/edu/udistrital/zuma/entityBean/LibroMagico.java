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
@Table(name = "libro_magico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroMagico.findAll", query = "SELECT l FROM LibroMagico l"),
    @NamedQuery(name = "LibroMagico.findByLibroMagicoId", query = "SELECT l FROM LibroMagico l WHERE l.libroMagicoId = :libroMagicoId"),
    @NamedQuery(name = "LibroMagico.findByLibroMagicoTitulo", query = "SELECT l FROM LibroMagico l WHERE l.libroMagicoTitulo = :libroMagicoTitulo"),
    @NamedQuery(name = "LibroMagico.findByLibroMagicoDescripcion", query = "SELECT l FROM LibroMagico l WHERE l.libroMagicoDescripcion = :libroMagicoDescripcion"),
    @NamedQuery(name = "LibroMagico.findByLibroMagicoIntroduccion", query = "SELECT l FROM LibroMagico l WHERE l.libroMagicoIntroduccion = :libroMagicoIntroduccion"),
    @NamedQuery(name = "LibroMagico.findByLibroMagicoContenido", query = "SELECT l FROM LibroMagico l WHERE l.libroMagicoContenido = :libroMagicoContenido")})
public class LibroMagico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "libro_magico_id")
    private Integer libroMagicoId;
    @Size(max = 2147483647)
    @Column(name = "libro_magico_titulo")
    private String libroMagicoTitulo;
    @Size(max = 2147483647)
    @Column(name = "libro_magico_descripcion")
    private String libroMagicoDescripcion;
    @Size(max = 2147483647)
    @Column(name = "libro_magico_introduccion")
    private String libroMagicoIntroduccion;
    @Size(max = 2147483647)
    @Column(name = "libro_magico_contenido")
    private String libroMagicoContenido;
    @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
    @ManyToOne(optional = false)
    private Grupo grupoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroMagicoId")
    private List<LibroMagicoCodigo> libroMagicoCodigoList;

    public LibroMagico() {
    }

    public LibroMagico(Integer libroMagicoId) {
        this.libroMagicoId = libroMagicoId;
    }

    public Integer getLibroMagicoId() {
        return libroMagicoId;
    }

    public void setLibroMagicoId(Integer libroMagicoId) {
        this.libroMagicoId = libroMagicoId;
    }

    public String getLibroMagicoTitulo() {
        return libroMagicoTitulo;
    }

    public void setLibroMagicoTitulo(String libroMagicoTitulo) {
        this.libroMagicoTitulo = libroMagicoTitulo;
    }

    public String getLibroMagicoDescripcion() {
        return libroMagicoDescripcion;
    }

    public void setLibroMagicoDescripcion(String libroMagicoDescripcion) {
        this.libroMagicoDescripcion = libroMagicoDescripcion;
    }

    public String getLibroMagicoIntroduccion() {
        return libroMagicoIntroduccion;
    }

    public void setLibroMagicoIntroduccion(String libroMagicoIntroduccion) {
        this.libroMagicoIntroduccion = libroMagicoIntroduccion;
    }

    public String getLibroMagicoContenido() {
        return libroMagicoContenido;
    }

    public void setLibroMagicoContenido(String libroMagicoContenido) {
        this.libroMagicoContenido = libroMagicoContenido;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
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
        hash += (libroMagicoId != null ? libroMagicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroMagico)) {
            return false;
        }
        LibroMagico other = (LibroMagico) object;
        if ((this.libroMagicoId == null && other.libroMagicoId != null) || (this.libroMagicoId != null && !this.libroMagicoId.equals(other.libroMagicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.LibroMagico[ libroMagicoId=" + libroMagicoId + " ]";
    }
    
}
