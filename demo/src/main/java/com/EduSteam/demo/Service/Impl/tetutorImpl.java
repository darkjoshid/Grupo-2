package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Dto.tetutorDto;
import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Repository.tetutorRepository;
import com.EduSteam.demo.Repository.tmasignaturaRepository;
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
    private final tmasignaturaRepository asignaturaRepository;

    public tetutorImpl(tetutorRepository tutorRepository, teusuarioRepository usuarioRepository,
                       tmasignaturaRepository asignaturaRepository) {
        this.tutorRepository = tutorRepository;
        this.usuarioRepository = usuarioRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<tetutorDto> listar() {
        return tutorRepository.listarActivos().stream()
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
                    HttpStatus.CONFLICT, "El usuario con id " + dto.getIdusuario() + " ya está registrado como tutor (activo o dado de baja)");
        }

        tetutorEntity tutor = new tetutorEntity();
        tutor.setUsuario(usuario);
        copiarCampos(dto, tutor);
        tutor.setEstadoTutor(true);
        return toDto(tutorRepository.save(tutor));
    }

    @Override
    @Transactional
    public tetutorDto actualizar(Long id, tetutorDto dto) {
        tetutorEntity tutor = buscar(id);

        // Si se envía un idusuario distinto al actual, el tutor pasa a ese usuario
        Long idusuarioActual = tutor.getUsuario() != null ? tutor.getUsuario().getIdusuario() : null;
        if (dto.getIdusuario() != null && !dto.getIdusuario().equals(idusuarioActual)) {
            teusuarioEntity usuario = usuarioRepository.findById(dto.getIdusuario())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "No existe el usuario con id " + dto.getIdusuario()));

            if (tutorRepository.existsByUsuario_Idusuario(dto.getIdusuario())) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "El usuario con id " + dto.getIdusuario() + " ya está registrado como tutor (activo o dado de baja)");
            }
            tutor.setUsuario(usuario);
        }

        copiarCampos(dto, tutor);
        return toDto(tutorRepository.save(tutor));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tetutorEntity tutor = buscar(id);
        tutor.setEstadoTutor(false);
        tutorRepository.save(tutor);

        // Al dar de baja al tutor, también se dan de baja sus asignaturas activas
        for (tmasignaturaEntity asignatura : asignaturaRepository.listarActivasPorTutor(id)) {
            asignatura.setEstadoAsignatura(false);
            asignaturaRepository.save(asignatura);
        }
    }

    private tetutorEntity buscar(Long id) {
        return tutorRepository.buscarActivoPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe el tutor con id " + id));
    }

    private void copiarCampos(tetutorDto dto, tetutorEntity tutor) {
        tutor.setBiografia(dto.getBiografia());
        tutor.setAnosExperiencia(dto.getAnosExperiencia());
        tutor.setCalificacion(dto.getCalificacion());
        // El estado no se modifica aquí: solo cambia con guardar (activo) o eliminar (baja lógica)
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