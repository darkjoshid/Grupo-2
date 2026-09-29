package com.prueba.demo.Service.Impl;

import com.prueba.demo.Dto.PersonaDto;
import com.prueba.demo.Entity.PersonaEntity;
import com.prueba.demo.Repository.PersonaRepository;
import com.prueba.demo.Service.PersonaDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaDtoServiceImpl implements PersonaDtoService {

    @Autowired
    private PersonaRepository repository;

    @Override
    public List<PersonaDto> listar_personaDto() {
        List<PersonaEntity> listar = new ArrayList<>();
        listar = repository.listar_datos();

        List<PersonaDto> listarDto = new ArrayList<>();

        for(PersonaEntity personaEntity : listar){

            PersonaDto personaDto = new PersonaDto();

            personaDto.setIdpersona(personaEntity.getIdpersona());
            personaDto.setNombre_persona(personaEntity.getNombre_persona());
            personaDto.setApellido_persona(personaEntity.getApellido_persona());
            personaDto.setDni_persona(personaEntity.getDni_persona());
            personaDto.setEdad_persona(personaEntity.getEdad_persona());
            personaDto.setEstado(personaEntity.getEstado());

            listarDto.add(personaDto);

        }


        return listarDto;
    }
}
