package com.usta.tunja.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cargo",catalog="accounting_software")
public class Cargo implements Serializable {
    private static final long serialVersion=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcargo")
    private Integer idCargo;
    
    @Column(name = "nombrecargo")
    private String nombreCargo;
    
    @Column(name="ibc")
    private Integer ibc;
    
    @Column(name="horaordinaria")
    private Float horaOrdinaria;
    
    @Column(name="salariobasico")
    private Float salarioBasico;
    
    @Column(name="auxtransporte")
    private Float auxTransporte;
    
    @Column(name="horasextras")
    private Float horasExtras;
    
    @OneToMany(mappedBy = "cargo",cascade = CascadeType.ALL)
    private List<CargoPersona> cargoPersona;

    public Cargo() {
    }
    
    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Integer getIbc() {
        return ibc;
    }

    public void setIbc(Integer ibc) {
        this.ibc = ibc;
    }

    public Float getHoraOrdinaria() {
        return horaOrdinaria;
    }

    public void setHoraOrdinaria(Float horaOrdinaria) {
        this.horaOrdinaria = horaOrdinaria;
    }

    public Float getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(Float salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public Float getAuxTransporte() {
        return auxTransporte;
    }

    public void setAuxTransporte(Float auxTransporte) {
        this.auxTransporte = auxTransporte;
    }

    public Float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Float horasExtras) {
        this.horasExtras = horasExtras;
    }

    public List<CargoPersona> getCargoPersona() {
        return cargoPersona;
    }

    public void setCargoPersona(List<CargoPersona> cargoPersona) {
        this.cargoPersona = cargoPersona;
    }
    
}
