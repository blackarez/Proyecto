package edu.udistrital.zuma.entityBean;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Evaluacion.class)
public abstract class Evaluacion_ {

	public static volatile SingularAttribute<Evaluacion, String> evaluacionDescripcion;
	public static volatile SingularAttribute<Evaluacion, Integer> evaluacionTiempo;
	public static volatile SingularAttribute<Evaluacion, Date> evaliacionFechaFin;
	public static volatile SingularAttribute<Evaluacion, String> evaluacionTema;
	public static volatile SingularAttribute<Evaluacion, EstadoEvaluacion> estadoEvaluacionId;
	public static volatile ListAttribute<Evaluacion, Pregunta> preguntaList;
	public static volatile SingularAttribute<Evaluacion, Date> evaluacionFechaInicio;
	public static volatile SingularAttribute<Evaluacion, Integer> evaluacionId;
	public static volatile SingularAttribute<Evaluacion, Grupo> grupoId;
	public static volatile ListAttribute<Evaluacion, UsuarioEvaluacion> usuarioEvaluacionList;

}

