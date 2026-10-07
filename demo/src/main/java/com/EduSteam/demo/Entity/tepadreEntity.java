package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "te_padre", schema = "upc")
public class tepadreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpadre")
    private Long idpadre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "contactoemergencia")
    private String contactoemergencia;

    @Column(name = "relacionconestudiante")
    private String relacionconestudiante;

    @Column(name = "estadopadre")
    private Integer estadopadre;

    @ManyToOne(cascade = CascadeType.PERSIST)
            @JoinColumn(
                    name = "idusuario",
                    referencedColumnName = "idusuario"
            )
    private teusuarioEntity usuario;

    public Long getIdpadre() {
        return idpadre;
    }

    public void setIdpadre(Long idpadre) {
        this.idpadre = idpadre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContactoemergencia() {
        return contactoemergencia;
    }

    public void setContactoemergencia(String contactoemergencia) {
        this.contactoemergencia = contactoemergencia;
    }

    public String getRelacionconestudiante() {
        return relacionconestudiante;
    }

    public void setRelacionconestudiante(String relacionconestudiante) {
        this.relacionconestudiante = relacionconestudiante;
    }

    public Integer getEstadopadre() {
        return estadopadre;
    }

    public void setEstadopadre(Integer estadopadre) {
        this.estadopadre = estadopadre;
    }

    public teusuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(teusuarioEntity usuario) {
        this.usuario = usuario;
    }
}
