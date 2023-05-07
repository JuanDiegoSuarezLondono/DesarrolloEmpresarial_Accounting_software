package com.usta.tunja.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="detallemovimiento",catalog="accounting_software")
public class DetalleMesMovimiento implements Serializable{
    
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallemovimiento")
    private Integer idDetalleMovimiento;
    
    @Column(name = "tipodocumento")
    private String tipoDoc;
    
    @Column(name = "fechainicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "fechafin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechafin;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcuenta", referencedColumnName = "idcuenta", nullable=false)
    private Cuenta cuenta;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpersonatipopersona", referencedColumnName = "idpersonatipopersona", nullable=false)
    private PersonaTipoPersona idPerTipoPer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcargopersona", referencedColumnName = "idcargopersona", nullable=false)
    private CargoPersona idcargopersona;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idfactura", referencedColumnName = "idfactura", nullable=false)
    private Factura factura;

    public DetalleMesMovimiento() {
    }

    public Integer getIdDetalleMovimiento() {
        return idDetalleMovimiento;
    }

    public void setIdDetalleMovimiento(Integer idDetalleMovimiento) {
        this.idDetalleMovimiento = idDetalleMovimiento;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public PersonaTipoPersona getPerTipoPer() {
        return idPerTipoPer;
    }

    public void setPerTipoPer(PersonaTipoPersona perTipoPer) {
        this.idPerTipoPer = perTipoPer;
    }

    public CargoPersona getCargoPer() {
        return idcargopersona;
    }

    public void setCargoPer(CargoPersona cargoPer) {
        this.idcargopersona = cargoPer;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
}