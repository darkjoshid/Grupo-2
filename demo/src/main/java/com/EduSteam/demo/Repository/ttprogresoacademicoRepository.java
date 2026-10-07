package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ttprogresoacademicoRepository extends JpaRepository<ttprogresoacademicoEntity, Long> {
    List<ttprogresoacademicoEntity> findByEstadoProgreso(Boolean estadoProgreso);

}