package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttcuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ttcuentaRepository extends JpaRepository<ttcuentaEntity,Integer> {

}
