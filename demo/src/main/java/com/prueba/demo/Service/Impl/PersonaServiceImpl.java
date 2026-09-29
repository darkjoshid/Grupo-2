package com.prueba.demo.Service.Impl;

import com.prueba.demo.Entity.DistritoEntity;
import com.prueba.demo.Entity.DistritoId;
import com.prueba.demo.Entity.PersonaEntity;
import com.prueba.demo.Repository.PersonaRepository;
import com.prueba.demo.Service.PersonaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PersonaEntity> listar() {

        List<PersonaEntity> listar = new ArrayList<>();
        listar = repository.findAll();//---> TRAE TODO DE LA BASE DE DATOS
        return listar;
    }

    @Override
    public List<PersonaEntity> listar_filter() {

        List<PersonaEntity> listar_upc = new ArrayList<>();
        listar_upc = repository.listar_datos();
        return listar_upc;
    }

    @Override
    public PersonaEntity guardar(PersonaEntity persona) {
        persona.setEstado(1);
        // 2. Verificamos que el JSON de Postman haya enviado el nodo distrito y su id compuesto
        if (persona.getDistrito() != null && persona.getDistrito().getId() != null) {

            // 3. Extraemos la clase ID que se deserializó automáticamente del JSON
            // (Reemplaza 'DistritoId' por el nombre exacto de la clase que representa tu llave compuesta)
            DistritoId idCompuesto = persona.getDistrito().getId();

            // 4. Creamos una referencia proxy ficticia asociada a la sesión de Hibernate
            DistritoEntity distritoProxy = entityManager.getReference(DistritoEntity.class, idCompuesto);

            // 5. Interceptamos y sustituimos el objeto suelto por el objeto gestionado
            persona.setDistrito(distritoProxy);
        }
        return repository.save(persona);
    }
}
