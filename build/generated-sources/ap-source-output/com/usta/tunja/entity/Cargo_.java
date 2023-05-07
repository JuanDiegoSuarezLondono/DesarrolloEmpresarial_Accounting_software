package com.usta.tunja.entity;

import com.usta.tunja.entity.CargoPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Integer> idCargo;
    public static volatile SingularAttribute<Cargo, Float> horaOrdinaria;
    public static volatile SingularAttribute<Cargo, String> nombreCargo;
    public static volatile ListAttribute<Cargo, CargoPersona> cargoPersona;
    public static volatile SingularAttribute<Cargo, Float> salarioBasico;
    public static volatile SingularAttribute<Cargo, Float> auxTransporte;
    public static volatile SingularAttribute<Cargo, Float> horasExtras;
    public static volatile SingularAttribute<Cargo, Integer> ibc;

}