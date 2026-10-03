package com.EduSteam.demo.Dto;

import com.EduSteam.demo.Entity.rolID;
import com.EduSteam.demo.Entity.teusuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.CriteriaBuilder;

public class tmrolDto {

    @EmbeddedId
    private rolID idrol;

    private String nombreRol;

    private String descripcionRol;

    private Integer  estadorol;

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

    public Integer getEstadorol() {
        return estadorol;
    }

    public void setEstadorol(Integer estadorol) {
        this.estadorol = estadorol;
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
