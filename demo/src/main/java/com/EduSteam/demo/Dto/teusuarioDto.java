package com.EduSteam.demo.Dto;

import com.EduSteam.demo.Entity.rolID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class teusuarioDto {


    private Integer idusuario;

    private String nombreusuario;

    private String contrasenia;

    private String nombre;

    private String apellido;

    private String correo;

    private Integer estadousuario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "idrol",
            referencedColumnName = "idrol"
    )
    private rolID idrolRol;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public rolID getIdrolRol() {
        return idrolRol;
    }

    public void setIdrolRol(rolID idrolRol) {
        this.idrolRol = idrolRol;
    }
}
