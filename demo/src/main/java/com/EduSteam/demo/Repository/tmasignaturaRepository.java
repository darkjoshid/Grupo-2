package com.EduSteam.demo.Repository;


import com.EduSteam.demo.Entity.tmasignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tmasignaturaRepository extends JpaRepository<tmasignaturaEntity, Long> {
}
