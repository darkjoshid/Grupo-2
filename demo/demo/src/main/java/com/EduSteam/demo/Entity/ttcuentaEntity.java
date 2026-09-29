package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tt_cuenta", schema = "upc")
public class ttcuentaEntity {
    @EmbeddedId
    private CuentaID idCuenta;

    @Column(name = "nombrecuenta")
    private String nombreCuenta;

    @Column(name = "estadocuenta")
    private String estadoCuenta;

    @Column(name = "fecharegistrocuenta")
    private LocalDateTime fechaRegistroCuenta;

    @ManyToOne
    @JoinColumn(
            name="idusuario",
            insertable = false,
            updatable = false
    )
    private teusuarioEntity usuario;

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDateTime getFechaRegistroCuenta() {
        return fechaRegistroCuenta;
    }

    public void setFechaRegistroCuenta(LocalDateTime fechaRegistroCuenta) {
        this.fechaRegistroCuenta = fechaRegistroCuenta;
    }

    public CuentaID getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaID idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
