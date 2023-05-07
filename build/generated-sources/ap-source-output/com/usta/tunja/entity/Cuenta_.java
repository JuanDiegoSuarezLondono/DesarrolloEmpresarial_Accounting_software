package com.usta.tunja.entity;

import com.usta.tunja.entity.Cuenta;
import com.usta.tunja.entity.CuentaPersona;
import com.usta.tunja.entity.Empresa;
import com.usta.tunja.entity.Puc;
import com.usta.tunja.entity.TipoCuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Integer> idSubCuenta;
    public static volatile ListAttribute<Cuenta, CuentaPersona> cuentaPersona;
    public static volatile SingularAttribute<Cuenta, TipoCuenta> tipoCuenta;
    public static volatile ListAttribute<Cuenta, Cuenta> cuentas;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;
    public static volatile SingularAttribute<Cuenta, Empresa> empresa;
    public static volatile SingularAttribute<Cuenta, Cuenta> cuentapadre;
    public static volatile SingularAttribute<Cuenta, String> detalle;
    public static volatile SingularAttribute<Cuenta, Puc> puc;

}