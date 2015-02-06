package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.sessionBean.ContenidoFacadeLocal;
import edu.udistrital.zuma.sessionBean.GrupoFacadeLocal;
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
public class DocenteCrearContenidoBean {

    @EJB
    private ContenidoFacadeLocal contenidoFacade;
    @EJB
    private GrupoFacadeLocal grupoFacade;

    String tituloContenido;
    String temaContenido;
    String introduccionContenido;
    String resumenContenido;
    String explicacionContenido;
    String grupoContenido;
    List<String> listadoGrupos;

    public DocenteCrearContenidoBean() {
    }

    public String getTituloContenido() {
        return tituloContenido;
    }

    public void setTituloContenido(String tituloContenido) {
        this.tituloContenido = tituloContenido;
    }

    public String getTemaContenido() {
        return temaContenido;
    }

    public void setTemaContenido(String temaContenido) {
        this.temaContenido = temaContenido;
    }

    public String getIntroduccionContenido() {
        return introduccionContenido;
    }

    public void setIntroduccionContenido(String introduccionContenido) {
        this.introduccionContenido = introduccionContenido;
    }

    public String getResumenContenido() {
        return resumenContenido;
    }

    public void setResumenContenido(String resumenContenido) {
        this.resumenContenido = resumenContenido;
    }

    public String getExplicacionContenido() {
        return explicacionContenido;
    }

    public void setExplicacionContenido(String explicacionContenido) {
        this.explicacionContenido = explicacionContenido;
    }

    public String getGrupoContenido() {
        return grupoContenido;
    }

    public void setGrupoContenido(String grupoContenido) {
        this.grupoContenido = grupoContenido;
    }

    public List<String> getListadoGrupos() {
        listadoGrupos = grupoFacade.listaDeNombresGrupos();
        return listadoGrupos;
    }

    public void setListadoGrupos(List<String> listadoGrupos) {
        this.listadoGrupos = listadoGrupos;
    }

    public String crearContenido() {
        if (contenidoFacade.buscarPorTitulo(tituloContenido) == null) {
            //crear contenido
            int idGrupo = grupoFacade.getIdPorNombre(grupoContenido);
            if (contenidoFacade.crearNuevo(tituloContenido, temaContenido, introduccionContenido, resumenContenido, explicacionContenido, idGrupo)!=null) {
                return "inicio";
            } else {
                //no se pudo crear el contenido.
                return "crearContenido";
            }
        } else {
            //titulo ya existe.
            return "crearContenido";
        }

    }

}
