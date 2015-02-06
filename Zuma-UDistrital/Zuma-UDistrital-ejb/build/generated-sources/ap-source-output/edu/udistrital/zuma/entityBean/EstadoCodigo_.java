package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EstadoCodigo.class)
public abstract class EstadoCodigo_ {

	public static volatile SingularAttribute<EstadoCodigo, String> estadoCodigoEstado;
	public static volatile SingularAttribute<EstadoCodigo, Integer> estadoCodigoId;
	public static volatile SingularAttribute<EstadoCodigo, String> estadoCodigoDescripcion;
	public static volatile ListAttribute<EstadoCodigo, Codigo> codigoList;

}

