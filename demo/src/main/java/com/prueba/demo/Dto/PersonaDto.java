package com.prueba.demo.Dto;



public class PersonaDto {


    private Long idpersona;
    private String nombre_persona;
    private String apellido_persona;
    private String dni_persona;
    private Integer edad_persona;
    private Integer estado;

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
}
