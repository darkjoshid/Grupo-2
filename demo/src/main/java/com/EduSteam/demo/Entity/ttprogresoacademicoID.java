package com.EduSteam.demo.Entity;

public class ttprogresoacademicoID {
    private Long idProgreso;
    private Long idEstudiante;
    private Long idAsignatura;
    private Integer calificacion;
    private String notasProgreso;
    private Boolean estadoProgreso;

    public Long getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Long idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getNotasProgreso() {
        return notasProgreso;
    }

    public void setNotasProgreso(String notasProgreso) {
        this.notasProgreso = notasProgreso;
    }

    public Boolean getEstadoProgreso() {
        return estadoProgreso;
    }

    public void setEstadoProgreso(Boolean estadoProgreso) {
        this.estadoProgreso = estadoProgreso;
    }
}
