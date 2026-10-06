package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tm_asignatura", schema = "upc")

public class tmasignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignatura")
    private Long idasignatura;

    @ManyToOne
    @JoinColumn(name = "idtutor", nullable = false)
    private tetutorEntity tutor;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "estadoasignatura")
    private Boolean estadoAsignatura;

    public Long getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Long idasignatura) {
        this.idasignatura = idasignatura;
    }

    public tetutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(tetutorEntity tutor) {
        this.tutor = tutor;
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