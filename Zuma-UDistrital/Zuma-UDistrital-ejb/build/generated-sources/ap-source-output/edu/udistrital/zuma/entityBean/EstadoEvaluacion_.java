package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EstadoEvaluacion.class)
public abstract class EstadoEvaluacion_ {

	public static volatile ListAttribute<EstadoEvaluacion, Evaluacion> evaluacionList;
	public static volatile SingularAttribute<EstadoEvaluacion, String> estadoEvaluacionEstado;
	public static volatile SingularAttribute<EstadoEvaluacion, Integer> estadoEvaluacionId;
	public static volatile SingularAttribute<EstadoEvaluacion, String> estadoEvaluacionDescripcion;

}

