package com.EduSteam.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tt_progreso_academico", schema = "upc")

public class ttprogresoacademicoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogreso")
    private Long idProgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestudiante", nullable = false)
    private teestudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmateria", nullable = false)
    private tmasignaturaEntity asignatura;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "notasprogreso", length = 1000)
    private String notasProgreso;

    @Column(name = "estadoprogreso")
    private Boolean estadoProgreso;

    public Long getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Long idProgreso) {
        this.idProgreso = idProgreso;
    }

    public teestudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(teestudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    public tmasignaturaEntity getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(tmasignaturaEntity asignatura) {
        this.asignatura = asignatura;
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
