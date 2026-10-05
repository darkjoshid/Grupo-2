package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;

import java.util.List;

public interface ttprogresoacademicoService {
    List<ttprogresoacademicoEntity> listarActivos();
    List<ttprogresoacademicoEntity> listarPorIdEstudiante(Long idEstudiante);
    ttprogresoacademicoEntity buscarPorId(Long id);
    ttprogresoacademicoEntity registrar(ttprogresoacademicoEntity progreso);
    ttprogresoacademicoEntity actualizar(Long id, ttprogresoacademicoEntity progreso);
    void eliminarLogico(Long id);
}
