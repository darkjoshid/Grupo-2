package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "te_estudiante", schema = "upc")
public class teestudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestudiante")
    private Long idestudiante;

    @Column(name = "nivelescolar")
    private Integer nivelescolar;

    @Column(name = "escuela")
    private String escuela;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "estadoestudiante")
    private Integer estadoestudiante;

    @ManyToOne(cascade = CascadeType.PERSIST)
            @JoinColumn(
                    name = "idpadre",
                    referencedColumnName = "idpadre"
            )
    private tepadreEntity padre;

    @ManyToOne(cascade = CascadeType.PERSIST)
            @JoinColumn(
                    name = "idusuario",
                    referencedColumnName = "idusuario"
            )
    private teusuarioEntity usuario;

    public Long getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Integer getNivelescolar() {
        return nivelescolar;
    }

    public void setNivelescolar(Integer nivelescolar) {
        this.nivelescolar = nivelescolar;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEstadoestudiante() {
        return estadoestudiante;
    }

    public void setEstadoestudiante(Integer estadoestudiante) {
        this.estadoestudiante = estadoestudiante;
    }

    public tepadreEntity getPadre() {
        return padre;
    }

    public void setPadre(tepadreEntity padre) {
        this.padre = padre;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
