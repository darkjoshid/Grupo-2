package com.EduSteam.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;

@Embeddable
public class rolID   implements Serializable {

    @Column(name="idusuario")
    private Long idusuario;
    @Column(name="idrol")
    private rolID idrol;

    public rolID getIdrol() {
        return idrol;
    }

    public void setIdrol(rolID idrol) {
        this.idrol = idrol;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }
}
