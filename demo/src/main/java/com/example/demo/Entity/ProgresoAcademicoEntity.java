package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tt_progreso_academico", schema = "upc")

public class ProgresoAcademicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPROGRESO")
    private Long idProgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idEstudiante",
            nullable = false)
    private EstudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idAsignatura",
            nullable = false)
    private AsignaturaEntity asignatura;

    @Column(name = "CALIFICACION")
    private Integer calificacion;

    @Column(name = "NOTASPROGRESO")
    private String notasProgreso;

    @Column(name = "ESTADOPROGRESO")
    private Boolean estadoProgreso = true;
}
