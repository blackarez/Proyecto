/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.LibroMagico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jhon
 */
@Stateless
public class LibroMagicoFacade extends AbstractFacade<LibroMagico> implements LibroMagicoFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroMagicoFacade() {
        super(LibroMagico.class);
    }
    
}
