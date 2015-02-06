/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Login;
import edu.udistrital.zuma.entityBean.Usuario;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> implements LoginFacadeLocal {
    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }
    
    @Override
    public Login consultarLoginPorUsuario(Usuario usuario) {
        try {
            Query consultaLogin = em.createQuery("select l from Login l where l.usuarioId =:usuario");
            consultaLogin.setParameter("usuario", usuario);
            Login loginEncontrado = (Login) consultaLogin.getSingleResult();
            return loginEncontrado;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Login actualizarFechaIngresoPorUsuario(Usuario usuario, Date fecha) {
        try {
            Query consulta = em.createQuery("select l from Login l where l.usuarioId =:usuario");
            consulta.setParameter("usuario", usuario);
            Login login = (Login) consulta.getSingleResult();
            login.setLoginUltimoIngreso(fecha);
            int numeroIngresos = login.getLoginNumeroIngresos() + 1;
            login.setLoginNumeroIngresos(numeroIngresos);
            return login;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Login registrarLoginPorUsuario(Usuario usuario, Date fecha) {
        try {
            Login nuevoLogin = new Login();
            nuevoLogin.setLoginNumeroIngresos(1);
            nuevoLogin.setLoginUltimoIngreso(fecha);
            nuevoLogin.setUsuarioId(usuario);
            em.persist(nuevoLogin);
            return nuevoLogin;
        } catch (Exception e) {
            return null;
        }
    }
    
}
