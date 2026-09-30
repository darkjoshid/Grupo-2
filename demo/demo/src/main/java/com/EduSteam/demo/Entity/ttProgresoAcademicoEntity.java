package com.EduSteam.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tt_progreso_academico", schema = "upc")
public class ttProgresoAcademicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogreso")
    private Integer idProgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestudiante", foreignKey = @ForeignKey(name = "fk_progreso_estudiante"))
    private teEstudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmateria")
    private tmAsignaturaEntity materia;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "notasprogreso", columnDefinition = "TEXT")
    private String notasProgreso;
}
