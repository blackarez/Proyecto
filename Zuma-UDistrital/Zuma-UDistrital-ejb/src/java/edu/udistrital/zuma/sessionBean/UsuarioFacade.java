/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.EstadoUsuario;
import edu.udistrital.zuma.entityBean.Rol;
import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.entityBean.UsuarioGrupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario login(String correo) {
        try {
            Query consulta = em.createQuery("select u from Usuario u where u.usuarioCorreo=:correo and u.estadoUsuario.estadoUsuarioId=:estado");
            consulta.setParameter("correo", correo);
            consulta.setParameter("estado", 1);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario registrarUsuarioInvitado(String nombre, String apellido, String correo, String clave, int rolInvitado, int estadoUsuario) {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuarioNombre(nombre);
            nuevoUsuario.setUsuarioApellido(apellido);
            nuevoUsuario.setUsuarioCorreo(correo);
            nuevoUsuario.setUsuarioClave(clave);
            nuevoUsuario.setRolId(em.find(Rol.class, rolInvitado));
            nuevoUsuario.setEstadoUsuario(em.find(EstadoUsuario.class, estadoUsuario));
            em.persist(nuevoUsuario);
            return nuevoUsuario;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario cambiarRolAEstudiante(int idNuevoEstudiante) {
        try {
            Usuario nuevoEstudiante = em.find(Usuario.class, idNuevoEstudiante);
            nuevoEstudiante.setRolId(em.find(Rol.class, 3)); //el rol tres (3) es estudiante.
            return nuevoEstudiante;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public UsuarioGrupo tieneGrupo(int idUsuario) {
        try {
            Query consulta = em.createQuery("select ug from UsuarioGrupo ug where ug.usuarioId=:usuario");
            consulta.setParameter("usuario", em.find(Usuario.class, idUsuario));
            UsuarioGrupo grupoDelUsuario = (UsuarioGrupo) consulta.getSingleResult();
            if (grupoDelUsuario != null) {
                return grupoDelUsuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(int id) {
        try {
            Query consulta = em.createQuery("select u from Usuario u where u.usuarioId=:id");
            consulta.setParameter("id", id);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario actualizarUsuario(String id, String nombre, String apellido, String correo,int idEstado, int idRol) {
        Usuario usuario = em.find(Usuario.class, Integer.parseInt(id));
        if (usuario != null) {
            try {
                usuario.setUsuarioNombre(nombre);
                usuario.setUsuarioApellido(apellido);
                usuario.setUsuarioCorreo(correo);
                usuario.setEstadoUsuario(em.find(EstadoUsuario.class, idEstado));
                usuario.setRolId(em.find(Rol.class, idRol));
                System.out.println("edito usuario.");
                return usuario;
            } catch (Exception e) {
                System.out.println("exception = " + e);
                return null;
            }
        } else {
            System.out.println("no encontro al usaurios.");
            return null;
        }
    }

    @Override
    public boolean eliminarUsuarioPorId(int idUsuarioEliminar){
        try{
        Usuario usuarioEliminar = em.find(Usuario.class,idUsuarioEliminar);
        em.remove(usuarioEliminar);
        return true;
        }catch(Exception e){
            System.out.println("No se pudo eliminar e="+e);
            return false;
        }
    }
    
    @Override
    public Usuario crearUsuario(String nombre, String apellido, String correo, String clave, int estado, int rol){
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuarioNombre(nombre);
            nuevoUsuario.setUsuarioApellido(apellido);
            nuevoUsuario.setUsuarioCorreo(correo);
            nuevoUsuario.setUsuarioClave(clave);
            nuevoUsuario.setRolId(em.find(Rol.class, rol));
            nuevoUsuario.setEstadoUsuario(em.find(EstadoUsuario.class, estado));
            em.persist(nuevoUsuario);
            return nuevoUsuario;
        } catch (Exception e) {
            return null;
        }
    }
    
}
