/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Rol;
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
public class AdminConsultarRolBean {
    @EJB
    private RolFacadeLocal rolFacade;

    
    
    List<Rol> listaRoles;
    List<Rol> listaRolesFiltrados;
    
    public AdminConsultarRolBean() {
    }
    
    public String consultarRoles(){
        return "consultarRol";
    }

    public List<Rol> getListaRoles() {
        listaRoles = rolFacade.findAll();
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<Rol> getListaRolesFiltrados() {
        return listaRolesFiltrados;
    }

    public void setListaRolesFiltrados(List<Rol> listaRolesFiltrados) {
        this.listaRolesFiltrados = listaRolesFiltrados;
    }
    
}
