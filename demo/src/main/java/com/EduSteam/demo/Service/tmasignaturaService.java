package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.tmasignaturaEntity;

import java.util.List;

public interface tmasignaturaService {

    List<tmasignaturaEntity> listar();

    tmasignaturaEntity listarId(Long idasignatura);

    tmasignaturaEntity guardar(tmasignaturaEntity tmasignatura);

    tmasignaturaEntity actualizar(tmasignaturaEntity tmasignatura);

    void eliminar(Long idasignatura);
}