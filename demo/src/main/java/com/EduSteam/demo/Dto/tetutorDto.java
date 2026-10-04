package com.EduSteam.demo.Dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
public class tetutorDto {
    private Long idtutor;

    private Long idusuario;

    @Size(max = 1000, message = "La biografía no puede superar los 1000 caracteres")
    private String biografia;

    @PositiveOrZero(message = "Los años de experiencia no pueden ser negativos")
    private Integer anosExperiencia;

    @PositiveOrZero(message = "La calificación no puede ser negativa")
    private Integer calificacion;

    private Boolean estadoTutor;

    public Long getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(Long idtutor) {
        this.idtutor = idtutor;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(Integer anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getEstadoTutor() {
        return estadoTutor;
    }

    public void setEstadoTutor(Boolean estadoTutor) {
        this.estadoTutor = estadoTutor;
    }
}
