/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.entityBean.UsuarioGrupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface UsuarioGrupoFacadeLocal {

    void create(UsuarioGrupo usuarioGrupo);

    void edit(UsuarioGrupo usuarioGrupo);

    void remove(UsuarioGrupo usuarioGrupo);

    UsuarioGrupo find(Object id);

    List<UsuarioGrupo> findAll();

    List<UsuarioGrupo> findRange(int[] range);

    int count();
    
    UsuarioGrupo matricularNuevoEstudiante(Grupo grupo, int idUsuario);
    
    
}
