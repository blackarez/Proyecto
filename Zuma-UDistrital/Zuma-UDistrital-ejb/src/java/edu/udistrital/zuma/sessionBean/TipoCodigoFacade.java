/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.TipoCodigo;
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
public class TipoCodigoFacade extends AbstractFacade<TipoCodigo> implements TipoCodigoFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCodigoFacade() {
        super(TipoCodigo.class);
    }
    
    @Override
    public List<String> obtenerListaTiposCodigo(){
        try {
            Query consulta = em.createQuery("select tipo.tipoCodigoTipo from TipoCodigo tipo");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public int getIdTipoCodigo(String tipoCodigo){
        try {
            Query consulta = em.createQuery("select tc.tipoCodigoId from TipoCodigo tc where tc.tipoCodigoTipo=:tipoCodigo");
            consulta.setParameter("tipoCodigo",tipoCodigo);
            return (Integer)consulta.getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }
    
}
