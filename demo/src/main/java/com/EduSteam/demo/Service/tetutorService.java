package com.EduSteam.demo.Service;

import com.EduSteam.demo.Dto.tetutorDto;

import java.util.List;

public interface tetutorService {
    List<tetutorDto> listar();

    tetutorDto obtenerPorId(Long id);

    tetutorDto guardar(tetutorDto dto);

    tetutorDto actualizar(Long id, tetutorDto dto);

    void eliminar(Long id);
}
