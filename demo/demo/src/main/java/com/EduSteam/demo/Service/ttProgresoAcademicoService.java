package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttProgresoAcademicoEntity;

import java.util.List;

public interface ttProgresoAcademicoService {

    List<ttProgresoAcademicoEntity> listar();
    ttProgresoAcademicoEntity guardar(ttProgresoAcademicoEntity progreso);
    List<ttProgresoAcademicoEntity> buscarPorEstudiante(Integer idEstudiante);
    List<ttProgresoAcademicoEntity> buscarPorCalificacion(Integer calificacion);
}
