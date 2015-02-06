/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.sessionBean.CodigoFacadeLocal;
import edu.udistrital.zuma.sessionBean.EstadoCodigoFacadeLocal;
import edu.udistrital.zuma.sessionBean.TipoCodigoFacadeLocal;
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
public class AdminEditarCodigoBean {
    @EJB
    private CodigoFacadeLocal codigoFacade;
    @EJB
    private TipoCodigoFacadeLocal tipoCodigoFacade;
    @EJB
    private EstadoCodigoFacadeLocal estadoCodigoFacade;

    String idCodigo;
    String nombreCodigo;
    String descripcion;
    String estadoCodigo;
    String tipoCodigo;
    List<String> listaEstadosCodigos;
    
    public AdminEditarCodigoBean() {
    }

    public String getNombreCodigo() {
        return nombreCodigo;
    }

    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getEstadoCodigo() {
        return estadoCodigo;
    }

    public void setEstadoCodigo(String estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public List<String> getListaEstadosCodigos() {
        listaEstadosCodigos = estadoCodigoFacade.obtenerListaEstadosCodigos();
        return listaEstadosCodigos;
    }

    public void setListaEstadosCodigos(List<String> listaEstadosCodigos) {
        this.listaEstadosCodigos = listaEstadosCodigos;
    }
    
    public String editarCodigoQR(){
        int idEstadoCodigo = estadoCodigoFacade.getIdEstado(estadoCodigo);
        int idTipoCodigo = tipoCodigoFacade.getIdTipoCodigo(tipoCodigo);
        if(codigoFacade.actualizarCodigoQR(Integer.parseInt(idCodigo), nombreCodigo, descripcion, idEstadoCodigo, idTipoCodigo)!=null){
            return "consultarCodigos";
        }else{
            return "editarCodigoQR";
        }
    }
    
}
