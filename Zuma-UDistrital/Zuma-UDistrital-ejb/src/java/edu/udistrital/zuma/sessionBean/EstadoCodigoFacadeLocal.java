/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoCodigo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface EstadoCodigoFacadeLocal {

    void create(EstadoCodigo estadoCodigo);

    void edit(EstadoCodigo estadoCodigo);

    void remove(EstadoCodigo estadoCodigo);

    EstadoCodigo find(Object id);

    List<EstadoCodigo> findAll();

    List<EstadoCodigo> findRange(int[] range);

    int count();
    
    List<String> obtenerListaEstadosCodigos();
    
    int getIdEstado(String estado);
    
}
