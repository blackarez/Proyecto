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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class InvitadoPerfilBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    public InvitadoPerfilBean() {
    }

    String nombre, apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String editarPerfil() {
        try {
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
            usuarioFacade.edit(usuario);
            return "inicio";
        } catch (Exception e) {
            System.out.println("no pudo editar");
            return "inicio";
        }
    }

}
