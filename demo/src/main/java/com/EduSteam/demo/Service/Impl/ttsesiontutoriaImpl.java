package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.ttsesiontutoriaDto;
import com.EduSteam.demo.Entity.*;
import com.EduSteam.demo.Repository.teestudianteRepository;
import com.EduSteam.demo.Repository.tetutorRepository;
import com.EduSteam.demo.Repository.tmasignaturaRepository;
import com.EduSteam.demo.Repository.ttsesiontutoriaRepository;
import com.EduSteam.demo.Service.ttsesiontutoriaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ttsesiontutoriaImpl implements ttsesiontutoriaService {

    @Autowired
    private ttsesiontutoriaRepository repository;

    @Autowired
    private tetutorRepository tutorRepository; // Asegúrate de que coincida con el nombre de tu repositorio de tutor

    @Autowired
    private teestudianteRepository estudianteRepository; // Repositorio de estudiante

    @Autowired
    private tmasignaturaRepository asignaturaRepository; // Repositorio de asignatura


    @Override
    public List<ttsesiontutoriaID> listarActivos() {
        List<ttsesiontutoriaEntity>sesiones=repository.findByEstado(true);
        return sesiones.stream().map(sesion ->{
            ttsesiontutoriaID dto =new ttsesiontutoriaID();

            dto.setIdSesion(sesion.getIdSesion());
            dto.setIdTutor(sesion.getTutor().getIdtutor());
            dto.setIdEstudiante(sesion.getEstudiante().getIdestudiante());
            dto.setIdAsignatura(sesion.getAsignatura().getIdasignatura());
            dto.setFechaSesion(sesion.getFechaSesion());
            dto.setHoraInicio(sesion.getHoraInicio());
            dto.setHoraFin(sesion.getHoraFin());
            dto.setEstado(sesion.getEstado());
            dto.setObservaciones(sesion.getObservaciones());

            return dto;
        }).toList();
    }

    @Override
    @Transactional
    public ttsesiontutoriaEntity registrar(ttsesiontutoriaDto dto) {
        tetutorEntity tutor = tutorRepository.findById(dto.getIdTutor()).orElse(null);
        teestudianteEntity estudiante = estudianteRepository.findById(dto.getIdEstudiante()).orElse(null);
        tmasignaturaEntity asignatura = asignaturaRepository.findById(dto.getIdAsignatura()).orElse(null);

        if (tutor == null || estudiante == null || asignatura == null) {
            throw new RuntimeException("Tutor, Estudiante o Asignatura no encontrados en la base de datos.");
        }

        ttsesiontutoriaEntity sesion = new ttsesiontutoriaEntity();
        sesion.setTutor(tutor);
        sesion.setEstudiante(estudiante);
        sesion.setAsignatura(asignatura);
        sesion.setFechaSesion(dto.getFechaSesion());
        sesion.setHoraInicio(dto.getHoraInicio());
        sesion.setHoraFin(dto.getHoraFin());
        sesion.setObservaciones(dto.getObservaciones());
        sesion.setEstado(true); // Activo por defecto

        return repository.save(sesion);
    }

    @Override
    @Transactional
    public void eliminarLogico(Long id) {
        ttsesiontutoriaEntity sesion = repository.findById(id).orElse(null);
        if (sesion != null) {
            sesion.setEstado(false); // Eliminación lógica
            repository.save(sesion);
        }
    }
}