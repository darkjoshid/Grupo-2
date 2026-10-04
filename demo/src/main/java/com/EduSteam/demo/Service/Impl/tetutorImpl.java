package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.tetutorDto;
import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Repository.tetutorRepository;
import com.EduSteam.demo.Repository.teusuarioRepository;
import com.EduSteam.demo.Service.tetutorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class tetutorImpl implements tetutorService {
    private final tetutorRepository tutorRepository;
    private final teusuarioRepository usuarioRepository;

    public tetutorImpl(tetutorRepository tutorRepository, teusuarioRepository usuarioRepository) {
        this.tutorRepository = tutorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<tetutorDto> listar() {
        return tutorRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public tetutorDto obtenerPorId(Long id) {
        return toDto(buscar(id));
    }

    @Override
    @Transactional
    public tetutorDto guardar(tetutorDto dto) {
        if (dto.getIdusuario() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idusuario es obligatorio");
        }

        teusuarioEntity usuario = usuarioRepository.findById(dto.getIdusuario())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe el usuario con id " + dto.getIdusuario()));

        if (tutorRepository.existsByUsuario_Idusuario(dto.getIdusuario())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "El usuario con id " + dto.getIdusuario() + " ya está registrado como tutor");
        }

        tetutorEntity tutor = new tetutorEntity();
        tutor.setUsuario(usuario);
        copiarCampos(dto, tutor);
        if (tutor.getEstadoTutor() == null) {
            tutor.setEstadoTutor(true);
        }
        return toDto(tutorRepository.save(tutor));
    }

    @Override
    @Transactional
    public tetutorDto actualizar(Long id, tetutorDto dto) {
        tetutorEntity tutor = buscar(id);
        copiarCampos(dto, tutor);
        return toDto(tutorRepository.save(tutor));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tetutorEntity tutor = buscar(id);
        tutor.setEstadoTutor(false);
        tutorRepository.save(tutor);
    }

    private tetutorEntity buscar(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe el tutor con id " + id));
    }

    private void copiarCampos(tetutorDto dto, tetutorEntity tutor) {
        tutor.setBiografia(dto.getBiografia());
        tutor.setAnosExperiencia(dto.getAnosExperiencia());
        tutor.setCalificacion(dto.getCalificacion());
        if (dto.getEstadoTutor() != null) {
            tutor.setEstadoTutor(dto.getEstadoTutor());
        }
    }

    private tetutorDto toDto(tetutorEntity tutor) {
        tetutorDto dto = new tetutorDto();
        dto.setIdtutor(tutor.getIdtutor());
        dto.setIdusuario(tutor.getUsuario() != null ? tutor.getUsuario().getIdusuario() : null);
        dto.setBiografia(tutor.getBiografia());
        dto.setAnosExperiencia(tutor.getAnosExperiencia());
        dto.setCalificacion(tutor.getCalificacion());
        dto.setEstadoTutor(tutor.getEstadoTutor());
        return dto;
    }
}
