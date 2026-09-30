package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttSesionTutoriaEntity;

import java.util.List;

public interface ttSesionTutoriaService {
    List<ttSesionTutoriaEntity> listar();
    ttSesionTutoriaEntity guardar(ttSesionTutoriaEntity sesion);
    List<ttSesionTutoriaEntity> buscarPorEstado(String estado);
    List<ttSesionTutoriaEntity> buscarPorEstudiante(Integer idEstudiante);
}
