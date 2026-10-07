package com.EduSteam.demo.Service;

import com.EduSteam.demo.Dto.ttprogresoacademicoDto;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Entity.ttprogresoacademicoID;

import java.util.List;

public interface ttprogresoacademicoService {
    List<ttprogresoacademicoID> listarActivos();
    ttprogresoacademicoID registrar(ttprogresoacademicoDto dto);
    void eliminarLogico(Long id);
}