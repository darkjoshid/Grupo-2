package com.EduSteam.demo.Dto;

import java.time.LocalDate;

public class ttcuentaDto {
    private Integer idcuenta;
    private String nombrecuenta;
    private LocalDate fecharegistrocuenta;
    private boolean estadocuenta;

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public LocalDate getFecharegistrocuenta() {
        return fecharegistrocuenta;
    }

    public void setFecharegistrocuenta(LocalDate fecharegistrocuenta) {
        this.fecharegistrocuenta = fecharegistrocuenta;
    }

    public boolean isEstadocuenta() {
        return estadocuenta;
    }

    public void setEstadocuenta(boolean estadocuenta) {
        this.estadocuenta = estadocuenta;
    }
}
