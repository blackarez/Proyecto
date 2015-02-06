/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.sessionBean.CodigoFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class AdminEliminarCodigoBean {
    @EJB
    private CodigoFacadeLocal codigoFacade;

    String id;
    String nombre;
    String descripcion;
    String tipo;
    String estado;
    
    public AdminEliminarCodigoBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String eliminarCodigo(){
        boolean elimino = codigoFacade.eliminarCodigoPorId(Integer.parseInt(id));
        if(elimino){
            //avisar que se elimino..
            return "consultarCodigos";
        }else{
            //avisar que no se elimino.
            return "consultarCodigos";
        }
    }
    
}
