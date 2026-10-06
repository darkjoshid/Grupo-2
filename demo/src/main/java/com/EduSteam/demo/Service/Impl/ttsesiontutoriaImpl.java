package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import com.EduSteam.demo.Repository.ttsesiontutoriaRepository;
import com.EduSteam.demo.Service.ttsesiontutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ttsesiontutoriaImpl implements ttsesiontutoriaService {

    @Autowired
    private ttsesiontutoriaRepository sesionTutoriaRepository;

    @Override
    public List<ttsesiontutoriaEntity> listarActivas() {
        return sesionTutoriaRepository.ListaSesionesTutoriasActivas();
    }

    @Override
    public List<ttsesiontutoriaEntity> listarPorIdEstudiante(Long idEstudiante) {
        return sesionTutoriaRepository.BuscarPorIdEstudiante(idEstudiante);
    }

    @Override
    public List<ttsesiontutoriaEntity> listarPorIdTutor(Long idTutor) {
        return sesionTutoriaRepository.BuscarPorIdTutor(idTutor);
    }

    @Override
    public ttsesiontutoriaEntity buscarPorId(Long id) {
        return sesionTutoriaRepository.BuscarPorId(id);
    }

    @Override
    public ttsesiontutoriaEntity registrar(ttsesiontutoriaEntity sesion) {
        sesion.setEstado(true);
        return sesionTutoriaRepository.save(sesion);
    }

    @Override
    public ttsesiontutoriaEntity actualizar(Long id, ttsesiontutoriaEntity sesion) {
        ttsesiontutoriaEntity sesionExistente = buscarPorId(id);
        sesionExistente.setFechaSesion(sesion.getFechaSesion());
        sesionExistente.setHoraInicio(sesion.getHoraInicio());
        sesionExistente.setHoraFin(sesion.getHoraFin());
        sesionExistente.setObservaciones(sesion.getObservaciones());
        sesionExistente.setAsignatura(sesion.getAsignatura());
        return sesionTutoriaRepository.save(sesionExistente);
    }

    @Override
    public void eliminarLogico(Long id) {
        ttsesiontutoriaEntity sesion = buscarPorId(id);
        sesion.setEstado(false);
        sesionTutoriaRepository.save(sesion);
    }
}
