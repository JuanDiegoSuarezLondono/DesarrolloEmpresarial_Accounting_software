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
@Table(name="factura",catalog="accounting_software")
public class Factura implements Serializable{
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private Integer idFactura;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "fechavencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechavencimiento;
    
    @Column(name = "cliente")
    private String cliente;
    
    @Column(name = "tipodocumento")
    private String tipoDoc;
    
    @Column(name = "numerodocumento")
    private Integer numDoc;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private Integer telefono;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "formapago")
    private String forPago;
    
    @Column(name = "ordencompra")
    private String ordenCompra;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "detalle")
    private String detalle;
    
    @Column(name = "valorunitario")
    private Float valorUni;
    
    @Column(name = "valortotal")
    private Float valorTotal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpersona", referencedColumnName = "idpersona", nullable=false)
    private Persona persona;
    
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
    private List<DetalleMesMovimiento> detalleMov;

    public Factura() {
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getForPago() {
        return forPago;
    }

    public void setForPago(String forPago) {
        this.forPago = forPago;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getValorUni() {
        return valorUni;
    }

    public void setValorUni(Float valorUni) {
        this.valorUni = valorUni;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<DetalleMesMovimiento> getDetalleMov() {
        return detalleMov;
    }

    public void setDetalleMov(List<DetalleMesMovimiento> detalleMov) {
        this.detalleMov = detalleMov;
    }
    
    
    
}
