package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.taauditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taauditoriaRepository extends JpaRepository<taauditoriaEntity,Integer> {
}
