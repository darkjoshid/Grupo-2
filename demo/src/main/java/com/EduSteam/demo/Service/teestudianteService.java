package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.teestudianteEntity;

import java.util.List;

public interface teestudianteService {

    List<teestudianteEntity> listar();

    teestudianteEntity guardar(teestudianteEntity teestudiante);

    teestudianteEntity actualizar(teestudianteEntity teestudiante);

    void eliminar(Long idestudiante);
}
