package com.prueba.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tm_distrito", schema = "upc")
public class DistritoEntity {

    @EmbeddedId
    private DistritoId id;

    @Column(name="NOMBRE")
    private String nombre_distrito;

    @Column(name="FLAG_PACIENTE")
    private Boolean flag_paciente;

    @Column(name="ESTADO")
    private Integer estado;

    @ManyToOne
    @JoinColumn(
            name="iddepartamento",
            insertable = false,
            updatable = false
    )
     @JoinColumn(
            name="idprovincia",
            insertable = false,
            updatable = false
    )
    private ProvinciaEntity provincia;

    public DistritoId getId() {
        return id;
    }

    public void setId(DistritoId id) {
        this.id = id;
    }

    public String getNombre_distrito() {
        return nombre_distrito;
    }

    public void setNombre_distrito(String nombre_distrito) {
        this.nombre_distrito = nombre_distrito;
    }

    public Boolean getFlag_paciente() {
        return flag_paciente;
    }

    public void setFlag_paciente(Boolean flag_paciente) {
        this.flag_paciente = flag_paciente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public ProvinciaEntity getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEntity provincia) {
        this.provincia = provincia;
    }
}
