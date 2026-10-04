package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Repository.ttprogresoacademicoRepository;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ttprogresoacademicoImpl implements ttprogresoacademicoService {

    @Autowired
    private ttprogresoacademicoRepository progresoAcademicoRepository;

    @Override
    public List<ttprogresoacademicoEntity> listarActivos() {
        return progresoAcademicoRepository.ListaProgresoAcademicoActivos();
    }

    @Override
    public List<ttprogresoacademicoEntity> listarPorIdEstudiante(Long idEstudiante) {
        return progresoAcademicoRepository.BuscarPorEstudiante(idEstudiante);
    }

    @Override
    public ttprogresoacademicoEntity buscarPorId(Long id) {
        return progresoAcademicoRepository.BuscarPorId(id);
    }

    @Override
    public ttprogresoacademicoEntity registrar(ttprogresoacademicoEntity progreso) {
        progreso.setEstadoProgreso(true);
        return progresoAcademicoRepository.save(progreso);
    }

    @Override
    public ttprogresoacademicoEntity actualizar(Long id, ttprogresoacademicoEntity progreso) {
        ttprogresoacademicoEntity progresoExistente = buscarPorId(id);
        progresoExistente.setCalificacion(progreso.getCalificacion());
        progresoExistente.setNotasProgreso(progreso.getNotasProgreso());
        progresoExistente.setAsignatura(progreso.getAsignatura());
        return progresoAcademicoRepository.save(progresoExistente);
    }

    @Override
    public void eliminarLogico(Long id) {
        ttprogresoacademicoEntity progreso = buscarPorId(id);
        progreso.setEstadoProgreso(false);
        progresoAcademicoRepository.save(progreso);
    }
}