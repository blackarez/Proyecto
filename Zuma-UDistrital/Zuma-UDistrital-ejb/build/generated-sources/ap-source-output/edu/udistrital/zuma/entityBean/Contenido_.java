package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Contenido.class)
public abstract class Contenido_ {

	public static volatile SingularAttribute<Contenido, String> contenidoTitulo;
	public static volatile SingularAttribute<Contenido, String> contenidoTema;
	public static volatile SingularAttribute<Contenido, String> contenidoResumen;
	public static volatile SingularAttribute<Contenido, String> contenidoIntroduccion;
	public static volatile SingularAttribute<Contenido, String> contenidoExplicacion;
	public static volatile SingularAttribute<Contenido, Integer> contenidoId;
	public static volatile SingularAttribute<Contenido, Grupo> grupoId;

}

