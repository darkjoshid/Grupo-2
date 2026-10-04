package com.example.demo.Service.Impl;

import com.example.demo.Entity.SesionTutoriaEntity;
import com.example.demo.Repository.SesionTutoriaRepository;
import com.example.demo.Service.SesionTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionTutoriaServiceImpl implements SesionTutoriaService {

    @Autowired
    private SesionTutoriaRepository sesionTutoriaRepository;

    @Override
    public List<SesionTutoriaEntity> listarActivas() {
        return sesionTutoriaRepository.ListaSesionesTutoriasActivas();
    }

    @Override
    public List<SesionTutoriaEntity> listarPorIdEstudiante(Long idEstudiante) {
        return sesionTutoriaRepository.BuscarPorIdEstudiante(idEstudiante);
    }

    @Override
    public List<SesionTutoriaEntity> listarPorIdTutor(Long idTutor) {
        return sesionTutoriaRepository.BuscarPorIdTutor(idTutor);
    }

    @Override
    public SesionTutoriaEntity buscarPorId(Long id) {
        return sesionTutoriaRepository.BuscarPorId(id);
    }

    @Override
    public SesionTutoriaEntity registrar(SesionTutoriaEntity sesion) {
        sesion.setEstado(true);
        return sesionTutoriaRepository.save(sesion);
    }

    @Override
    public SesionTutoriaEntity actualizar(Long id, SesionTutoriaEntity sesion) {
        SesionTutoriaEntity sesionExistente = buscarPorId(id);
        sesionExistente.setFechaSesion(sesion.getFechaSesion());
        sesionExistente.setHoraInicio(sesion.getHoraInicio());
        sesionExistente.setHoraFin(sesion.getHoraFin());
        sesionExistente.setObservaciones(sesion.getObservaciones());
        sesionExistente.setAsignatura(sesion.getAsignatura());
        return sesionTutoriaRepository.save(sesionExistente);
    }

    @Override
    public void eliminarLogico(Long id) {
        SesionTutoriaEntity sesion = buscarPorId(id);
        sesion.setEstado(false);
        sesionTutoriaRepository.save(sesion);
    }
}
