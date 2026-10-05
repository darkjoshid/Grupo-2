package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tt_cuenta",schema="upc")
public class ttcuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Column(name="nombrecuenta")
    private String nombrecuenta;
    @Column(name="fecharegistrocuenta")
    private LocalDate fecharegistrocuenta;
    @Column(name="estadocuenta")
    private boolean estadocuenta;

    @ManyToOne
    @JoinColumn(
            name="idusuario",
            referencedColumnName = "idusuario"
    )
    private teusuarioEntity usuario;

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public LocalDate getFecharegistrocuenta() {
        return fecharegistrocuenta;
    }

    public void setFecharegistrocuenta(LocalDate fecharegistrocuenta) {
        this.fecharegistrocuenta = fecharegistrocuenta;
    }

    public boolean isEstadocuenta() {
        return estadocuenta;
    }

    public void setEstadocuenta(boolean estadocuenta) {
        this.estadocuenta = estadocuenta;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
