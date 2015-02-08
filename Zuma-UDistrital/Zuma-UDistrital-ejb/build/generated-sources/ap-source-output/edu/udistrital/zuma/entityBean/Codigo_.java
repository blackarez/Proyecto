package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Codigo.class)
public abstract class Codigo_ {

	public static volatile SingularAttribute<Codigo, String> codigoRutaImagen;
	public static volatile SingularAttribute<Codigo, EstadoCodigo> estadoCodigoId;
	public static volatile SingularAttribute<Codigo, String> codigoNombre;
	public static volatile SingularAttribute<Codigo, TipoCodigo> tipoCodigoId;
	public static volatile ListAttribute<Codigo, LibroMagicoCodigo> libroMagicoCodigoList;
	public static volatile SingularAttribute<Codigo, Integer> codigoId;
	public static volatile SingularAttribute<Codigo, String> codigoDescripcion;

}

