package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;

import java.util.List;

public interface ttsesiontutoriaService {
    List<ttsesiontutoriaEntity> listarActivos();
    ttsesiontutoriaEntity registrar(ttsesiontutoriaDto dto);
    void eliminarLogico(Long id);
}