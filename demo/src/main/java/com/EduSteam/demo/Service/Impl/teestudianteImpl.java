package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Entity.tepadreEntity;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Repository.teestudianteRepository;
import com.EduSteam.demo.Service.teestudianteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class teestudianteImpl implements teestudianteService {

    @Autowired
    private teestudianteRepository estudianteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<teestudianteEntity> listar() {
        List<teestudianteEntity> listar = new ArrayList<>();
        listar = estudianteRepository.findAll();
        return listar;
    }

    @Override
    public teestudianteEntity guardar(teestudianteEntity teestudiante) {

        return estudianteRepository.save(teestudiante);
    }
}
