/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Codigo;
import edu.udistrital.zuma.sessionBean.CodigoFacadeLocal;
import edu.udistrital.zuma.sessionBean.TipoCodigoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@ViewScoped
public class AdminCodigosBean {
    @EJB
    private TipoCodigoFacadeLocal tipoCodigoFacade;
    @EJB
    private CodigoFacadeLocal codigoFacade;

    List<Codigo> listaCodigosQR;
    List<Codigo> listaCodigosQRFiltrados;
    List<String> listaTiposCodigos;
    
    public AdminCodigosBean() {
    }

    public List<Codigo> getListaCodigosQR() {
        listaCodigosQR = codigoFacade.findAll();
        return listaCodigosQR;
    }

    public void setListaCodigosQR(List<Codigo> listaCodigosQR) {
        this.listaCodigosQR = listaCodigosQR;
    }

    public List<Codigo> getListaCodigosQRFiltrados() {
        return listaCodigosQRFiltrados;
    }

    public void setListaCodigosQRFiltrados(List<Codigo> listaCodigosQRFiltrados) {
        this.listaCodigosQRFiltrados = listaCodigosQRFiltrados;
    }

    public List<String> getListaTiposCodigos() {
        listaTiposCodigos = tipoCodigoFacade.obtenerListaTiposCodigo();
        return listaTiposCodigos;
    }

    public void setListaTiposCodigos(List<String> listaTiposCodigos) {
        this.listaTiposCodigos = listaTiposCodigos;
    }
    
    public String consultarCodigos(){
        return "consultarCodigos";
    }
    
    public String redireccionarEditarCodigo(){
        return "editarCodigoQR";
    }
    
    public String redireccionarEliminarCodigo(){
        return "eliminarCodigoQR";
    }
    
}
