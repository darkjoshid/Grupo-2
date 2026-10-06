package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.tetutorEntity;

import java.util.List;

public interface tetutorService {

    List<tetutorEntity> listar();

    tetutorEntity listarId(Long idtutor);

    tetutorEntity guardar(tetutorEntity tetutor);

    tetutorEntity actualizar(tetutorEntity tetutor);

    void eliminar(Long idtutor);
}