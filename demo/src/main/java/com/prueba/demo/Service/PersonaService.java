package com.prueba.demo.Service;

import com.prueba.demo.Entity.PersonaEntity;

import java.util.List;

public interface PersonaService {
    List<PersonaEntity> listar();

    List<PersonaEntity> listar_filter();

    PersonaEntity guardar (PersonaEntity persona);
}
