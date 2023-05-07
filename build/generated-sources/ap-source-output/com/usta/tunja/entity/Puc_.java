package com.usta.tunja.entity;

import com.usta.tunja.entity.Cuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T10:56:33")
@StaticMetamodel(Puc.class)
public class Puc_ { 

    public static volatile SingularAttribute<Puc, String> nomPru;
    public static volatile SingularAttribute<Puc, Integer> idPuc;
    public static volatile ListAttribute<Puc, Cuenta> cuenta;
    public static volatile SingularAttribute<Puc, Integer> codPuc;

}