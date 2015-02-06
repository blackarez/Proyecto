/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoUsuario;
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
public class EstadoUsuarioFacade extends AbstractFacade<EstadoUsuario> implements EstadoUsuarioFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoUsuarioFacade() {
        super(EstadoUsuario.class);
    }
    
    @Override
    public List<String> buscarEstadosUsuarios(){
        try {
            Query consulta = em.createQuery("select e.estadoUsuarioEstado from EstadoUsuario e");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public int obtenerIdEstadoUsuarioPorEstado(String estado){
        try {
            Query consulta = em.createQuery("select e.estadoUsuarioId from EstadoUsuario e where e.estadoUsuarioEstado=:estado");
            consulta.setParameter("estado",estado);
            int idEstado = Integer.parseInt(consulta.getSingleResult().toString());
            return idEstado;
        } catch (Exception e) {
            return 0;
        }
    }
    
}
