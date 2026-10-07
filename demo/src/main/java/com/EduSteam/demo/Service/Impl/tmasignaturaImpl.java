
package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.tmasignaturaDto;
import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Repository.tetutorRepository;
import com.EduSteam.demo.Repository.tmasignaturaRepository;
import com.EduSteam.demo.Service.tmasignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class tmasignaturaImpl implements tmasignaturaService{
    private final tmasignaturaRepository asignaturaRepository;
    private final tetutorRepository tutorRepository;

    public tmasignaturaImpl(tmasignaturaRepository asignaturaRepository, tetutorRepository tutorRepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<tmasignaturaDto> listar() {
        return asignaturaRepository.listarActivas().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public tmasignaturaDto obtenerPorId(Long id) {
        return toDto(buscar(id));
    }

    @Override
    @Transactional
    public tmasignaturaDto guardar(tmasignaturaDto dto) {
        if (dto.getIdtutor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idtutor es obligatorio");
        }

        tmasignaturaEntity asignatura = new tmasignaturaEntity();
        asignatura.setTutor(buscarTutor(dto.getIdtutor()));
        copiarCampos(dto, asignatura);
        asignatura.setEstadoAsignatura(true);
        return toDto(asignaturaRepository.save(asignatura));
    }

    @Override
    @Transactional
    public tmasignaturaDto actualizar(Long id, tmasignaturaDto dto) {
        tmasignaturaEntity asignatura = buscar(id);
        if (dto.getIdtutor() != null) {
            asignatura.setTutor(buscarTutor(dto.getIdtutor()));
        }
        copiarCampos(dto, asignatura);
        return toDto(asignaturaRepository.save(asignatura));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tmasignaturaEntity asignatura = buscar(id);
        asignatura.setEstadoAsignatura(false);
        asignaturaRepository.save(asignatura);
    }

    private tmasignaturaEntity buscar(Long id) {
        return asignaturaRepository.buscarActivaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe la asignatura con id " + id));
    }

    private tetutorEntity buscarTutor(Long idtutor) {
        return tutorRepository.buscarActivoPorId(idtutor)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe el tutor con id " + idtutor));
    }

    private void copiarCampos(tmasignaturaDto dto, tmasignaturaEntity asignatura) {
        asignatura.setNombre(dto.getNombre());
        asignatura.setDescripcion(dto.getDescripcion());
        asignatura.setNivel(dto.getNivel());
    }

    private tmasignaturaDto toDto(tmasignaturaEntity asignatura) {
        tmasignaturaDto dto = new tmasignaturaDto();
        dto.setIdasignatura(asignatura.getIdasignatura());
        dto.setIdtutor(asignatura.getTutor() != null ? asignatura.getTutor().getIdtutor() : null);
        dto.setNombre(asignatura.getNombre());
        dto.setDescripcion(asignatura.getDescripcion());
        dto.setNivel(asignatura.getNivel());
        dto.setEstadoAsignatura(asignatura.getEstadoAsignatura());
        return dto;
    }
}