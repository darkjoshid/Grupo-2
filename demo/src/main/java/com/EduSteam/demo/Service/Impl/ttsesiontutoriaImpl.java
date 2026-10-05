package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import com.EduSteam.demo.Repository.ttsesiontutoriaRepository;
import com.EduSteam.demo.Service.ttsesiontutoriaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ttsesiontutoriaImpl implements ttsesiontutoriaService {

    @Autowired
    private ttsesiontutoriaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ttsesiontutoriaEntity> listarActivas() {
        return repository.listaSesionesActivas();
    }

    @Override
    public ttsesiontutoriaEntity obtenerPorId(Long id) {
        return repository.buscarPorIdActivo(id).orElse(null);
    }

    @Override
    public ttsesiontutoriaEntity registrar(ttsesiontutoriaEntity sesion) {
        // Carga segura del estudiante por ID
        if (sesion.getEstudiante() != null && sesion.getEstudiante().getIdestudiante() != null) {
            teestudianteEntity estudiante = entityManager.find(teestudianteEntity.class, sesion.getEstudiante().getIdestudiante());
            sesion.setEstudiante(estudiante);
        }
        // Carga segura del tutor por ID
        if (sesion.getTutor() != null && sesion.getTutor().getIdtutor() != null) {
            tetutorEntity tutor = entityManager.find(tetutorEntity.class, sesion.getTutor().getIdtutor());
            sesion.setTutor(tutor);
        }
        // Carga segura de la asignatura por ID
        if (sesion.getAsignatura() != null && sesion.getAsignatura().getIdasignatura() != null) {
            tmasignaturaEntity asignatura = entityManager.find(tmasignaturaEntity.class, sesion.getAsignatura().getIdasignatura());
            sesion.setAsignatura(asignatura);
        }

        sesion.setEstado(true);
        return repository.save(sesion);
    }

    @Override
    public ttsesiontutoriaEntity actualizar(Long id, ttsesiontutoriaEntity sesion) {
        ttsesiontutoriaEntity existente = repository.buscarPorIdActivo(id).orElse(null);
        if (existente != null) {
            existente.setFechaSesion(sesion.getFechaSesion());
            existente.setHoraInicio(sesion.getHoraInicio());
            existente.setHoraFin(sesion.getHoraFin());
            existente.setObservaciones(sesion.getObservaciones());

            if (sesion.getAsignatura() != null && sesion.getAsignatura().getIdasignatura() != null) {
                tmasignaturaEntity asignatura = entityManager.find(tmasignaturaEntity.class, sesion.getAsignatura().getIdasignatura());
                existente.setAsignatura(asignatura);
            }
            if (sesion.getTutor() != null && sesion.getTutor().getIdtutor() != null) {
                tetutorEntity tutor = entityManager.find(tetutorEntity.class, sesion.getTutor().getIdtutor());
                existente.setTutor(tutor);
            }
            if (sesion.getEstudiante() != null && sesion.getEstudiante().getIdestudiante() != null) {
                teestudianteEntity estudiante = entityManager.find(teestudianteEntity.class, sesion.getEstudiante().getIdestudiante());
                existente.setEstudiante(estudiante);
            }

            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminarLogico(Long id) {
        ttsesiontutoriaEntity sesion = repository.buscarPorIdActivo(id).orElse(null);
        if (sesion != null) {
            sesion.setEstado(false);
            repository.save(sesion);
        }
    }
}