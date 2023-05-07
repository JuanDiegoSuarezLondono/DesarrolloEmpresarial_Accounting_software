package com.usta.tunja.entity;

import com.usta.tunja.entity.CuentaPersona;
import com.usta.tunja.entity.DetalleMesMovimiento;
import com.usta.tunja.entity.Persona;
import com.usta.tunja.entity.TipoPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(PersonaTipoPersona.class)
public class PersonaTipoPersona_ { 

    public static volatile SingularAttribute<PersonaTipoPersona, Integer> idpersonatipopersona;
    public static volatile SingularAttribute<PersonaTipoPersona, Persona> persona;
    public static volatile SingularAttribute<PersonaTipoPersona, TipoPersona> tipoPer;
    public static volatile ListAttribute<PersonaTipoPersona, DetalleMesMovimiento> detalleMov;
    public static volatile ListAttribute<PersonaTipoPersona, CuentaPersona> cuentaPer;

}