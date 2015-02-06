package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LibroMagicoCodigo.class)
public abstract class LibroMagicoCodigo_ {

	public static volatile SingularAttribute<LibroMagicoCodigo, LibroMagico> libroMagicoId;
	public static volatile SingularAttribute<LibroMagicoCodigo, Integer> libroMagicoCodigoId;
	public static volatile SingularAttribute<LibroMagicoCodigo, Codigo> codigoId;

}

