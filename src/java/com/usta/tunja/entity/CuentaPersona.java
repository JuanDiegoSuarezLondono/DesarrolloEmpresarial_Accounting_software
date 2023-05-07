/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_persona",catalog="accounting_software")
public class CuentaPersona implements Serializable{
    private static final long serialVersion=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuentapersona")
    private Integer idCuentaPersona;
    
    @Column(name = "valorcuenta")
    private Float valorCuenta;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpersonatipopersona", referencedColumnName = "idpersonatipopersona", nullable=false)
    private PersonaTipoPersona perTipoPer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcuenta", referencedColumnName = "idcuenta", nullable=false)
    private Cuenta cuenta;

    public CuentaPersona() {
    }

    public Integer getIdCuentaPersona() {
        return idCuentaPersona;
    }

    public void setIdCuentaPersona(Integer idCuentaPersona) {
        this.idCuentaPersona = idCuentaPersona;
    }

    public Float getValorCuenta() {
        return valorCuenta;
    }

    public void setValorCuenta(Float valorCuenta) {
        this.valorCuenta = valorCuenta;
    }

    public PersonaTipoPersona getPerTipoPer() {
        return perTipoPer;
    }

    public void setPerTipoPer(PersonaTipoPersona perTipoPer) {
        this.perTipoPer = perTipoPer;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    

    
    
}
