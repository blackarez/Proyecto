package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TipoMensaje.class)
public abstract class TipoMensaje_ {

	public static volatile SingularAttribute<TipoMensaje, Integer> tipoMensajeId;
	public static volatile SingularAttribute<TipoMensaje, String> tipoMensajeTipo;
	public static volatile SingularAttribute<TipoMensaje, String> tipoMensajeDescripcion;
	public static volatile ListAttribute<TipoMensaje, Mensaje> mensajeList;

}

