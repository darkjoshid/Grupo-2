package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.tmasignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface tmasignaturaRepository extends JpaRepository<tmasignaturaEntity, Long> {

    // Solo asignaturas activas (eliminación lógica: estadoAsignatura = true)
    @Query("SELECT a FROM tmasignaturaEntity a WHERE a.estadoAsignatura = true")
    List<tmasignaturaEntity> listarActivas();

    @Query("SELECT a FROM tmasignaturaEntity a WHERE a.idasignatura = :id AND a.estadoAsignatura = true")
    Optional<tmasignaturaEntity> buscarActivaPorId(@Param("id") Long id);

    @Query("SELECT a FROM tmasignaturaEntity a WHERE a.tutor.idtutor = :idtutor AND a.estadoAsignatura = true")
    List<tmasignaturaEntity> listarActivasPorTutor(@Param("idtutor") Long idtutor);
}