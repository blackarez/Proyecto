/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class EstudianteBean {

    /**
     * Creates a new instance of EstudianteBean
     */
    public EstudianteBean() {
    }
    
    public String verPerfil(){
        return "consultarPerfil";
    }
    
    public String editarPerfil(){
        return "editarPerfil";
    }
    
}
