package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;

import java.util.List;

public interface ttsesiontutoriaService {

    List<ttsesiontutoriaEntity> listarActivas();
    List<ttsesiontutoriaEntity> listarPorIdEstudiante(Long idEstudiante);
    List<ttsesiontutoriaEntity> listarPorIdTutor(Long idTutor);
    ttsesiontutoriaEntity buscarPorId(Long id);
    ttsesiontutoriaEntity registrar(ttsesiontutoriaEntity sesion);
    ttsesiontutoriaEntity actualizar(Long id, ttsesiontutoriaEntity sesion);
    void eliminarLogico(Long id);
}
