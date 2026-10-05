package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;

import java.util.List;

public interface ttprogresoacademicoService {
    List<ttprogresoacademicoEntity> listar();
    ttprogresoacademicoEntity obtenerPorId(Long id);
    ttprogresoacademicoEntity guardar(ttprogresoacademicoEntity progreso);
    ttprogresoacademicoEntity actualizar(Long id, ttprogresoacademicoEntity progreso);
    void eliminar(Long id);
}