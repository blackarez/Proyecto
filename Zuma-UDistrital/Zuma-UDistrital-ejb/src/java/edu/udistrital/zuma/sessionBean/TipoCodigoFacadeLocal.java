/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.TipoCodigo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface TipoCodigoFacadeLocal {

    void create(TipoCodigo tipoCodigo);

    void edit(TipoCodigo tipoCodigo);

    void remove(TipoCodigo tipoCodigo);

    TipoCodigo find(Object id);

    List<TipoCodigo> findAll();

    List<TipoCodigo> findRange(int[] range);

    int count();
    
    List<String> obtenerListaTiposCodigo();
    
    int getIdTipoCodigo(String tipoCodigo);
    
}
