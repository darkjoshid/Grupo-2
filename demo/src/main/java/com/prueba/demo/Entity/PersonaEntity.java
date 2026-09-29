package com.prueba.demo.Entity;

import jakarta.persistence.*;



@Entity
@Table(name="tm_persona", schema="upc")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PERSONA")
    private Long idpersona;

    @Column(name="NOMBRES")
    private String nombre_persona;

    @Column(name="APELLIDOS")
    private String apellido_persona;

    @Column(name="DNI")
    private String dni_persona;

    @Column(name="EDAD")
    private Integer edad_persona;

    @Column(name="ESTADO")
    private Integer estado;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(
                    name = "iddepartamento",
                    referencedColumnName = "iddepartamento"
            ),
            @JoinColumn(
                    name = "idprovincia",
                    referencedColumnName = "idprovincia"
            ),
            @JoinColumn(
                    name = "iddistrito",
                    referencedColumnName = "iddistrito"
            )
    })

    private DistritoEntity distrito;

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        this.apellido_persona = apellido_persona;
    }

    public String getDni_persona() {
        return dni_persona;
    }

    public void setDni_persona(String dni_persona) {
        this.dni_persona = dni_persona;
    }

    public Integer getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(Integer edad_persona) {
        this.edad_persona = edad_persona;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public DistritoEntity getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoEntity distrito) {
        this.distrito = distrito;
    }
}
