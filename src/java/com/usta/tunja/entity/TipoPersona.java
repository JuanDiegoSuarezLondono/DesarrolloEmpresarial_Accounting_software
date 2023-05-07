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
@Table(name="tipopersona",catalog="accounting_software")
public class TipoPersona implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipopersona")
    private Integer idTipoPer;
    
    @Column(name = "nombretipopersona")
    private String nomTipoPer;
    
    @OneToMany(mappedBy = "tipoPer",cascade = CascadeType.ALL)
    private List<PersonaTipoPersona> perTipoPer;

    public TipoPersona() {
    }

    public Integer getIdTipoPer() {
        return idTipoPer;
    }

    public void setIdTipoPer(Integer idTipoPer) {
        this.idTipoPer = idTipoPer;
    }

    public String getNomTipoPer() {
        return nomTipoPer;
    }

    public void setNomTipoPer(String nomTipoPer) {
        this.nomTipoPer = nomTipoPer;
    }

    public List<PersonaTipoPersona> getPerTipoPer() {
        return perTipoPer;
    }

    public void setPerTipoPer(List<PersonaTipoPersona> perTipoPer) {
        this.perTipoPer = perTipoPer;
    }
    
    
}
