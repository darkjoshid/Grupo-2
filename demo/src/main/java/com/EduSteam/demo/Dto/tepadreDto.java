package com.EduSteam.demo.Dto;

public class tepadreDto {

    private Long idpadre;
    private String direccion;
    private String contactoemergencia;
    private String relacionconestudiante;
    private Integer estadopadre;

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
}
