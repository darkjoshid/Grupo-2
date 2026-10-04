package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttcuentaEntity;

import java.util.List;

public interface ttcuentaService {
    List<ttcuentaEntity> ListarCuenta();
    ttcuentaEntity GuardarActualizar(ttcuentaEntity ttcuenta);
    void EliminarCuenta(Integer idcuenta);
}
