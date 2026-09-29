package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "te_padre", schema = "upc")
public class tepadreEntity {
    @EmbeddedId
    private PadreID padreid;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "contactoemergencia")
    private String contactoEmergencia;

    @Column(name = "relacionconestudiante")
    private String relacionConEstudiante;

    @ManyToOne
    @JoinColumn(
            name="idusuario",
            insertable = false,
            updatable = false
    )
    private teusuarioEntity usuario;

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public PadreID getPadreid() {
        return padreid;
    }

    public void setPadreid(PadreID padreid) {
        this.padreid = padreid;
    }

    public String getRelacionConEstudiante() {
        return relacionConEstudiante;
    }

    public void setRelacionConEstudiante(String relacionConEstudiante) {
        this.relacionConEstudiante = relacionConEstudiante;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
