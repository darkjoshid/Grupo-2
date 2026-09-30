package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.ttProgresoAcademicoEntity;
import com.EduSteam.demo.Entity.ttSesionTutoriaEntity;
import com.EduSteam.demo.Repository.ttSesionTutoriaRepository;
import com.EduSteam.demo.Service.ttSesionTutoriaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ttSesionTutoriaServiceImpl implements ttSesionTutoriaService {
    @Autowired
    private ttSesionTutoriaRepository sesionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ttSesionTutoriaEntity> listar() {
        List<ttSesionTutoriaEntity> listar = new ArrayList<>();
        listar = sesionRepository.findAll();
        return listar;
    }

    @Override
    public ttSesionTutoriaEntity guardar(ttSesionTutoriaEntity sesion) {
        if (sesion.getEstado() == null) {
            sesion.setEstado("PENDIENTE");
        }
        return sesionRepository.save(sesion);
    }

    @Override
    public List<ttSesionTutoriaEntity> buscarPorEstado(String estado) {
        return sesionRepository.buscarPorEstado(estado);
    }

    @Override
    public List<ttSesionTutoriaEntity> buscarPorEstudiante(Integer idEstudiante) {
        return sesionRepository.buscarPorEstudiante(idEstudiante);
    }
}
