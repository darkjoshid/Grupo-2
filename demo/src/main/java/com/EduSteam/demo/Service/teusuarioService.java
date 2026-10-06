package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.teusuarioEntity;

import java.util.List;

public interface teusuarioService {

    List<teusuarioEntity> listar();
    teusuarioEntity guardar(teusuarioEntity teusuario);
}
