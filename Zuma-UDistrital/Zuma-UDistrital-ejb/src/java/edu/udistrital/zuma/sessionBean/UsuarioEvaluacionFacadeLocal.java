/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.UsuarioEvaluacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface UsuarioEvaluacionFacadeLocal {

    void create(UsuarioEvaluacion usuarioEvaluacion);

    void edit(UsuarioEvaluacion usuarioEvaluacion);

    void remove(UsuarioEvaluacion usuarioEvaluacion);

    UsuarioEvaluacion find(Object id);

    List<UsuarioEvaluacion> findAll();

    List<UsuarioEvaluacion> findRange(int[] range);

    int count();
    
}
