/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.recursos.Cifrado;
import edu.udistrital.zuma.recursos.Correo;
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
public class RecordatorioClaveBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    String correoElectronico;
    String nuevaClave;
    String confirmacionClave;

    public RecordatorioClaveBean() {
    }

    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }

    
    
    public String recordarClave() {
        //validar si existe un usuario con ese correo.
        //si existe entocnes cogerlo y enviarle la clave.
        System.out.println("Llamo a la funcion...");
        if (Correo.validarCorreo(correoElectronico)) {
            System.out.println("el correo esta bien escrito.");
            Usuario usuarioOlvidon = usuarioFacade.login(correoElectronico);
            if (usuarioOlvidon != null) {
                System.out.println("el usuario existe.");
                String claveEncriptada = usuarioOlvidon.getUsuarioClave();
                String claveEnviar = Cifrado.desencriptar(claveEncriptada);
                String mensaje="Hola "+usuarioOlvidon.getUsuarioNombre()+", Ha solicitado recordar la clave de acceso a Zuma. Su clave es :"+claveEnviar;
                Correo.enviarCorreo(mensaje,"jfredypuentes@gmailcom",usuarioOlvidon.getUsuarioCorreo(),"Clave de Acceso A Zuma");
                return "index?faces-redirect=true";
            } else {
                return "registro?faces-redirect=true";
            }
        } else {
            correoElectronico = null;
            return "recordarClave?faces-redirect=true";
        }

    }
    
    public String cambiarClave(){
        if(nuevaClave.equals(confirmacionClave)){
            String claveCifrada = Cifrado.encriptar(nuevaClave);
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Usuario usuarioEditar = (Usuario) httpSession.getAttribute("usuario");
            usuarioEditar.setUsuarioClave(claveCifrada);
            usuarioFacade.edit(usuarioEditar);  
            return "inicio?faces-redirect=true";
        }else{
            return "editarClave?faces-redirect=true";
        }
    }

}
