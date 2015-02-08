package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> usuarioCorreo;
	public static volatile SingularAttribute<Usuario, String> usuarioNombre;
	public static volatile ListAttribute<Usuario, Login> loginList;
	public static volatile SingularAttribute<Usuario, Rol> rolId;
	public static volatile SingularAttribute<Usuario, String> usuarioApellido;
	public static volatile SingularAttribute<Usuario, String> usuarioClave;
	public static volatile SingularAttribute<Usuario, Integer> usuarioId;
	public static volatile ListAttribute<Usuario, UsuarioGrupo> usuarioGrupoList;
	public static volatile SingularAttribute<Usuario, EstadoUsuario> estadoUsuario;
	public static volatile ListAttribute<Usuario, Mensaje> mensajeList;
	public static volatile ListAttribute<Usuario, UsuarioEvaluacion> usuarioEvaluacionList;

}

