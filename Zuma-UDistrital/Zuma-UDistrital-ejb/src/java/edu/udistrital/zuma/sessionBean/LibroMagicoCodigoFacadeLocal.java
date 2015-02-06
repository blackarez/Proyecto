/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.LibroMagicoCodigo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface LibroMagicoCodigoFacadeLocal {

    void create(LibroMagicoCodigo libroMagicoCodigo);

    void edit(LibroMagicoCodigo libroMagicoCodigo);

    void remove(LibroMagicoCodigo libroMagicoCodigo);

    LibroMagicoCodigo find(Object id);

    List<LibroMagicoCodigo> findAll();

    List<LibroMagicoCodigo> findRange(int[] range);

    int count();
    
}
