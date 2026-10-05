package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Repository.ttprogresoacademicoRepository;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ttprogresoacademicoImpl implements ttprogresoacademicoService {

    @Autowired
    private ttprogresoacademicoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ttprogresoacademicoEntity> listar() {
        return repository.findAll();
    }

    @Override
    public ttprogresoacademicoEntity obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ttprogresoacademicoEntity guardar(ttprogresoacademicoEntity progreso) {
        // Carga segura del estudiante por ID usando EntityManager
        if (progreso.getEstudiante() != null && progreso.getEstudiante().getIdestudiante() != null) {
            teestudianteEntity estudiante = entityManager.find(teestudianteEntity.class, progreso.getEstudiante().getIdestudiante());
            progreso.setEstudiante(estudiante);
        }
        // Carga segura de la asignatura por ID usando EntityManager
        if (progreso.getAsignatura() != null && progreso.getAsignatura().getIdasignatura() != null) {
            tmasignaturaEntity asignatura = entityManager.find(tmasignaturaEntity.class, progreso.getAsignatura().getIdasignatura());
            progreso.setAsignatura(asignatura);
        }
        return repository.save(progreso);
    }

    @Override
    public ttprogresoacademicoEntity actualizar(Long id, ttprogresoacademicoEntity progreso) {
        ttprogresoacademicoEntity existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setCalificacion(progreso.getCalificacion());
            existente.setNotasProgreso(progreso.getNotasProgreso());

            if (progreso.getAsignatura() != null && progreso.getAsignatura().getIdasignatura() != null) {
                tmasignaturaEntity asignatura = entityManager.find(tmasignaturaEntity.class, progreso.getAsignatura().getIdasignatura());
                existente.setAsignatura(asignatura);
            }
            if (progreso.getEstudiante() != null && progreso.getEstudiante().getIdestudiante() != null) {
                teestudianteEntity estudiante = entityManager.find(teestudianteEntity.class, progreso.getEstudiante().getIdestudiante());
                existente.setEstudiante(estudiante);
            }
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}