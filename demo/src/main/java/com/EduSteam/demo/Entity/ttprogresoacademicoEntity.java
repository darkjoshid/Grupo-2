package com.EduSteam.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tt_progreso_academico", schema = "upc")

public class ttprogresoacademicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPROGRESO")
    private Long idProgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idestudiante",
            nullable = false)
    private teestudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idAsignatura",
            nullable = false)
    private tmasignaturaEntity asignatura;

    @Column(name = "CALIFICACION")
    private Integer calificacion;

    @Column(name = "NOTASPROGRESO")
    private String notasProgreso;

    @Column(name = "ESTADOPROGRESO")
    private Boolean estadoProgreso = true;
}
