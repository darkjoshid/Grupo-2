package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Repository.tmasignaturaRepository;
import com.EduSteam.demo.Service.tmasignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class tmasignaturaImpl implements tmasignaturaService {

    @Autowired
    private tmasignaturaRepository asignaturaRepository;

    @Override
    public List<tmasignaturaEntity> listar() {
        List<tmasignaturaEntity> listar = new ArrayList<>();
        listar = asignaturaRepository.findAll();
        return listar;
    }

    @Override
    public tmasignaturaEntity listarId(Long idasignatura) {
        return asignaturaRepository.findById(idasignatura).orElse(null);
    }

    @Override
    public tmasignaturaEntity guardar(tmasignaturaEntity tmasignatura) {

        return asignaturaRepository.save(tmasignatura);
    }

    @Override
    public tmasignaturaEntity actualizar(tmasignaturaEntity tmasignatura) {
        tmasignaturaEntity asignaturaExistente = asignaturaRepository.findById(tmasignatura.getIdasignatura()).orElse(null);
        if (asignaturaExistente != null) {
            asignaturaExistente.setNombre(tmasignatura.getNombre());
            asignaturaExistente.setDescripcion(tmasignatura.getDescripcion());
            asignaturaExistente.setNivel(tmasignatura.getNivel());
            asignaturaExistente.setEstadoAsignatura(tmasignatura.getEstadoAsignatura());
            return asignaturaRepository.save(asignaturaExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Long idasignatura) {
        asignaturaRepository.deleteById(idasignatura);
    }
}