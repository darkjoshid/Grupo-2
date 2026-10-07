package com.EduSteam.demo.Dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class ttsesiontutoriaDto {

    private Long idtutor;
    private Long idestudiante;
    private Long idasignatura;
    private LocalDate fechasesion;
    private Time horainicio;
    private Time horafin;
    private String observaciones;

    public Long getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(Long idtutor) {
        this.idtutor = idtutor;
    }

    public Long getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Long getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Long idasignatura) {
        this.idasignatura = idasignatura;
    }

    public LocalDate getFechasesion() {
        return fechasesion;
    }

    public void setFechasesion(LocalDate fechasesion) {
        this.fechasesion = fechasesion;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

