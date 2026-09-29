package com.EduSteam.demo.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.time.LocalDateTime;

@Entity
@Table(name="te_usuarios", schema = "upc")
public class teusuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="correo")
    private String correo;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name="activo")
    private Boolean activo ;

    @Column(name = "fechacreacion")
    private LocalDateTime fechaCreacion;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
