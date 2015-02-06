package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EstadoUsuario.class)
public abstract class EstadoUsuario_ {

	public static volatile SingularAttribute<EstadoUsuario, String> estadoUsuarioEstado;
	public static volatile ListAttribute<EstadoUsuario, Usuario> usuarioList;
	public static volatile SingularAttribute<EstadoUsuario, Integer> estadoUsuarioId;
	public static volatile SingularAttribute<EstadoUsuario, String> estadoUsuarioDescripcion;

}

