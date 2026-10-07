package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.teusuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teusuarioRepository  extends JpaRepository<teusuarioEntity, Long> {
    teusuarioEntity findByNombreusuario(String nombreusuario);
}
