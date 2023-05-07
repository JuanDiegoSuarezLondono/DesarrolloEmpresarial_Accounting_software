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
import javax.persistence.Table;

@Entity
@Table(name="persona",catalog="accounting_software")
public class Persona implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Integer idPersona;
    
    @Column(name = "primernombre")
    private String primerNombre;
    
    @Column(name = "segundonombre")
    private String segundoNombre;
    
    @Column(name = "primerapellido")
    private String primerApellido;
    
    @Column(name = "segundoapellido")
    private String segundoApellido;
    
    @Column(name = "tipodocumento")
    private String tipoDoc;
    
    @Column(name = "numerodocumento")
    private Integer numeroDoc;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idempresa", referencedColumnName = "idempresa", nullable=false)   
    private Empresa empresa;
    
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    private List<CargoPersona> cargoPer;
     
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    private List<PersonaTipoPersona> perTipoPer;
    
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    private List<Usuario> usuario;
    
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    private List<Factura> factura;

    public Persona() {
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Integer getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(Integer numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<CargoPersona> getCargoPer() {
        return cargoPer;
    }

    public void setCargoPer(List<CargoPersona> cargoPer) {
        this.cargoPer = cargoPer;
    }

    public List<PersonaTipoPersona> getPerTipoPer() {
        return perTipoPer;
    }

    public void setPerTipoPer(List<PersonaTipoPersona> perTipoPer) {
        this.perTipoPer = perTipoPer;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }
       
}
