package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Mensaje.class)
public abstract class Mensaje_ {

	public static volatile SingularAttribute<Mensaje, String> mensajeAsunto;
	public static volatile SingularAttribute<Mensaje, TipoMensaje> tipoMensajeId;
	public static volatile SingularAttribute<Mensaje, String> mensajeContenido;
	public static volatile SingularAttribute<Mensaje, Usuario> usuarioId;
	public static volatile SingularAttribute<Mensaje, String> mensajeContacto;
	public static volatile SingularAttribute<Mensaje, Integer> mensajeId;

}

