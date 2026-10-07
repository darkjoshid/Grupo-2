package com.EduSteam.demo.Service;

import com.EduSteam.demo.Dto.tmasignaturaDto;

import java.util.List;

public interface tmasignaturaService {
    List<tmasignaturaDto> listar();

    tmasignaturaDto obtenerPorId(Long id);

    tmasignaturaDto guardar(tmasignaturaDto dto);

    tmasignaturaDto actualizar(Long id, tmasignaturaDto dto);

    void eliminar(Long id);
}
