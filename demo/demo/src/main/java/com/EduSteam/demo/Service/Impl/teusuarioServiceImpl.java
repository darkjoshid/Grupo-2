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
public class teusuarioServiceImpl implements teusuarioService {

   @Autowired
   private teusuarioRepository usuarioRepository;
   @PersistenceContext
   private EntityManager entityManager;



    @Override
    public List<teusuarioEntity> listar() {
        List<teusuarioEntity> listar=new ArrayList<>();
        listar=usuarioRepository.findAll();
        return listar;
    }

    @Override
    public teusuarioEntity guardar(teusuarioEntity teusuario) {

        if (teusuario.getActivo() == null) {
            teusuario.setActivo(true);
        }
        if (teusuario.getFechaCreacion() == null) {
            teusuario.setFechaCreacion(java.time.LocalDateTime.now());
        }

        return usuarioRepository.save(teusuario);
    }

}
