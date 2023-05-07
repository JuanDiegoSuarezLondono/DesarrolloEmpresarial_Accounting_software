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
@Table(name="salariominimo",catalog="accounting_software")
public class SalarioMinimo implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsalariominimo")
    private Integer idSalMinimo;
    
    @Column(name = "año")
    private Integer year;
    
    @Column(name = "salario")
    private Float salario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idempresa", referencedColumnName = "idempresa", nullable=false)
    private Empresa empresa;

    public SalarioMinimo() {
    }

    public Integer getIdSalMinimo() {
        return idSalMinimo;
    }

    public void setIdSalMinimo(Integer idSalMinimo) {
        this.idSalMinimo = idSalMinimo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
}
