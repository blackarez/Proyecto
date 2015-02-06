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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByLoginId", query = "SELECT l FROM Login l WHERE l.loginId = :loginId"),
    @NamedQuery(name = "Login.findByLoginUltimoIngreso", query = "SELECT l FROM Login l WHERE l.loginUltimoIngreso = :loginUltimoIngreso"),
    @NamedQuery(name = "Login.findByLoginNumeroIngresos", query = "SELECT l FROM Login l WHERE l.loginNumeroIngresos = :loginNumeroIngresos")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_id")
    private Integer loginId;
    @Column(name = "login_ultimo_ingreso")
    @Temporal(TemporalType.DATE)
    private Date loginUltimoIngreso;
    @Column(name = "login_numero_ingresos")
    private Integer loginNumeroIngresos;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Login() {
    }

    public Login(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Date getLoginUltimoIngreso() {
        return loginUltimoIngreso;
    }

    public void setLoginUltimoIngreso(Date loginUltimoIngreso) {
        this.loginUltimoIngreso = loginUltimoIngreso;
    }

    public Integer getLoginNumeroIngresos() {
        return loginNumeroIngresos;
    }

    public void setLoginNumeroIngresos(Integer loginNumeroIngresos) {
        this.loginNumeroIngresos = loginNumeroIngresos;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.udistrital.zuma.entityBean.Login[ loginId=" + loginId + " ]";
    }
    
}
