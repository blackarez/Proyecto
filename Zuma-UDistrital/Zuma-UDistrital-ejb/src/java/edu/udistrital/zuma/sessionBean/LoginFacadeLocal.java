/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Login;
import edu.udistrital.zuma.entityBean.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface LoginFacadeLocal {

    void create(Login login);

    void edit(Login login);

    void remove(Login login);

    Login find(Object id);

    List<Login> findAll();

    List<Login> findRange(int[] range);

    int count();
    
    Login consultarLoginPorUsuario(Usuario usuario);
    
    Login actualizarFechaIngresoPorUsuario(Usuario usuario,Date fecha);
    
    Login registrarLoginPorUsuario(Usuario usuario,Date fecha);
    
}
