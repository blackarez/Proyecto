/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Contenido;
import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.entityBean.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon
 */
@Stateless
public class ContenidoFacade extends AbstractFacade<Contenido> implements ContenidoFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenidoFacade() {
        super(Contenido.class);
    }

    @Override
    public Contenido buscarPorTitulo(String titulo) {
        try {
            Query consulta = em.createQuery("select c from Contenido c where c.contenidoTitulo=:titulo");
            consulta.setParameter("titulo", titulo);
            return (Contenido) consulta.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Contenido crearNuevo(String tituloContenido, String temaContenido, String introduccionContenido, String resumenContenido, String explicacionContenido, int idGrupo) {
        try {
            Contenido nuevoContenido = new Contenido();
            nuevoContenido.setContenidoTitulo(tituloContenido);
            nuevoContenido.setContenidoTema(temaContenido);
            nuevoContenido.setContenidoIntroduccion(introduccionContenido);
            nuevoContenido.setContenidoResumen(resumenContenido);
            nuevoContenido.setContenidoExplicacion(explicacionContenido);
            nuevoContenido.setGrupoId(em.find(Grupo.class, idGrupo));
            em.persist(nuevoContenido);
            return nuevoContenido;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Contenido> listaContenidosPorDocente(int idDocente) {
        try {
            System.out.println("entro al try...");
            Query consulta = em.createQuery("select c from Contenido c,Grupo g,UsuarioGrupo ug where c.grupoId = g.grupoId and g.grupoId=ug.grupoId and ug.usuarioId.usuarioId=:idDocente");
            //Query consulta = em.createQuery("select c from Contenido c, ");
            System.out.println("creo la consulta");
            consulta.setParameter("idDocente", idDocente);
            System.out.println("le metido el parametro.");
            return consulta.getResultList();
        } catch (Exception e) {
            System.out.println("Hooollaaaaaaaaaaaaaaaaaaaaaaaaa Exception en listaContenidosPorDocente = " + e);
            return null;
        }
    }

    @Override
    public Contenido actualizarContenido(int idContenido, String titulo, String tema, String resumen, String explicacion, int grupo) {
        try {
            System.out.println("llamo a update conten");
            Contenido contenidoEditar = em.find(Contenido.class, idContenido);
            if (contenidoEditar != null) {
                System.out.println("lo encontro.");
                contenidoEditar.setContenidoTitulo(titulo);
                contenidoEditar.setContenidoTema(tema);
                contenidoEditar.setContenidoResumen(resumen);
                contenidoEditar.setContenidoExplicacion(explicacion);
                contenidoEditar.setGrupoId(em.find(Grupo.class, grupo));
                return contenidoEditar;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    @Override
    public boolean eliminarContenidoPorId(int id){
        try {
            em.remove(em.find(Contenido.class,id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
