package com.EduSteam.demo.Dto;

import java.time.LocalDateTime;

public class taauditoriaDto {
    private Integer idauditoria;
    private Long idusuarioregistro;
    private LocalDateTime fecharegistro;
    private Long idusuarioeditar;
    private LocalDateTime fechaeditar;
    private Long idusuarioeliminar;
    private LocalDateTime fechaeliminar;
    private boolean estado;

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Long getIdusuarioregistro() {
        return idusuarioregistro;
    }

    public void setIdusuarioregistro(Long idusuarioregistro) {
        this.idusuarioregistro = idusuarioregistro;
    }

    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Long getIdusuarioeditar() {
        return idusuarioeditar;
    }

    public void setIdusuarioeditar(Long idusuarioeditar) {
        this.idusuarioeditar = idusuarioeditar;
    }

    public LocalDateTime getFechaeditar() {
        return fechaeditar;
    }

    public void setFechaeditar(LocalDateTime fechaeditar) {
        this.fechaeditar = fechaeditar;
    }

    public Long getIdusuarioeliminar() {
        return idusuarioeliminar;
    }

    public void setIdusuarioeliminar(Long idusuarioeliminar) {
        this.idusuarioeliminar = idusuarioeliminar;
    }

    public LocalDateTime getFechaeliminar() {
        return fechaeliminar;
    }

    public void setFechaeliminar(LocalDateTime fechaeliminar) {
        this.fechaeliminar = fechaeliminar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
