package com.prueba.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="tm_provincia", schema = "upc")
public class ProvinciaEntity {

    @EmbeddedId
    private ProvinciaId id;

    @Column(name="NOMBRE")
    private String nombre_provincia;

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
    private DepartamentoEntity  departamento;


    public ProvinciaId getId() {
        return id;
    }

    public void setId(ProvinciaId id) {
        this.id = id;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
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

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }
}
