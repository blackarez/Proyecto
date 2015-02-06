/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Pregunta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jhon
 */
@Stateless
public class PreguntaFacade extends AbstractFacade<Pregunta> implements PreguntaFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }
    
}
