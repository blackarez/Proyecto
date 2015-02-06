/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.managedBean;

import edu.udistrital.zuma.entityBean.Grupo;
import edu.udistrital.zuma.entityBean.Usuario;
import edu.udistrital.zuma.recursos.Cifrado;
import edu.udistrital.zuma.recursos.Correo;
import edu.udistrital.zuma.sessionBean.EstadoUsuarioFacadeLocal;
import edu.udistrital.zuma.sessionBean.GrupoFacadeLocal;
import edu.udistrital.zuma.sessionBean.RolFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioFacadeLocal;
import edu.udistrital.zuma.sessionBean.UsuarioGrupoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhon
 */
@ManagedBean
@SessionScoped
public class AdminCrearUsuarioBean {

    @EJB
    private UsuarioGrupoFacadeLocal usuarioGrupoFacade;

    @EJB
    private EstadoUsuarioFacadeLocal estadoUsuarioFacade;
    @EJB
    private RolFacadeLocal rolFacade;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private GrupoFacadeLocal grupoFacade;

    String nombre;
    String apellido;
    String correo;
    String estado;
    String rol;
    String grupo;
    String clave;
    List<String> listaDeGrupos;

    public AdminCrearUsuarioBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public GrupoFacadeLocal getGrupoFacade() {
        return grupoFacade;
    }

    public void setGrupoFacade(GrupoFacadeLocal grupoFacade) {
        this.grupoFacade = grupoFacade;
    }

    public List<String> getListaDeGrupos() {
        listaDeGrupos = grupoFacade.listaDeNombresGrupos();
        return listaDeGrupos;
    }

    public void setListaDeGrupos(List<String> listaDeGrupos) {
        this.listaDeGrupos = listaDeGrupos;
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String crearUsuario() {
        System.out.println("Llamo al metodo..");
        if (Correo.validarCorreo(correo)) {
            System.out.println("correo valido...");
            if (usuarioFacade.login(correo) == null) { //El correo no existe, OK.
                System.out.println("correo valido..");
                if ((rol.equals("estudiante") || rol.equals("docente")) && !grupo.equals("")) {
                    System.out.println("se va a generar clave y envar correo.");
                    clave = (new Correo()).generarClave(6);
                    boolean envioCorreo = Correo.enviarCorreo("Hola " + nombre + ",Bienvenido a Zuma.Su clave de acceso a la plataforma Zuma es : " + clave, "zuma.soporte@gmail.com", correo, "Bienvenido a Zuma");
                    if (envioCorreo) {
                        int idEstado = estadoUsuarioFacade.obtenerIdEstadoUsuarioPorEstado(estado);
                        int idRol = rolFacade.obtenerIdRolPorNombre(rol);
                        Usuario u = usuarioFacade.crearUsuario(nombre, apellido, correo, Cifrado.encriptar(clave), idEstado, idRol);
                        if (u != null) {
                            //insertar en usuario_grupo
                            System.out.println("usuario creado......");
                            Grupo grupoSeleccionado = grupoFacade.buscarGrupoPorNombre(grupo);
                            usuarioGrupoFacade.matricularNuevoEstudiante(grupoSeleccionado, u.getUsuarioId());
                            System.out.println("asociado usuario a grupo........");
                        } else {
                            return "crearUsuario";
                        }
                        return "consultarUsuarios";
                    } else {
                        return "crearUsuario";
                    }

                } else if ((rol.equals("administrador") || rol.equals("invitado")) && "".equals(grupo)) {
                    clave = (new Correo()).generarClave(6);
                    boolean envioCorreo = Correo.enviarCorreo("Hola " + nombre + ",Bienvenido a Zuma.Su clave de acceso a la plataforma Zuma es : " + clave, "zuma.soporte@gmail.com", correo, "Bienvenido a Zuma");
                    if (envioCorreo) {
                        int idEstado = estadoUsuarioFacade.obtenerIdEstadoUsuarioPorEstado(estado);
                        int idRol = rolFacade.obtenerIdRolPorNombre(rol);
                        Usuario u = usuarioFacade.crearUsuario(nombre, apellido, correo, Cifrado.encriptar(clave), idEstado, idRol);
                        if (u != null) {
                            return "consultarUsuarios";
                        } else {
                            return "crearUsuario";
                        }
                    } else {
                        return "crearUsuario";
                    }
                } else {
                    return "crearUsuario";
                }

            } else {
                //Usuario ya existe.
                return "crearUsuario";
            }
        } else {
            //Formato de correo no valido.
            return "crearUsuario";
        }
    }

    public String cancelar() {
        System.out.println("llamo al metdo cancelar.");
        return "consultarUsuarios";
    }

}
