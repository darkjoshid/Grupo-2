package com.EduSteam.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class tmasignaturaDto {
    private Long idasignatura;

    private Long idtutor;

    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    @PositiveOrZero(message = "El nivel no puede ser negativo")
    private Integer nivel;

    private Boolean estadoAsignatura;

    public Long getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Long idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Long getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(Long idtutor) {
        this.idtutor = idtutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Boolean getEstadoAsignatura() {
        return estadoAsignatura;
    }

    public void setEstadoAsignatura(Boolean estadoAsignatura) {
        this.estadoAsignatura = estadoAsignatura;
    }
}
