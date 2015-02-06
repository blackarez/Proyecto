/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Contenido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface ContenidoFacadeLocal {

    void create(Contenido contenido);

    void edit(Contenido contenido);

    void remove(Contenido contenido);

    Contenido find(Object id);

    List<Contenido> findAll();

    List<Contenido> findRange(int[] range);

    int count();

    Contenido buscarPorTitulo(String titulo);

    Contenido crearNuevo(String tituloContenido,String temaContenido, String introduccionContenido,String resumenContenido,String explicacionContenido,int idGrupo);

    List<Contenido> listaContenidosPorDocente(int idDocente);
    
    Contenido actualizarContenido(int idContenido, String titulo, String tema, String resumen, String explicacion, int grupo);
    
    boolean eliminarContenidoPorId(int id);
    
}
