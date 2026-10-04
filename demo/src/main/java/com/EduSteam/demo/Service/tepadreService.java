package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.tepadreEntity;

import java.util.List;

public interface tepadreService {

    List<tepadreEntity> listar();
    tepadreEntity guardar(tepadreEntity tepadre);
}
