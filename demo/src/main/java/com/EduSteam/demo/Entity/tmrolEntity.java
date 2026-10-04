package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tm_rol", schema = "upc")
public class tmrolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer idrol;

    @Column(name = "nombrerol")
    private String nombreRol;

    @Column(name = "descripcionrol")
    private String descripcionRol;

    @Column(name = "estadorol")
    private Integer estadorol;



    public Integer getIdrol() { return idrol; }
    public void setIdrol(Integer idrol) { this.idrol = idrol; }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }

    public String getDescripcionRol() { return descripcionRol; }
    public void setDescripcionRol(String descripcionRol) { this.descripcionRol = descripcionRol; }

    public Integer getEstadorol() { return estadorol; }
    public void setEstadorol(Integer estadorol) { this.estadorol = estadorol; }
}
