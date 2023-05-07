package com.usta.tunja.entity;

import com.usta.tunja.entity.Cargo;
import com.usta.tunja.entity.DetalleMes;
import com.usta.tunja.entity.DetalleMesMovimiento;
import com.usta.tunja.entity.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(CargoPersona.class)
public class CargoPersona_ { 

    public static volatile SingularAttribute<CargoPersona, Date> fecha;
    public static volatile SingularAttribute<CargoPersona, Persona> persona;
    public static volatile ListAttribute<CargoPersona, DetalleMes> detalleMes;
    public static volatile SingularAttribute<CargoPersona, Cargo> cargo;
    public static volatile SingularAttribute<CargoPersona, Integer> idCargoPersona;
    public static volatile ListAttribute<CargoPersona, DetalleMesMovimiento> detalleMovimiento;

}