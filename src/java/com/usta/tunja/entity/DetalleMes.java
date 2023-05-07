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
@Table(name="detallemes",catalog="accounting_software")
public class DetalleMes implements Serializable{
    private static final long serialVersion=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallemes")
    private Integer idDetalleMes;
    
    @Column(name = "diastrabajados")
    private Integer diasTrabajados;
    
    @Column(name = "horasextras")
    private Integer horasExtras;
    
    @Column(name = "cantidadsalario")
    private Float cantidadTrabajo;
    
    @Column(name = "auxiliocantidad")
    private Float auxlioCantidad;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcargopersona", referencedColumnName = "idcargopersona", nullable=false)
    private CargoPersona idcargopersona;

    public DetalleMes() {
    }

    public Integer getIdDetalleMes() {
        return idDetalleMes;
    }

    public void setIdDetalleMes(Integer idDetalleMes) {
        this.idDetalleMes = idDetalleMes;
    }

    public Integer getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(Integer diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public Integer getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Integer horasExtras) {
        this.horasExtras = horasExtras;
    }

    public Float getCantidadTrabajo() {
        return cantidadTrabajo;
    }

    public void setCantidadTrabajo(Float cantidadTrabajo) {
        this.cantidadTrabajo = cantidadTrabajo;
    }

    public Float getAuxlioCantidad() {
        return auxlioCantidad;
    }

    public void setAuxlioCantidad(Float auxlioCantidad) {
        this.auxlioCantidad = auxlioCantidad;
    }

    public CargoPersona getCargoPersona() {
        return idcargopersona;
    }

    public void setCargoPersona(CargoPersona cargoPersona) {
        this.idcargopersona = cargoPersona;
    }
    
    
}
