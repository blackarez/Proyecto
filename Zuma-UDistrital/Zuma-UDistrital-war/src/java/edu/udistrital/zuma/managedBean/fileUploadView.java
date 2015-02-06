/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Jhon
 */
@ManagedBean
@ViewScoped
public class fileUploadView {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String upload() {
        if (file.getContents().length!=0) {
            System.out.println("holaaaaaaaaaaaaaaaa");
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            //file = null;
            return "consultarCodigos";
        } else {
            System.out.println("malllllllllllllllllllll");
            FacesMessage message = new FacesMessage("Error", "No se pudo cargar la imagen");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "crearCodigoQR";
        }
    }

}
