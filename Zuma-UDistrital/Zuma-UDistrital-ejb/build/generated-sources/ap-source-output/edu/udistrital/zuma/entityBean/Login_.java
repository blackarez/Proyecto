package edu.udistrital.zuma.entityBean;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, Integer> loginId;
	public static volatile SingularAttribute<Login, Integer> loginNumeroIngresos;
	public static volatile SingularAttribute<Login, Date> loginUltimoIngreso;
	public static volatile SingularAttribute<Login, Usuario> usuarioId;

}

