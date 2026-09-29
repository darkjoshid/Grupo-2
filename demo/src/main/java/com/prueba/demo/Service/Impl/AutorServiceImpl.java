package com.prueba.demo.Service.Impl;

import com.prueba.demo.Entity.AutorEntity;
import com.prueba.demo.Repository.AutorRepository;
import com.prueba.demo.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository repository;

    @Override
    public List<AutorEntity> listar() {
        List<AutorEntity> listar = new ArrayList<>();
        listar = repository.findAll();

        return listar;
    }
}
