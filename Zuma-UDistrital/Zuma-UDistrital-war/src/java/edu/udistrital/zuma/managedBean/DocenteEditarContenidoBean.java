/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.sessionBean.ContenidoFacadeLocal;
import edu.udistrital.zuma.sessionBean.GrupoFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class DocenteEditarContenidoBean {
    @EJB
    private ContenidoFacadeLocal contenidoFacade;
    @EJB
    private GrupoFacadeLocal grupoFacade;

    
    String id, titulo, tema, resumen, explicacion;
    String grupo;
    
    public DocenteEditarContenidoBean() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    
    public String editarContenido(){
        System.out.println("llamo al metodo");
        int idGrupo = grupoFacade.getIdPorNombre(grupo);
        int idContenido = Integer.parseInt(id);
        if(contenidoFacade.actualizarContenido(idContenido, titulo, tema, resumen, explicacion, idGrupo)!=null){
            System.out.println("entro al if");
            return "consultarContenidos";
        }else{
            return "editarContenido";
        }
    }
    
}
