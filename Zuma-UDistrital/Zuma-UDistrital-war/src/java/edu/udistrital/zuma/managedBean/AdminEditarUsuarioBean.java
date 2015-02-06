/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.recursos.Correo;
import edu.udistrital.zuma.sessionBean.EstadoUsuarioFacadeLocal;
import edu.udistrital.zuma.sessionBean.RolFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class AdminEditarUsuarioBean {
    @EJB
    private RolFacadeLocal rolFacade;
    @EJB
    private EstadoUsuarioFacadeLocal estadoUsuarioFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    
    
    String idUsuario;
    String nombre;
    String apellido;
    String correo;
    String estado;
    String rol;
    List<String> listaEstadosUsuarios;
    List<String> listaRolesUsuarios;
    String idUsuarioEliminar;

    public AdminEditarUsuarioBean() {
    }

    public String redireccionEditarUsuario() {
        return "editarUsuario";
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<String> getListaEstadosUsuarios() {
        listaEstadosUsuarios = estadoUsuarioFacade.buscarEstadosUsuarios();
        return listaEstadosUsuarios;
    }

    public void setListaEstadosUsuarios(List<String> listaEstadosUsuarios) {
        this.listaEstadosUsuarios = listaEstadosUsuarios;
    }

    public List<String> getListaRolesUsuarios() {
        listaRolesUsuarios = rolFacade.buscarNombreRoles();
        return listaRolesUsuarios;
    }

    public void setListaRolesUsuarios(List<String> listaRolesUsuarios) {
        this.listaRolesUsuarios = listaRolesUsuarios;
    }

    public String getIdUsuarioEliminar() {
        return idUsuarioEliminar;
    }

    public void setIdUsuarioEliminar(String idUsuarioEliminar) {
        this.idUsuarioEliminar = idUsuarioEliminar;
    }

    
    
    public String editarUsuario() {
        try {
            if (Correo.validarCorreo(correo)) {//validar formato correo
                int idEstado = estadoUsuarioFacade.obtenerIdEstadoUsuarioPorEstado(estado);
                int idRol = rolFacade.obtenerIdRolPorNombre(rol);
                usuarioFacade.actualizarUsuario(idUsuario, nombre, apellido, correo,idEstado,idRol);
                //Mostrar: El usuario se edito correctamente.
                return "consultarUsuarios";
            } else {
                //Mostrar: Correo no cumple el formato.
                return "editarUsuario";
            }

        } catch (Exception e) {
            return "consultarUsuarios";
        }
    }

    
    public String eliminarUsuario(){
        System.out.println("IdUsuario eliminar -> "+idUsuarioEliminar);
        return "inicio";
    }
}
