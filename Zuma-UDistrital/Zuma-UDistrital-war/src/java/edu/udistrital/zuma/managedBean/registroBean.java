/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.recursos.Cifrado;
import edu.udistrital.zuma.recursos.Correo;
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
public class registroBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    String nombre, apellido, correo, clave;
    int rolInvitado = 4;
    int estadoUsuario = 1;
    String redireccionLogin="index?faces-redirect=true";
    String irARegistro = "registro?faces-redirect=true";

    public registroBean() {
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

    public String registrarse() {
        if (Correo.validarCorreo(correo)) {//correo valido
            if (usuarioFacade.login(correo) == null) { //correo valido
                clave = (new Correo()).generarClave(6);
                boolean envioCorreo = Correo.enviarCorreo("Hola " + nombre + ", Su clave de acceso a la plataforma Zuma es : " + clave, "zuma.soporte@gmail.com", correo, "Clave acceso Zuma");
                if (envioCorreo) {//si envió el correo entocnes, 
                    if (usuarioFacade.registrarUsuarioInvitado(nombre, apellido, correo, Cifrado.encriptar(clave), rolInvitado, estadoUsuario) != null) {
                        nombre = null;
                        apellido = null;
                        correo = null;
                        return irALogin();
                    }else{
                        System.out.println("no pudo registrar al usuari.");
                        return irARegistro;
                    }
                } else {
                    System.out.println("no envio correo.");
                    correo = null;
                    return irARegistro;
                }
            } else {
                System.out.println("correo ya existe.");
                correo = null;
                return irARegistro;
            }
        } else {
            System.out.println("correo no valido por patron.");
            correo = null;
            return irARegistro;
        }
    }

    public String irALogin() {
        return redireccionLogin;
    }

}
