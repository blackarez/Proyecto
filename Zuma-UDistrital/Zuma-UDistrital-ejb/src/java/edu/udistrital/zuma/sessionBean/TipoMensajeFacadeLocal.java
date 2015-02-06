/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.TipoMensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface TipoMensajeFacadeLocal {

    void create(TipoMensaje tipoMensaje);

    void edit(TipoMensaje tipoMensaje);

    void remove(TipoMensaje tipoMensaje);

    TipoMensaje find(Object id);

    List<TipoMensaje> findAll();

    List<TipoMensaje> findRange(int[] range);

    int count();
    
}
