package com.EduSteam.demo.Dto;

public class tetutorDto {

    private Long idtutor;
    private Long idusuario;
    private String biografia;
    private Integer anosExperiencia;
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