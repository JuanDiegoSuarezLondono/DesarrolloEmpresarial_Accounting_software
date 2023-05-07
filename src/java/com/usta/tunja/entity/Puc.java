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
@Table(name="puc",catalog="accounting_software")
public class Puc implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpuc")
    private Integer idPuc;
    
    @Column(name = "codpuc")
    private Integer codPuc;
    
    @Column(name = "nombrepuc")
    private String nomPru;
    
    @OneToMany(mappedBy = "puc",cascade = CascadeType.ALL)
    private List<Cuenta> cuenta;

    public Puc() {
    }

    public Integer getIdPuc() {
        return idPuc;
    }

    public void setIdPuc(Integer idPuc) {
        this.idPuc = idPuc;
    }

    public Integer getCodPuc() {
        return codPuc;
    }

    public void setCodPuc(Integer codPuc) {
        this.codPuc = codPuc;
    }

    public String getNomPru() {
        return nomPru;
    }

    public void setNomPru(String nomPru) {
        this.nomPru = nomPru;
    }

    public List<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }
    
    
     
}
