/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Pregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface PreguntaFacadeLocal {

    void create(Pregunta pregunta);

    void edit(Pregunta pregunta);

    void remove(Pregunta pregunta);

    Pregunta find(Object id);

    List<Pregunta> findAll();

    List<Pregunta> findRange(int[] range);

    int count();
    
}
