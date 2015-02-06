/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.entityBean.UsuarioGrupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon
 */
@Stateless
public class UsuarioGrupoFacade extends AbstractFacade<UsuarioGrupo> implements UsuarioGrupoFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioGrupoFacade() {
        super(UsuarioGrupo.class);
    }

    @Override
    public UsuarioGrupo matricularNuevoEstudiante(Grupo grupo, int idUsuario) {
        try {
            UsuarioGrupo nuevoUsuarioGrupo = new UsuarioGrupo();
            nuevoUsuarioGrupo.setGrupoId(em.find(Grupo.class, grupo.getGrupoId()));
            nuevoUsuarioGrupo.setUsuarioId(em.find(Usuario.class, idUsuario));
            em.persist(nuevoUsuarioGrupo);
            return nuevoUsuarioGrupo;
        } catch (Exception e) {
            System.out.println("no puedo matrcular al chino : E = "+e);
            return null;
        }

    }

    
    
}
