package com.EduSteam.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="ta_auditoria",schema="upc")
public class taauditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idauditoria;
    @Column(name = "idusuarioregistro")
    private Long idusuarioregistro;
    @Column(name = "fecharegistro")
    private LocalDateTime fecharegistro;
    @Column(name = "idusuarioeditar")
    private Long idusuarioeditar;
    @Column(name = "fechaeditar")
    private LocalDateTime fechaeditar;
    @Column(name = "idusuarioeliminar")
    private Long idusuarioeliminar;
    @Column(name = "fechaeliminar")
    private LocalDateTime fechaeliminar;
    @Column(name="estado")
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
