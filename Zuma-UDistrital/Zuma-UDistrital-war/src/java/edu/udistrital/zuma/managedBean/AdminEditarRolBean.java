/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.sessionBean.RolFacadeLocal;
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
public class AdminEditarRolBean {

    @EJB
    private RolFacadeLocal rolFacade;

    String id;
    String nombreRol;
    String descripcion;
    List<String> listaRoles;

    public AdminEditarRolBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getListaRoles() {
        listaRoles = rolFacade.getListaRoles();
        return listaRoles;
    }

    public void setListaRoles(List<String> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public String guardarRol() {
        try {
            int idRol = Integer.parseInt(id);
            if(rolFacade.actualizarRol(idRol, nombreRol, descripcion)!=null){
                return "consultarRol";
            }else{
                return "editarRol";
            }
        } catch (Exception e) {
            return "editarRol";
        }
    }

}
