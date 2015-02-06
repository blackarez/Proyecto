/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoCodigo;
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
public class EstadoCodigoFacade extends AbstractFacade<EstadoCodigo> implements EstadoCodigoFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCodigoFacade() {
        super(EstadoCodigo.class);
    }

    @Override
    public List<String> obtenerListaEstadosCodigos() {
        try {
            Query consulta = em.createQuery("select e.estadoCodigoEstado from EstadoCodigo e");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    @Override
    public int getIdEstado(String estado){
        try {
            Query consulta = em.createQuery("select e.estadoCodigoId from EstadoCodigo e where e.estadoCodigoEstado=:estadoCodigo");
            consulta.setParameter("estadoCodigo", estado);
            return (Integer)consulta.getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }
}
