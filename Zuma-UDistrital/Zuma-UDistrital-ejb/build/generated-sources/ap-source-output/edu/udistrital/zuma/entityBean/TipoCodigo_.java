package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TipoCodigo.class)
public abstract class TipoCodigo_ {

	public static volatile SingularAttribute<TipoCodigo, String> tipoCodigoTipo;
	public static volatile ListAttribute<TipoCodigo, Codigo> codigoList;
	public static volatile SingularAttribute<TipoCodigo, Integer> tipoCodigoId;
	public static volatile SingularAttribute<TipoCodigo, String> tipoCodigoDescripcion;

}

