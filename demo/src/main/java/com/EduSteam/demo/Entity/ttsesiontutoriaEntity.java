package com.EduSteam.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "tt_sesion_tutoria", schema = "upc")

public class ttsesiontutoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IDSESIONTUTORIA")
    private Long idSesionTutoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idTutor",
            nullable = false)
    private tetutorEntity tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idEstudiante",
            nullable = false)
    private teestudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idAsignatura",
            nullable = false)
    private tmasignaturaEntity asignatura;

    @Column(name ="FECHASESION")
    private Date fechaSesion;

    @Column(name ="HORAINICIO")
    private Time horaInicio;

    @Column(name ="HORAFIN")
    private Time horaFin;

    @Column(name ="OBSERVACIONES")
    private String observaciones;

    @Column(name ="ESTADO")
    private Boolean estado = true;


}
