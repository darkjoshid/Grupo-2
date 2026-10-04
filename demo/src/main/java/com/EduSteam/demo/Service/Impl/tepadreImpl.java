package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.tepadreEntity;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Repository.tepadreRepository;
import com.EduSteam.demo.Service.tepadreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class tepadreImpl implements tepadreService {

    @Autowired
    private tepadreRepository padreRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<tepadreEntity> listar() {
        List<tepadreEntity> listar = new ArrayList<>();
        listar = padreRepository.findAll();
        return listar;
    }

    @Override
    public tepadreEntity guardar(tepadreEntity tepadre) {

        return padreRepository.save(tepadre);
    }
}
