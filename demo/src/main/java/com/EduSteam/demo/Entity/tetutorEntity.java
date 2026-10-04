package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "te_tutor", schema = "upc")

public class tetutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtutor")
    private Long idtutor;

    @OneToOne
    @JoinColumn(name = "idusuario", nullable = false, unique = true)
    private teusuarioEntity usuario;

    @Column(name = "biografia", length = 1000)
    private String biografia;

    @Column(name = "anosexperiencia")
    private Integer anosExperiencia;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "estadotutor")
    private Boolean estadoTutor;

    public Long getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(Long idtutor) {
        this.idtutor = idtutor;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
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
