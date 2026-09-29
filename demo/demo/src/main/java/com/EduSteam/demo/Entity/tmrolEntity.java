package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tm_rol", schema = "upc")
public class tmrolEntity {
    @EmbeddedId
    private rolID idrol;

    @Column(name = "nombrerol")
    private String nombreRol;

    @Column(name = "descripcionrol")
    private String descripcionRol;

    @ManyToOne
    @JoinColumn(
            name="idusuario",
            insertable = false,
            updatable = false
    )
    private teusuarioEntity usuario;

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public rolID getIdrol() {
        return idrol;
    }

    public void setIdrol(rolID idrol) {
        this.idrol = idrol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
