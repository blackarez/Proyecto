package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pregunta.class)
public abstract class Pregunta_ {

	public static volatile SingularAttribute<Pregunta, String> preguntaOpcionB;
	public static volatile SingularAttribute<Pregunta, String> preguntaOpcionC;
	public static volatile SingularAttribute<Pregunta, Integer> preguntaId;
	public static volatile SingularAttribute<Pregunta, String> preguntaEnunciado;
	public static volatile SingularAttribute<Pregunta, Evaluacion> evaluacionId;
	public static volatile SingularAttribute<Pregunta, String> preguntaOpcionA;
	public static volatile SingularAttribute<Pregunta, String> preguntaRespuesta;
	public static volatile SingularAttribute<Pregunta, String> preguntaOpcionD;

}

