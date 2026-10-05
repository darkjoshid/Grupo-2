package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.ttprogresoacademicoDto;
import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Repository.teestudianteRepository;
import com.EduSteam.demo.Repository.tmasignaturaRepository;
import com.EduSteam.demo.Repository.ttprogresoacademicoRepository;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ttprogresoacademicoImpl implements ttprogresoacademicoService {

    @Autowired
    private ttprogresoacademicoRepository repository;

    @Autowired
    private teestudianteRepository estudianteRepository;

    @Autowired
    private tmasignaturaRepository asignaturaRepository;

    @Override
    public List<ttprogresoacademicoEntity> listarActivos() {
        return repository.findByEstadoProgreso(true);
    }

    @Override
    @Transactional
    public ttprogresoacademicoEntity registrar(ttprogresoacademicoDto dto) {
        teestudianteEntity estudiante = estudianteRepository.findById(dto.getIdEstudiante()).orElse(null);
        tmasignaturaEntity asignatura = asignaturaRepository.findById(dto.getIdAsignatura()).orElse(null);

        if (estudiante == null || asignatura == null) {
            throw new RuntimeException("Estudiante o Asignatura no encontrados en la base de datos.");
        }

        ttprogresoacademicoEntity progreso = new ttprogresoacademicoEntity();
        progreso.setEstudiante(estudiante);
        progreso.setAsignatura(asignatura);
        progreso.setCalificacion(dto.getCalificacion());
        progreso.setNotasProgreso(dto.getNotasProgreso());
        progreso.setEstadoProgreso(true); // Activo por defecto

        return repository.save(progreso);
    }

    @Override
    @Transactional
    public void eliminarLogico(Long id) {
        ttprogresoacademicoEntity progreso = repository.findById(id).orElse(null);
        if (progreso != null) {
            progreso.setEstadoProgreso(false); // Eliminación lógica
            repository.save(progreso);
        }
    }
}