package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.ttProgresoAcademicoEntity;
import com.EduSteam.demo.Repository.ttProgresoAcademicoRepository;
import com.EduSteam.demo.Service.ttProgresoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ttProgresoAcademicoServiceImpl implements ttProgresoAcademicoService {

    @Autowired
    private ttProgresoAcademicoRepository progresoRepository;

    @Override
    public List<ttProgresoAcademicoEntity> listar() {
        List<ttProgresoAcademicoEntity> listar = new ArrayList<>();
        listar = progresoRepository.findAll();
        return listar;
    }

    @Override
    public ttProgresoAcademicoEntity guardar(ttProgresoAcademicoEntity progreso) {
        return progresoRepository.save(progreso);
    }

    @Override
    public List<ttProgresoAcademicoEntity> buscarPorEstudiante(Integer idEstudiante) {
        return progresoRepository.buscarPorEstudiante(idEstudiante);
    }

    @Override
    public List<ttProgresoAcademicoEntity> buscarPorCalificacion(Integer calificacion) {
        return progresoRepository.buscarPorCalificacion(calificacion);
    }
}
