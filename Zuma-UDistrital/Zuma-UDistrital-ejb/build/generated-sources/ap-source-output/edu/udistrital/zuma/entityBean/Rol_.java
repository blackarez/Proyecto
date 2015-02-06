package edu.udistrital.zuma.entityBean;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rol.class)
public abstract class Rol_ {

	public static volatile SingularAttribute<Rol, String> rolDescripcion;
	public static volatile SingularAttribute<Rol, Integer> rolId;
	public static volatile ListAttribute<Rol, Usuario> usuarioList;
	public static volatile SingularAttribute<Rol, String> rolNombre;

}

