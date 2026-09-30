package com.EduSteam.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tt_sesion_tutoria", schema = "upc")
public class ttSesionTutoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSESION")
    private Integer idSesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtutor", foreignKey = @ForeignKey(name = "fk_sesion_tutor"))
    private teTurorEntity tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestudiante", foreignKey = @ForeignKey(name = "fk_sesion_estudiante"))
    private teEstudianteEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idasignatura", foreignKey = @ForeignKey(name = "fk_sesion_asignatura"))
    private tmAsignaturaEntity asignatura;

    @Column(name = "FECHASESION")
    private Date fechaSesion;

    @Column(name = "HORAINICIO")
    private LocalTime horaInicio;

    @Column(name = "HORAFIN")
    private LocalTime horaFin;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

}
