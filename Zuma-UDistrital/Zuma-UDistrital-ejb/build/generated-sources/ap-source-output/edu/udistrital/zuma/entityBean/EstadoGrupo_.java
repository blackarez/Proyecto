package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EstadoGrupo.class)
public abstract class EstadoGrupo_ {

	public static volatile ListAttribute<EstadoGrupo, Grupo> grupoList;
	public static volatile SingularAttribute<EstadoGrupo, String> estadoGrupoEstado;
	public static volatile SingularAttribute<EstadoGrupo, String> estadoGrupoDescripcion;
	public static volatile SingularAttribute<EstadoGrupo, Integer> estadoGrupoId;

}

