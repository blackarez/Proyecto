/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

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
public class AdminElimianrUsuarioBean {
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    String idUsuario, nombre, apellido, correo, estado, rol;
    
    
    public AdminElimianrUsuarioBean() {
    }

    public String redireccionEliminarUsuario(){
        return "eliminarUsuario";
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
    
    public String eliminarUsuario(){
        if(usuarioFacade.eliminarUsuarioPorId(Integer.parseInt(idUsuario))){
            return "consultarUsuarios";
        }else{
            //avisar que no se puedo eliminar el usuario.
            return "consultar";
        }
    }
    
}
