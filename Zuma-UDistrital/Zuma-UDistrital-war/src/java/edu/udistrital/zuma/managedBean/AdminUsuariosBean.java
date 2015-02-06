/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.sessionBean.EstadoUsuarioFacadeLocal;
import edu.udistrital.zuma.sessionBean.RolFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@ViewScoped
public class AdminUsuariosBean {

    @EJB
    private RolFacadeLocal rolFacade;
    @EJB
    private EstadoUsuarioFacadeLocal estadoUsuarioFacade;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    List<Usuario> usuarios;
    List<Usuario> usuariosFiltrados;
    List<String> estadosUsuario;
    List<String> rolesUsuario;

    public AdminUsuariosBean() {
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioFacade.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuariosFiltrados() {
        return usuariosFiltrados;
    }

    public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
        this.usuariosFiltrados = usuariosFiltrados;
    }

    public EstadoUsuarioFacadeLocal getEstadoUsuarioFacade() {
        return estadoUsuarioFacade;
    }

    public void setEstadoUsuarioFacade(EstadoUsuarioFacadeLocal estadoUsuarioFacade) {
        this.estadoUsuarioFacade = estadoUsuarioFacade;
    }

    public List<String> getEstadosUsuario() {
        estadosUsuario = estadoUsuarioFacade.buscarEstadosUsuarios();
        return estadosUsuario;
    }

    public void setEstadosUsuario(List<String> esatdosUsuario) {
        this.estadosUsuario = esatdosUsuario;
    }

    public List<String> getRolesUsuario() {
        rolesUsuario = rolFacade.buscarNombreRoles();
        return rolesUsuario;
    }

    public void setRolesUsuario(List<String> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }

    public String editarUsuario() {
        return "editarUsuario";
    }


}
