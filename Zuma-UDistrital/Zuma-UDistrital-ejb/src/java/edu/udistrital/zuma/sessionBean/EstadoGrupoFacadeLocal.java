/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoGrupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface EstadoGrupoFacadeLocal {

    void create(EstadoGrupo estadoGrupo);

    void edit(EstadoGrupo estadoGrupo);

    void remove(EstadoGrupo estadoGrupo);

    EstadoGrupo find(Object id);

    List<EstadoGrupo> findAll();

    List<EstadoGrupo> findRange(int[] range);

    int count();
    
}
