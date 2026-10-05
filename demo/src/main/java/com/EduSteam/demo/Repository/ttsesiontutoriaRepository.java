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

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.estado = true")
    List<ttsesiontutoriaEntity> listaSesionesActivas();

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.idSesionTutoria = :id AND s.estado = true")
    Optional<ttsesiontutoriaEntity> buscarPorIdActivo(@Param("id") Long id);
}