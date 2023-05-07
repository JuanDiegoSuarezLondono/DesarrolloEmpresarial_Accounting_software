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
@Table(name="empresa",catalog="accounting_software")
public class Empresa implements Serializable {
    private static final long serialVersion=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Integer idEmpresa;
    
    @Column(name = "nombrempresa")
    private String nomEmpresa;
    
    @Column(name = "nit")
    private String nit;
    
    @Column(name = "telefono")
    private Integer telefono;
   
    @Column(name = "pais")
    private String pais;
    
    @Column(name = "departamento")
    private String departamento;
    
    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "correo")
    private String correo;
    
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<SalarioMinimo> salMinimo;
    
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Persona> persona;
    
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Cuenta> cuenta;

    public Empresa() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<SalarioMinimo> getSalMinimo() {
        return salMinimo;
    }

    public void setSalMinimo(List<SalarioMinimo> salMinimo) {
        this.salMinimo = salMinimo;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    public List<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}
