package com.example.demo.Service;

import com.example.demo.Entity.SesionTutoriaEntity;

import java.util.List;

public interface SesionTutoriaService {

    List<SesionTutoriaEntity> listarActivas();
    List<SesionTutoriaEntity> listarPorIdEstudiante(Long idEstudiante);
    List<SesionTutoriaEntity> listarPorIdTutor(Long idTutor);
    SesionTutoriaEntity buscarPorId(Long id);
    SesionTutoriaEntity registrar(SesionTutoriaEntity sesion);
    SesionTutoriaEntity actualizar(Long id, SesionTutoriaEntity sesion);
    void eliminarLogico(Long id);
}
