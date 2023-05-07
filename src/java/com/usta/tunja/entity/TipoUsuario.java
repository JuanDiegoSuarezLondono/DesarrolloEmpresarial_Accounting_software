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
@Table(name="tipousuario",catalog="accounting_software")
public class TipoUsuario implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipousuario")
    private Integer idTipoUsuario;
    
    @Column(name = "nombretipousuario")
    private String nomTipoUsuario;
    
    @OneToMany(mappedBy = "tipoUsuario",cascade = CascadeType.ALL)
    private List<Usuario> usuario;

    public TipoUsuario() {
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNomTipoUsuario() {
        return nomTipoUsuario;
    }

    public void setNomTipoUsuario(String nomTipoUsuario) {
        this.nomTipoUsuario = nomTipoUsuario;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    
}
