package com.prueba.demo.Controller;

import com.prueba.demo.Dto.PersonaDto;
import com.prueba.demo.Entity.PersonaEntity;
import com.prueba.demo.Service.PersonaDtoService;
import com.prueba.demo.Service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @Autowired
    private PersonaDtoService serviceDto;

    @GetMapping("listar_upc")
    public List<PersonaEntity> listar_personas(){

        List<PersonaEntity> listar_nuevo = new ArrayList<>();

        listar_nuevo = service.listar();

        return listar_nuevo;

    }

    @GetMapping("alumnos")
    public List<PersonaEntity> listamos(){
        List<PersonaEntity> listar_nuevo1 = new ArrayList<>();

        listar_nuevo1 = service.listar_filter();

        return listar_nuevo1;
    }


    @GetMapping("listar-dto")
    public List<PersonaDto> listardto (){

        List<PersonaDto> listar_nuevo = new ArrayList<>();

        listar_nuevo = serviceDto.listar_personaDto();


        return listar_nuevo;
    }

    @PostMapping("/savepersona")
    public PersonaEntity guardar_datos(@RequestBody PersonaEntity persona){

        //PersonaEntity persona_nueva = service.guardar(persona);
        System.out.println(persona);
        return service.guardar(persona);
    }


}
