package com.EduSteam.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CuentaID implements Serializable {
    @Column(name="idusuario")
    private Long idusuario;
    @Column(name="idcuental")
    private CuentaID idCuenta;

}
