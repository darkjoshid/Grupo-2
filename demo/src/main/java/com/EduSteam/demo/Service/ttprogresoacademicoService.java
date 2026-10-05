package com.EduSteam.demo.Service;

import com.EduSteam.demo.Dto.ttprogresoacademicoDto;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;

import java.util.List;

public interface ttprogresoacademicoService {
    List<ttprogresoacademicoEntity> listarActivos();
    ttprogresoacademicoEntity registrar(ttprogresoacademicoDto dto);
    void eliminarLogico(Long id);
}