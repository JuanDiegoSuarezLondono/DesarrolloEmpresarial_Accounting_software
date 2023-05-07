package com.usta.tunja.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cargo_persona", catalog = "accounting_software")
public class CargoPersona implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcargopersona")
    private Integer idCargoPersona;

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "idcargopersona", cascade = CascadeType.ALL)
    private List<DetalleMesMovimiento> detalleMovimiento;
    
    @OneToMany(mappedBy = "idcargopersona", cascade = CascadeType.ALL)
    private List<DetalleMes> detalleMes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo", nullable = false)
    private Cargo cargo;

    public CargoPersona() {
    }

    public Integer getIdCargoPersona() {
        return idCargoPersona;
    }

    public void setIdCargoPersona(Integer idCargoPersona) {
        this.idCargoPersona = idCargoPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<DetalleMesMovimiento> getDetalleMovimiento() {
        return detalleMovimiento;
    }

    public void setDetalleMovimiento(List<DetalleMesMovimiento> detalleMovimiento) {
        this.detalleMovimiento = detalleMovimiento;
    }

    public List<DetalleMes> getDetalleMes() {
        return detalleMes;
    }

    public void setDetalleMes(List<DetalleMes> detalleMes) {
        this.detalleMes = detalleMes;
    }
    
    

}
