/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Login;
import edu.udistrital.zuma.entityBean.Rol;
import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.recursos.Cifrado;
import edu.udistrital.zuma.sessionBean.LoginFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
public class LoginBean {

    @EJB
    private LoginFacadeLocal loginFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    String usuario, clave, fechaHoy, ultimoIngreso;
    Usuario usuarioActual;
    boolean usuarioLogueado;
    String paginaLogin = "index";
    String paginaConsultaPerfil ="consultarPerfil";
    String paginaConsultaGrupo = "consultarGrupo";
    String redireccionLogin = "../index.xhtml?faces-redirect=true";
    String paginaRegistro = "registro?faces-redirect=true";
    String paginaRecordarClave = "recordarClave?faces-redirect=true";
    String redireccionPaginaAdmin = "administrador/inicio?faces-redirect=true";
    String redireccionPaginaDocente = "docente/inicio?faces-redirect=true";
    String redireccionPaginaInvitado = "invitado/inicio?faces-redirect=true";
    String redireccionPaginaEstudiante ="estudiante/inicio?faces-redirect=true";
    
    public LoginBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public String getPaginaRegistro() {
        return paginaRegistro;
    }

    public void setPaginaRegistro(String paginaRegistro) {
        this.paginaRegistro = paginaRegistro;
    }

    public boolean isUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(boolean usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getFechaHoy() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        fechaHoy = dateFormat.format(date);
        return fechaHoy;
    }

    public void setFechaHoy(String fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public String getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(String ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getPaginaLogin() {
        return paginaLogin;
    }

    public void setPaginaLogin(String paginaLogin) {
        this.paginaLogin = paginaLogin;
    }

    public String getPaginaConsultaPerfil() {
        return paginaConsultaPerfil;
    }

    public void setPaginaConsultaPerfil(String paginaConsultaPerfil) {
        this.paginaConsultaPerfil = paginaConsultaPerfil;
    }

    public String getPaginaConsultaGrupo() {
        return paginaConsultaGrupo;
    }

    public void setPaginaConsultaGrupo(String paginaConsultaGrupo) {
        this.paginaConsultaGrupo = paginaConsultaGrupo;
    }

    public String getRedireccionPaginaAdmin() {
        return redireccionPaginaAdmin;
    }

    public void setRedireccionPaginaAdmin(String redireccionPaginaAdmin) {
        this.redireccionPaginaAdmin = redireccionPaginaAdmin;
    }

    public String getRedireccionPaginaDocente() {
        return redireccionPaginaDocente;
    }

    public void setRedireccionPaginaDocente(String redireccionPaginaDocente) {
        this.redireccionPaginaDocente = redireccionPaginaDocente;
    }

    public String getRedireccionPaginaInvitado() {
        return redireccionPaginaInvitado;
    }

    public void setRedireccionPaginaInvitado(String redireccionPaginaInvitado) {
        this.redireccionPaginaInvitado = redireccionPaginaInvitado;
    }

    public String getRedireccionPaginaEstudiante() {
        return redireccionPaginaEstudiante;
    }

    public void setRedireccionPaginaEstudiante(String redireccionPaginaEstudiante) {
        this.redireccionPaginaEstudiante = redireccionPaginaEstudiante;
    }

    
    
    public String ingresar() {
        usuarioActual = usuarioFacade.login(usuario);

        if (usuarioActual != null) {
            if (usuarioActual.getUsuarioClave().equals(Cifrado.encriptar(clave))) {
                usuarioLogueado = true;
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", usuarioActual);

                Login login = loginFacade.consultarLoginPorUsuario(usuarioActual);
                if (login != null) {
                    ultimoIngreso = login.getLoginUltimoIngreso().toString();
                    loginFacade.actualizarFechaIngresoPorUsuario(usuarioActual, new Date());
                } else {
                    loginFacade.registrarLoginPorUsuario(usuarioActual, new Date());
                    Login nuevoLogin = loginFacade.consultarLoginPorUsuario(usuarioActual);
                    if (nuevoLogin != null) {
                        ultimoIngreso = nuevoLogin.getLoginUltimoIngreso().toString();
                    }
                }
                return obtenerPaginaPorRol();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Clave incorrecta."));
                return paginaLogin;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario no existe."));
            return paginaLogin;
        }

    }

    public String cerrarSesion() {
        usuario = null;
        clave = null;
        usuarioLogueado = false;
        usuarioActual=null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.removeAttribute("usuario");
        httpSession.invalidate();
        return redireccionLogin;
    }

    private String obtenerPaginaPorRol() {
        Rol rolDeUsuario = usuarioActual.getRolId();
        String nombreRol = rolDeUsuario.getRolNombre();

        if (nombreRol.equals("administrador")) {
            return redireccionPaginaAdmin;
        }
        if (nombreRol.equals("docente")) {
            return redireccionPaginaDocente;
        }
        if (nombreRol.equals("invitado")) {
            return redireccionPaginaInvitado;
        }
        if (nombreRol.equals("estudiante")) {
            return redireccionPaginaEstudiante;
        }
        return paginaLogin;
    }

    public String irARegistro() {
        return paginaRegistro;
    }
    
    public String irARecordarClave(){
        return paginaRecordarClave;
    }
    
    public String irConsultaPerfil(){
        return paginaConsultaPerfil;
    }
    
    public String irConsultaGrupo(){
        return paginaConsultaGrupo;
    }

    public String editarPerfil() {
        try {
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Usuario usuarioEditar = (Usuario) httpSession.getAttribute("usuario");
            usuarioFacade.edit(usuarioEditar);
            return "inicio";
        } catch (Exception e) {
            return "inicio";
        }
    }

}
