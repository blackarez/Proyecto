/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.sessionBean.GrupoFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioGrupoFacadeLocal;
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
public class GrupoBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private UsuarioGrupoFacadeLocal usuarioGrupoFacade;
    @EJB
    private GrupoFacadeLocal grupoFacade;

    String idGrupoSeleccionado;
    String idNuevoEstudiante;
    private List<Grupo> grupos;
    Grupo grupoSeleccionado;

    public GrupoBean() {
    }

    public Grupo getGrupoSeleccionado() {
        return grupoSeleccionado;
    }

    public void setGrupoSeleccionado(Grupo grupoSeleccionado) {
        this.grupoSeleccionado = grupoSeleccionado;
    }

    public List<Grupo> getGrupos() {
        grupos = grupoFacade.findAll();
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public String getIdGrupoSeleccionado() {
        return idGrupoSeleccionado;
    }

    public void setIdGrupoSeleccionado(String idGrupoSeleccionado) {
        this.idGrupoSeleccionado = idGrupoSeleccionado;
    }

    public String getIdNuevoEstudiante() {
        return idNuevoEstudiante;
    }

    public void setIdNuevoEstudiante(String idNuevoEstudiante) {
        this.idNuevoEstudiante = idNuevoEstudiante;
    }

    public String matricularNuevoEstudiante() {
        //verificar que no este matriculado en algun grupo.
        if (usuarioFacade.tieneGrupo(Integer.parseInt(idNuevoEstudiante)) == null) {//Si es =null no tiene grupo.
            if (usuarioGrupoFacade.matricularNuevoEstudiante(grupoSeleccionado, Integer.parseInt(idNuevoEstudiante)) != null
                    && usuarioFacade.cambiarRolAEstudiante(Integer.parseInt(idNuevoEstudiante)) != null) {
                //System.out.println("matriculado.....");
                return "../estudiante/inicio.xhtml?faces-redirect=true";//va al inicio de estudiante. pero puede hechar para atras.
            } else {
                return "consultarGrupo";
            }
        } else {
            
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            httpSession.removeAttribute("usuario");
            httpSession.invalidate();
            return "../index.xhtml?faces-redirect=true";
        }

    }

}
