/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Grupo;
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
public class GrupoFacade extends AbstractFacade<Grupo> implements GrupoFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }
    
    @Override
    public List<String> listaDeNombresGrupos(){
        try {
            Query consulta = em.createQuery("select g.grupoNombre from Grupo g");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Grupo buscarGrupoPorNombre(String nombre){
        try {
            Query consulta = em.createQuery("select g from Grupo g where g.grupoNombre=:nombreGrupo");
            consulta.setParameter("nombreGrupo", nombre);
            return (Grupo)consulta.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public int getIdPorNombre(String nombreGrupo){
        try {
            Query consulta = em.createQuery("select g.grupoId from Grupo g where g.grupoNombre=:nombreDeGrupo");
            consulta.setParameter("nombreDeGrupo", nombreGrupo);
            return (Integer)consulta.getSingleResult();
        } catch (Exception e) {
            return 0;
        }
        
    }
    
    @Override
    public List<String> listaDeNombresGruposPorDocente(int idDocente){
        try {
            Query consulta = em.createNativeQuery("select distinct grupo.grupo_nombre from grupo,usuario_grupo, usuario where grupo.grupo_id = usuario_grupo.grupo_id and usuario_grupo.usuario_id="+idDocente);
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
