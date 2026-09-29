package com.prueba.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="author")
public class AutorEntity {

    @Id
    @Column(name="ID_AUTHOR")
    private Long idautor;

    @Column(name="BIRTH_DATE_AUTHOR")
    private Date cumple;

    @Column(name="BIOGRAPHY_AUTHOR")
    private String biografia;

    @Column(name="LAST_NAME_AUTHOR")
    private String ap_paterno;

    @Column(name="LEVEL_AUTHOR")
    private Integer level;

    @Column(name="NAME_AUTHOR")
    private String nombre;


    public Long getIdautor() {
        return idautor;
    }

    public void setIdautor(Long idautor) {
        this.idautor = idautor;
    }

    public Date getCumple() {
        return cumple;
    }

    public void setCumple(Date cumple) {
        this.cumple = cumple;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
