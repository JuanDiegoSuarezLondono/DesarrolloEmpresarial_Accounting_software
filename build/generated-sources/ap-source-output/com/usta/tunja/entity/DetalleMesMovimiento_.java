package com.usta.tunja.entity;

import com.usta.tunja.entity.CargoPersona;
import com.usta.tunja.entity.Cuenta;
import com.usta.tunja.entity.Factura;
import com.usta.tunja.entity.PersonaTipoPersona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(DetalleMesMovimiento.class)
public class DetalleMesMovimiento_ { 

    public static volatile SingularAttribute<DetalleMesMovimiento, Factura> factura;
    public static volatile SingularAttribute<DetalleMesMovimiento, Date> fechaInicio;
    public static volatile SingularAttribute<DetalleMesMovimiento, PersonaTipoPersona> idPerTipoPer;
    public static volatile SingularAttribute<DetalleMesMovimiento, Integer> idDetalleMovimiento;
    public static volatile SingularAttribute<DetalleMesMovimiento, Cuenta> cuenta;
    public static volatile SingularAttribute<DetalleMesMovimiento, String> tipoDoc;
    public static volatile SingularAttribute<DetalleMesMovimiento, Date> fechafin;
    public static volatile SingularAttribute<DetalleMesMovimiento, CargoPersona> idcargopersona;

}