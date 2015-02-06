/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.LibroMagico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface LibroMagicoFacadeLocal {

    void create(LibroMagico libroMagico);

    void edit(LibroMagico libroMagico);

    void remove(LibroMagico libroMagico);

    LibroMagico find(Object id);

    List<LibroMagico> findAll();

    List<LibroMagico> findRange(int[] range);

    int count();
    
}
