/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Rol;
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
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public List<String> buscarNombreRoles() {
        try {
            Query consulta = em.createQuery("select r.rolNombre from Rol r");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public int obtenerIdRolPorNombre(String nombreRol) {
        try {
            Query consulta = em.createQuery("select r.rolId from Rol r where r.rolNombre=:rol");
            consulta.setParameter("rol", nombreRol);
            int idRol = Integer.parseInt(consulta.getSingleResult().toString());
            return idRol;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<String> getListaRoles(){
           try{
               Query consulta = em.createQuery("select r.rolNombre from Rol r");
               return consulta.getResultList();
           }catch(Exception e){
               return null;
           }
    }
    
    @Override
    public Rol actualizarRol(int id,String nombreRol, String descripcion){
        try {
            Rol rolAModificar = em.find(Rol.class, id);
            rolAModificar.setRolDescripcion(descripcion);
            return rolAModificar;
        } catch (Exception e) {
            return null;
        }
    }
    
}
