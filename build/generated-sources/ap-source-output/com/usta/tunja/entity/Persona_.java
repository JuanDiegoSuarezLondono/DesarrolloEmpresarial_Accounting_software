package com.usta.tunja.entity;

import com.usta.tunja.entity.CargoPersona;
import com.usta.tunja.entity.Empresa;
import com.usta.tunja.entity.Factura;
import com.usta.tunja.entity.PersonaTipoPersona;
import com.usta.tunja.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile ListAttribute<Persona, PersonaTipoPersona> perTipoPer;
    public static volatile SingularAttribute<Persona, String> segundoNombre;
    public static volatile ListAttribute<Persona, Factura> factura;
    public static volatile SingularAttribute<Persona, String> primerNombre;
    public static volatile SingularAttribute<Persona, String> primerApellido;
    public static volatile SingularAttribute<Persona, Integer> numeroDoc;
    public static volatile SingularAttribute<Persona, String> segundoApellido;
    public static volatile SingularAttribute<Persona, String> tipoDoc;
    public static volatile ListAttribute<Persona, CargoPersona> cargoPer;
    public static volatile ListAttribute<Persona, Usuario> usuario;
    public static volatile SingularAttribute<Persona, Empresa> empresa;
    public static volatile SingularAttribute<Persona, Integer> idPersona;

}