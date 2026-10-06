package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Repository.tetutorRepository;
import com.EduSteam.demo.Service.tetutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class tetutorImpl implements tetutorService {

    @Autowired
    private tetutorRepository tutorRepository;

    @Override
    public List<tetutorEntity> listar() {
        List<tetutorEntity> listar = new ArrayList<>();
        listar = tutorRepository.findAll();
        return listar;
    }

    @Override
    public tetutorEntity listarId(Long idtutor) {
        return tutorRepository.findById(idtutor).orElse(null);
    }

    @Override
    public tetutorEntity guardar(tetutorEntity tetutor) {

        return tutorRepository.save(tetutor);
    }

    @Override
    public tetutorEntity actualizar(tetutorEntity tetutor) {
        tetutorEntity tutorExistente = tutorRepository.findById(tetutor.getIdtutor()).orElse(null);
        if (tutorExistente != null) {
            tutorExistente.setBiografia(tetutor.getBiografia());
            tutorExistente.setAnosExperiencia(tetutor.getAnosExperiencia());
            tutorExistente.setCalificacion(tetutor.getCalificacion());
            tutorExistente.setEstadoTutor(tetutor.getEstadoTutor());
            return tutorRepository.save(tutorExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Long idtutor) {
        tutorRepository.deleteById(idtutor);
    }
}