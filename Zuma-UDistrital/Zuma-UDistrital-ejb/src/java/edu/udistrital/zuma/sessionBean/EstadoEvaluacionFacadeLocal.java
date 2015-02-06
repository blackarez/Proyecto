/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoEvaluacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface EstadoEvaluacionFacadeLocal {

    void create(EstadoEvaluacion estadoEvaluacion);

    void edit(EstadoEvaluacion estadoEvaluacion);

    void remove(EstadoEvaluacion estadoEvaluacion);

    EstadoEvaluacion find(Object id);

    List<EstadoEvaluacion> findAll();

    List<EstadoEvaluacion> findRange(int[] range);

    int count();
    
}
