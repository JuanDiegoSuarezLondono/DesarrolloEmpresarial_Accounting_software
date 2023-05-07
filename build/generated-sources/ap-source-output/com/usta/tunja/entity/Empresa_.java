package com.usta.tunja.entity;

import com.usta.tunja.entity.Cuenta;
import com.usta.tunja.entity.Persona;
import com.usta.tunja.entity.SalarioMinimo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Persona> persona;
    public static volatile SingularAttribute<Empresa, String> nomEmpresa;
    public static volatile SingularAttribute<Empresa, String> municipio;
    public static volatile ListAttribute<Empresa, SalarioMinimo> salMinimo;
    public static volatile SingularAttribute<Empresa, String> correo;
    public static volatile SingularAttribute<Empresa, String> nit;
    public static volatile ListAttribute<Empresa, Cuenta> cuenta;
    public static volatile SingularAttribute<Empresa, String> departamento;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile SingularAttribute<Empresa, Integer> telefono;
    public static volatile SingularAttribute<Empresa, String> pais;

}