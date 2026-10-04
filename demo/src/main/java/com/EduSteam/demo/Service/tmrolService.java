package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.tmrolEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public interface tmrolService {

    List<tmrolEntity> listar();
    tmrolEntity guardar (tmrolEntity  tmrolentity);


}
