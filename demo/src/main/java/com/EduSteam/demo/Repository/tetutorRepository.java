package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.tetutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tetutorRepository extends JpaRepository<tetutorEntity, Long> {

}