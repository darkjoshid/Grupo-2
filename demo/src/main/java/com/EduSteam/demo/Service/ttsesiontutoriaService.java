package com.EduSteam.demo.Service;

import com.EduSteam.demo.Dto.ttsesiontutoriaDto;
import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import com.EduSteam.demo.Entity.ttsesiontutoriaID;

import java.util.List;

public interface ttsesiontutoriaService {
    List<ttsesiontutoriaID> listarActivos();
    ttsesiontutoriaEntity registrar(ttsesiontutoriaDto dto);
    void eliminarLogico(Long id);
}