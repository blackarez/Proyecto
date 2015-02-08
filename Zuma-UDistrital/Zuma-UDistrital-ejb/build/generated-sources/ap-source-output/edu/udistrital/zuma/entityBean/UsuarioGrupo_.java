package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UsuarioGrupo.class)
public abstract class UsuarioGrupo_ {

	public static volatile SingularAttribute<UsuarioGrupo, Integer> usuarioGrupoId;
	public static volatile SingularAttribute<UsuarioGrupo, Grupo> grupoId;
	public static volatile SingularAttribute<UsuarioGrupo, Usuario> usuarioId;

}

