package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;

import java.util.List;

public interface ttsesiontutoriaService {
    List<ttsesiontutoriaEntity> listarActivas();
    ttsesiontutoriaEntity obtenerPorId(Long id);
    ttsesiontutoriaEntity registrar(ttsesiontutoriaEntity sesion);
    ttsesiontutoriaEntity actualizar(Long id, ttsesiontutoriaEntity sesion);
    void eliminarLogico(Long id);
}