package com.EduSteam.demo.Dto;

public class ttprogresoacademicoDto {

    private Long idEstudiante;
    private Long idAsignatura;
    private Integer calificacion;
    private String notasProgreso;

    // Getters y Setters
    public Long getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(Long idEstudiante) { this.idEstudiante = idEstudiante; }

    public Long getIdAsignatura() { return idAsignatura; }
    public void setIdAsignatura(Long idAsignatura) { this.idAsignatura = idAsignatura; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public String getNotasProgreso() { return notasProgreso; }
    public void setNotasProgreso(String notasProgreso) { this.notasProgreso = notasProgreso; }
}