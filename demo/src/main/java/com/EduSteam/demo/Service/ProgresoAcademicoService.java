package com.example.demo.Service;

import com.example.demo.Entity.ProgresoAcademicoEntity;

import java.util.List;

public interface ProgresoAcademicoService {
    List<ProgresoAcademicoEntity> listarActivos();
    List<ProgresoAcademicoEntity> listarPorIdEstudiante(Long idEstudiante);
    ProgresoAcademicoEntity buscarPorId(Long id);
    ProgresoAcademicoEntity registrar(ProgresoAcademicoEntity progreso);
    ProgresoAcademicoEntity actualizar(Long id, ProgresoAcademicoEntity progreso);
    void eliminarLogico(Long id);
}
