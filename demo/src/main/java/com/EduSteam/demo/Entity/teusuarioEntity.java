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

    @Column(name = "nombreusuario")
    private String nombreusuario;


    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "estadousuario")
    private Integer estadousuario;

    @ManyToOne(cascade = CascadeType.PERSIST)
            @JoinColumn(
                    name = "idrol",
                    referencedColumnName = "idrol"
            )
    private tmrolEntity rol;


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(Integer estadousuario) {
        this.estadousuario = estadousuario;
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

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public tmrolEntity getRol() {
        return rol;
    }

    public void setRol(tmrolEntity rol) {
        this.rol = rol;
    }
}
