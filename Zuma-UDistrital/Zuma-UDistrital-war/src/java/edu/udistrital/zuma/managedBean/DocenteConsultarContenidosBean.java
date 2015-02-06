/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Contenido;
import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.sessionBean.ContenidoFacadeLocal;
import edu.udistrital.zuma.sessionBean.GrupoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhon
 */
@ManagedBean
@ViewScoped
public class DocenteConsultarContenidosBean {
    @EJB
    private ContenidoFacadeLocal contenidoFacade;

    @EJB
    private GrupoFacadeLocal grupoFacade;

    List<Contenido> listaContenidos;
    List<Contenido> listaContenidosFiltrados;
    List<String> grupoDeDocente;
    
    String grupo;
    
    public DocenteConsultarContenidosBean() {
    }

    public List<Contenido> getListaContenidos() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        int idUsuario = Integer.parseInt(usuario.getUsuarioId().toString());
        listaContenidos = contenidoFacade.listaContenidosPorDocente(idUsuario);
        //listaContenidos = contenidoFacade.findAll();
        return listaContenidos;
    }

    public void setListaContenidos(List<Contenido> listaContenidos) {
        this.listaContenidos = listaContenidos;
    }

    public List<Contenido> getListaContenidosFiltrados() {
        return listaContenidosFiltrados;
    }

    public void setListaContenidosFiltrados(List<Contenido> listaContenidosFiltrados) {
        this.listaContenidosFiltrados = listaContenidosFiltrados;
    }

    public List<String> getGrupoDeDocente() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        int idUsuario = usuario.getUsuarioId();
        grupoDeDocente = grupoFacade.listaDeNombresGruposPorDocente(idUsuario);
        return grupoDeDocente;
    }

    public void setGrupoDeDocente(List<String> grupoDeDocente) {
        this.grupoDeDocente = grupoDeDocente;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
