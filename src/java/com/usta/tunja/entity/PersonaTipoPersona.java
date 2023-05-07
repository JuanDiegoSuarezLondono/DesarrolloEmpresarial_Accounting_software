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
@Table(name="persona_tipopersona",catalog="accounting_software")
public class PersonaTipoPersona implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersonatipopersona")
    private Integer idpersonatipopersona;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpersona", referencedColumnName = "idpersona", nullable=false)
    private Persona persona;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idtipopersona", referencedColumnName = "idtipopersona", nullable=false)
    private TipoPersona tipoPer;
    
    @OneToMany(mappedBy = "perTipoPer",cascade = CascadeType.ALL)
    private List<CuentaPersona> cuentaPer;
    
    @OneToMany(mappedBy = "idPerTipoPer",cascade = CascadeType.ALL)
    private List<DetalleMesMovimiento> detalleMov;

    public PersonaTipoPersona() {
    }

    public Integer getIdPerTipoPer() {
        return idpersonatipopersona;
    }

    public void setIdPerTipoPer(Integer idPerTipoPer) {
        this.idpersonatipopersona = idPerTipoPer;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoPersona getTipoPer() {
        return tipoPer;
    }

    public void setTipoPer(TipoPersona tipoPer) {
        this.tipoPer = tipoPer;
    }

    public List<CuentaPersona> getCuentaPer() {
        return cuentaPer;
    }

    public void setCuentaPer(List<CuentaPersona> cuentaPer) {
        this.cuentaPer = cuentaPer;
    }

    public List<DetalleMesMovimiento> getDetalleMov() {
        return detalleMov;
    }

    public void setDetalleMov(List<DetalleMesMovimiento> detalleMov) {
        this.detalleMov = detalleMov;
    }
    
    
}
