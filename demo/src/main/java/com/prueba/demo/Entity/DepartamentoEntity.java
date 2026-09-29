package com.prueba.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tm_departamento", schema = "upc")
public class DepartamentoEntity {

    @Id
    @Column(name="IDDEPARTAMENTO")
    private String iddepartamento;

    @Column(name="NOMBRE")
    private String nombre_departamento;

    @Column(name="FLAG_PACIENTE")
    private Boolean flag_paciente;

    @Column(name="ESTADO")
    private Integer estado;


    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
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
}
