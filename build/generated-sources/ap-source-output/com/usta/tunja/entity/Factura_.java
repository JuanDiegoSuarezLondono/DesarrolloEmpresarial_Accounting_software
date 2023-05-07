package com.usta.tunja.entity;

import com.usta.tunja.entity.DetalleMesMovimiento;
import com.usta.tunja.entity.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Persona> persona;
    public static volatile SingularAttribute<Factura, String> direccion;
    public static volatile SingularAttribute<Factura, String> ordenCompra;
    public static volatile SingularAttribute<Factura, Integer> numDoc;
    public static volatile SingularAttribute<Factura, Date> fechavencimiento;
    public static volatile SingularAttribute<Factura, String> detalle;
    public static volatile SingularAttribute<Factura, Float> valorUni;
    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, String> cliente;
    public static volatile SingularAttribute<Factura, String> forPago;
    public static volatile SingularAttribute<Factura, String> ciudad;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, Float> valorTotal;
    public static volatile SingularAttribute<Factura, String> tipoDoc;
    public static volatile SingularAttribute<Factura, Integer> cantidad;
    public static volatile SingularAttribute<Factura, Integer> telefono;
    public static volatile ListAttribute<Factura, DetalleMesMovimiento> detalleMov;

}