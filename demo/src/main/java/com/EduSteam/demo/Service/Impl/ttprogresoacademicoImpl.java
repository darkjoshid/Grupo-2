package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.ttprogresoacademicoDto;
import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Entity.ttprogresoacademicoID;
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
    public List<ttprogresoacademicoID> listarActivos() {
        List<ttprogresoacademicoEntity>lista=repository.findByEstadoProgreso(true);
        return lista.stream().map(progreso->{
            ttprogresoacademicoID dto=new ttprogresoacademicoID();

            dto.setIdProgreso(progreso.getIdProgreso());
            dto.setIdEstudiante(progreso.getEstudiante().getIdestudiante());
            dto.setIdAsignatura(progreso.getAsignatura().getIdasignatura());
            dto.setCalificacion(progreso.getCalificacion());
            dto.setNotasProgreso(progreso.getNotasProgreso());
            dto.setEstadoProgreso(progreso.getEstadoProgreso());
            return dto;
        }).toList();
    }

    @Override
    public ttprogresoacademicoID registrar(ttprogresoacademicoDto dto) {
        teestudianteEntity estudiante = estudianteRepository.findById(dto.getIdestudiante()).orElse(null);
        tmasignaturaEntity asignatura = asignaturaRepository.findById(dto.getIdsesiontutoria()).orElse(null);

        if (estudiante == null || asignatura == null) {
            throw new RuntimeException("Estudiante o Asignatura no encontrados en la base de datos.");
        }

        ttprogresoacademicoEntity progreso = new ttprogresoacademicoEntity();
        progreso.setEstudiante(estudiante);
        progreso.setAsignatura(asignatura);
        progreso.setCalificacion(dto.getCalificacion());
        progreso.setNotasProgreso(dto.getNotasprogreso());
        progreso.setEstadoProgreso(true);

        ttprogresoacademicoEntity guardado=repository.save(progreso);
        ttprogresoacademicoID respuesta=new ttprogresoacademicoID();
        respuesta.setIdProgreso(guardado.getIdProgreso());
        respuesta.setIdEstudiante(guardado.getEstudiante().getIdestudiante());
        respuesta.setIdAsignatura(guardado.getAsignatura().getIdasignatura());
        respuesta.setCalificacion(guardado.getCalificacion());
        respuesta.setNotasProgreso(guardado.getNotasProgreso());
        respuesta.setEstadoProgreso(guardado.getEstadoProgreso());
        return respuesta;
    }

    @Override
    public void eliminarLogico(Long id) {
        ttprogresoacademicoEntity progreso = repository.findById(id).orElse(null);
        if (progreso != null) {
            progreso.setEstadoProgreso(false);
            repository.save(progreso);
        }
    }
}