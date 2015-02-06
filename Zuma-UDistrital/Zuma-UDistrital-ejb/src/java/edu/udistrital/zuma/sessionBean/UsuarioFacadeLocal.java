/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.entityBean.UsuarioGrupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Usuario login(String usuario);
    
    Usuario registrarUsuarioInvitado(String nombre, String apellido, String correo,String clave, int rolInvitado, int estadoUsuario);
    
    Usuario cambiarRolAEstudiante(int idNuevoEstudiante);
    
    UsuarioGrupo tieneGrupo(int idUsuario);
    
    Usuario buscarUsuarioPorId(int id);
    
    Usuario actualizarUsuario(String id, String nombre, String apellido, String correo,int idEstado, int idRol);
    
    boolean eliminarUsuarioPorId(int idUsuarioEliminar);
    
    Usuario crearUsuario(String nombre, String apellido, String correo, String clave, int estado, int rol);
    
    
    
}
