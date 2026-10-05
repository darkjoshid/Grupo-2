package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ttprogresoacademicoRepository extends JpaRepository<ttprogresoacademicoEntity, Long> {
}