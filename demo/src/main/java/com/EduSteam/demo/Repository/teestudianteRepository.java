package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.teestudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teestudianteRepository extends JpaRepository<teestudianteEntity, Long> {

}
