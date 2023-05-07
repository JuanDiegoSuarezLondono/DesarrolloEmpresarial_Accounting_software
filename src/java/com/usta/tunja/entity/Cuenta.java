package com.usta.tunja.entity;

import java.io.Serializable;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta", catalog = "accounting_software")
public class Cuenta implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private Integer idCuenta;

    @Column(name = "idsubcuenta")
    private Integer idSubCuenta;

    @Column(name = "detalle")
    private String detalle;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<CuentaPersona> cuentaPersona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipocuenta", referencedColumnName = "idtipocuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpuc", referencedColumnName = "idpuc", nullable = false)
    private Puc puc;

    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    private Cuenta cuentapadre;

    @OneToMany(mappedBy = "cuentapadre", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;

    public Cuenta() {
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdSubCuenta() {
        return idSubCuenta;
    }

    public void setIdSubCuenta(Integer idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<CuentaPersona> getCuentaPersona() {
        return cuentaPersona;
    }

    public void setCuentaPersona(List<CuentaPersona> cuentaPersona) {
        this.cuentaPersona = cuentaPersona;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Puc getPuc() {
        return puc;
    }

    public void setPuc(Puc puc) {
        this.puc = puc;
    }

    public Cuenta getCuentapadre() {
        return cuentapadre;
    }

    public void setCuentapadre(Cuenta cuentapadre) {
        this.cuentapadre = cuentapadre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
