package com.EduSteam.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tt_sesion_tutoria", schema = "upc")

public class ttsesiontutoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsesion")
    private Long idSesion;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtutor", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private tetutorEntity tutor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idestudiante", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private teestudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idasignatura", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private tmasignaturaEntity asignatura;

    @Column(name = "fechasession")
    private LocalDate fechaSesion;

    @Column(name = "horainicio")
    private LocalTime horaInicio;

    @Column(name = "horafin")
    private LocalTime horaFin;

    @Column(name = "estado", length = 50)
    private Boolean estado;

    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public tetutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(tetutorEntity tutor) {
        this.tutor = tutor;
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

    public LocalDate getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(LocalDate fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}