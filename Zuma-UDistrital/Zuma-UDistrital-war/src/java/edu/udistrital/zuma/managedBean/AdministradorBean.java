/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class AdministradorBean {
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    Usuario usuarioModificar;
    String correoSelccionado;
    
    
    
    public AdministradorBean() {
    }
    
    public String consultarPerfil(){
        return "consultarPerfil";
    }
    
    public String editarPerfil(){
        return "editarPerfil";
    }
    
    public String editarClave(){
        return "editarClave?faces-redirect=true";
    }
    
    public String consultarUsuarios(){
        return "consultarUsuarios";
    }

    public Usuario getUsuarioModificar() {
        usuarioModificar = usuarioFacade.login(correoSelccionado);
        return usuarioModificar;
    }

    public void setUsuarioModificar(Usuario usuarioModificar) {
        this.usuarioModificar = usuarioModificar;
    }

    public String getCorreoSelccionado() {
        return correoSelccionado;
    }

    public void setCorreoSelccionado(String correoSelccionado) {
        this.correoSelccionado = correoSelccionado;
    }
    
    public String editarUsuario(){
        System.out.println("nnombre nuevo: "+usuarioModificar.getUsuarioNombre());
        usuarioFacade.edit(usuarioModificar);
        return "consultarUsuarios";
    }
    
}
