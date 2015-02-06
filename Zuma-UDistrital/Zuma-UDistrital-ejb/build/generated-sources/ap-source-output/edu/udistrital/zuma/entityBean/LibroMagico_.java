package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LibroMagico.class)
public abstract class LibroMagico_ {

	public static volatile SingularAttribute<LibroMagico, String> libroMagicoContenido;
	public static volatile SingularAttribute<LibroMagico, Integer> libroMagicoId;
	public static volatile ListAttribute<LibroMagico, LibroMagicoCodigo> libroMagicoCodigoList;
	public static volatile SingularAttribute<LibroMagico, String> libroMagicoIntroduccion;
	public static volatile SingularAttribute<LibroMagico, String> libroMagicoTitulo;
	public static volatile SingularAttribute<LibroMagico, Grupo> grupoId;
	public static volatile SingularAttribute<LibroMagico, String> libroMagicoDescripcion;

}

