package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.tmrolEntity;
import com.EduSteam.demo.Repository.tmrolRepository;
import com.EduSteam.demo.Service.tmrolService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class tmrolImpl implements tmrolService {

    @Autowired
    private tmrolRepository rolRepository;
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<tmrolEntity> listar() {

        List<tmrolEntity> listar = new ArrayList<>();
        listar=rolRepository.findAll();
        return listar;



    }

    @Override
    public tmrolEntity guardar(tmrolEntity tmrol) {


        return rolRepository.save(tmrol);
    }

    @Override
    public tmrolEntity listarId(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);


    }

    @Override
    public void update(tmrolEntity tmrolentity) {

        rolRepository.save(tmrolentity);
    }
}