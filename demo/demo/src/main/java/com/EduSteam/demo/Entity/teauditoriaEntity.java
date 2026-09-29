package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ta_auditoria", schema = "upc")
public class teauditoriaEntity {
    @EmbeddedId
    private auditoriaID id;

    @Column(name = "fechaauditoria")
    private LocalDate fechaAuditoria;

    @Column(name = "tipoauditoria")
    private String tipoAuditoria;

    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(
            name="idusuario",
            insertable = false,
            updatable = false
    )
    private teusuarioEntity usuario;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(LocalDate fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }

    public auditoriaID getId() {
        return id;
    }

    public void setId(auditoriaID id) {
        this.id = id;
    }

    public String getTipoAuditoria() {
        return tipoAuditoria;
    }

    public void setTipoAuditoria(String tipoAuditoria) {
        this.tipoAuditoria = tipoAuditoria;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
