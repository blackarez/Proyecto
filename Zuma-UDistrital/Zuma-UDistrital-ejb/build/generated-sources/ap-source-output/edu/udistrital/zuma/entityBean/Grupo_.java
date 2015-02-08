package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Grupo.class)
public abstract class Grupo_ {

	public static volatile SingularAttribute<Grupo, String> grupoDescripcion;
	public static volatile ListAttribute<Grupo, Evaluacion> evaluacionList;
	public static volatile SingularAttribute<Grupo, String> grupoNombre;
	public static volatile ListAttribute<Grupo, Contenido> contenidoList;
	public static volatile ListAttribute<Grupo, LibroMagico> libroMagicoList;
	public static volatile SingularAttribute<Grupo, String> grupoPrerrequisitos;
	public static volatile SingularAttribute<Grupo, Integer> grupoId;
	public static volatile ListAttribute<Grupo, UsuarioGrupo> usuarioGrupoList;
	public static volatile SingularAttribute<Grupo, EstadoGrupo> estadoGrupoId;

}

