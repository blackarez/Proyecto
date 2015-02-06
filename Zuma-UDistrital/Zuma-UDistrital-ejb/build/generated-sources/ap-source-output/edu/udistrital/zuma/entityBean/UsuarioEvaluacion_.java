package edu.udistrital.zuma.entityBean;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UsuarioEvaluacion.class)
public abstract class UsuarioEvaluacion_ {

	public static volatile SingularAttribute<UsuarioEvaluacion, String> usuarioEvaluacionNota;
	public static volatile SingularAttribute<UsuarioEvaluacion, Integer> usuarioEvaluacionId;
	public static volatile SingularAttribute<UsuarioEvaluacion, Evaluacion> evaluacionId;
	public static volatile SingularAttribute<UsuarioEvaluacion, Date> usuarioEvaluacionFechaRealizacion;
	public static volatile SingularAttribute<UsuarioEvaluacion, Usuario> usuarioId;

}

