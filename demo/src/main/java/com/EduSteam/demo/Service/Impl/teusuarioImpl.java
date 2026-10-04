package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Repository.teusuarioRepository;
import com.EduSteam.demo.Service.teusuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class teusuarioImpl implements teusuarioService {

    @Autowired
    private teusuarioRepository uarioRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<teusuarioEntity> listar() {
        List<teusuarioEntity> listar = new ArrayList<>();
        listar = uarioRepository.findAll();
        return listar;
    }

    @Override
    public teusuarioEntity guardar(teusuarioEntity teusuario) {

        return uarioRepository.save(teusuario);

    }
}

