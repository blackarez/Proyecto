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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class AdminCrearCodigoBean {

    @EJB
    private CodigoFacadeLocal codigoFacade;
    @EJB
    private EstadoCodigoFacadeLocal estadoCodigoFacade;

    @EJB
    private TipoCodigoFacadeLocal tipoCodigoFacade;

    List<String> listaTiposCodigo;
    List<String> listaEstados;
    String nombre;
    String tipoCodigo;
    String descripcion;
    String estado;
    UploadedFile file;

    public AdminCrearCodigoBean() {
    }

    public List<String> getListaTiposCodigo() {
        listaTiposCodigo = tipoCodigoFacade.obtenerListaTiposCodigo();
        return listaTiposCodigo;
    }

    public void setListaTiposCodigo(List<String> listaTiposCodigo) {
        this.listaTiposCodigo = listaTiposCodigo;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<String> getListaEstados() {
        listaEstados = estadoCodigoFacade.obtenerListaEstadosCodigos();
        return listaEstados;
    }

    public void setListaEstados(List<String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public String upload() {
        if (file.getContents().length != 0) {
            
            if (file.getFileName().substring(file.getFileName().length() - 3).equals("png") || file.getFileName().substring(file.getFileName().length() - 3).equals("jpg")) {
                String ruta = codigoFacade.guardarCodigoEnServidor(file.getFileName(), file.getContents());

                if (!ruta.equals("")) {
                    //insertar en base de datos...
                    int idEstado = estadoCodigoFacade.getIdEstado(estado);
                    int idTipo = tipoCodigoFacade.getIdTipoCodigo(tipoCodigo);
                    if (codigoFacade.crearNuevoCodigo(idEstado, idTipo, nombre, descripcion, ruta) != null) {
                        FacesMessage mensaje = new FacesMessage("Bien", "Ha creado un nuevo codigo.");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        System.out.println("Ha creado un nuevo codigo.");
                        return "consultarCodigos";
                    } else {
                        FacesMessage mensaje = new FacesMessage("Error", "No se pudo crear el codigo.");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        System.out.println("No se pudo crear el codigo.");
                        return "crearCodigoQR";
                    }
                } else {
                    FacesMessage mensaje = new FacesMessage("Error", "No se pudo crear el codigo.");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    System.out.println("ocurrio un error..");
                    return "crearCodigoQR";
                }

            } else {
                FacesMessage mensaje = new FacesMessage("Error", "No es un codigo valido.");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                file = null;
                return "crearCodigoQR";
            }
        } else {
            System.out.println("malllllllllllllllllllll");
            FacesMessage message = new FacesMessage("Error", "No se pudo cargar la imagen");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "crearCodigoQR";
        }
    }

}
