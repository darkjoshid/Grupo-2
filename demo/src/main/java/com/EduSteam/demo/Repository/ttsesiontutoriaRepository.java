package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ttsesiontutoriaRepository extends JpaRepository<ttsesiontutoriaEntity, Long> {

    List<ttsesiontutoriaEntity> findByEstado(Boolean estado);
}