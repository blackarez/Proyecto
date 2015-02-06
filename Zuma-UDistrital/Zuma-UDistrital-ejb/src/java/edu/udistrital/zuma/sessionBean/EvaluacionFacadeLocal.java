/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Evaluacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface EvaluacionFacadeLocal {

    void create(Evaluacion evaluacion);

    void edit(Evaluacion evaluacion);

    void remove(Evaluacion evaluacion);

    Evaluacion find(Object id);

    List<Evaluacion> findAll();

    List<Evaluacion> findRange(int[] range);

    int count();
    
}
