package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Entity.tmrolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tmrolRepository   extends JpaRepository<tmrolEntity, Integer> {
}