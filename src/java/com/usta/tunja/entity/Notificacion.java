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
@Table(name="notificacion",catalog="accounting_software")
public class Notificacion implements Serializable {
    private static final long serialVersion=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotificacion")
    private Integer idNotify;
            
    @Column(name = "detalle")
    private String detalle;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idusuario", referencedColumnName = "idusuario", nullable=false)
    private Usuario usuario;

    public Notificacion() {
    }

    public Integer getIdNotify() {
        return idNotify;
    }

    public void setIdNotify(Integer idNotify) {
        this.idNotify = idNotify;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
