/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface RolFacadeLocal {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

    List<Rol> findRange(int[] range);

    int count();
    
    List<String> buscarNombreRoles();
    
    int obtenerIdRolPorNombre(String nombreRol);
    
    List<String> getListaRoles();
    
    Rol actualizarRol(int id,String nombreRol, String descripcion);
}
