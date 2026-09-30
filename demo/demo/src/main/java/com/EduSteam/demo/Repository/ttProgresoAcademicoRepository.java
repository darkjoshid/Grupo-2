package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttProgresoAcademicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ttProgresoAcademicoRepository extends JpaRepository<ttProgresoAcademicoEntity, Integer> {

    @Query("SELECT p FROM TtProgresoAcademicoEntity p WHERE p.estudiante.idEstudiante = ?1")
    List<ttProgresoAcademicoEntity> buscarPorEstudiante(Integer idEstudiante);

    @Query("SELECT p FROM TtProgresoAcademicoEntity p WHERE p.calificacion = ?1")
    List<ttProgresoAcademicoEntity> buscarPorCalificacion(Integer calificacion);
}
