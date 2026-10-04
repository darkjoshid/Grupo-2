package com.example.demo.Service.Impl;

import com.example.demo.Entity.ProgresoAcademicoEntity;
import com.example.demo.Repository.ProgresoAcademicoRepository;
import com.example.demo.Service.ProgresoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoAcademicoServiceImpl implements ProgresoAcademicoService {

    @Autowired
    private ProgresoAcademicoRepository progresoAcademicoRepository;

    @Override
    public List<ProgresoAcademicoEntity> listarActivos() {
        return progresoAcademicoRepository.ListaProgresoAcademicoActivos();
    }

    @Override
    public List<ProgresoAcademicoEntity> listarPorIdEstudiante(Long idEstudiante) {
        return progresoAcademicoRepository.BuscarPorEstudiante(idEstudiante);
    }

    @Override
    public ProgresoAcademicoEntity buscarPorId(Long id) {
        return progresoAcademicoRepository.BuscarPorId(id);
    }

    @Override
    public ProgresoAcademicoEntity registrar(ProgresoAcademicoEntity progreso) {
        progreso.setEstadoProgreso(true);
        return progresoAcademicoRepository.save(progreso);
    }

    @Override
    public ProgresoAcademicoEntity actualizar(Long id, ProgresoAcademicoEntity progreso) {
        ProgresoAcademicoEntity progresoExistente = buscarPorId(id);
        progresoExistente.setCalificacion(progreso.getCalificacion());
        progresoExistente.setNotasProgreso(progreso.getNotasProgreso());
        progresoExistente.setAsignatura(progreso.getAsignatura());
        return progresoAcademicoRepository.save(progresoExistente);
    }

    @Override
    public void eliminarLogico(Long id) {
        ProgresoAcademicoEntity progreso = buscarPorId(id);
        progreso.setEstadoProgreso(false);
        progresoAcademicoRepository.save(progreso);
    }
}