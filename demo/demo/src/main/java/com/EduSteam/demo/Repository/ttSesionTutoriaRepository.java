package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttSesionTutoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ttSesionTutoriaRepository extends JpaRepository<ttSesionTutoriaEntity, Integer> {

    @Query("SELECT s FROM TtSesionTutoriaEntity s WHERE s.estado = ?1")
    List<ttSesionTutoriaEntity> buscarPorEstado(String estado);

    @Query("SELECT s FROM TtSesionTutoriaEntity s WHERE s.estudiante.idEstudiante = ?1")
    List<ttSesionTutoriaEntity> buscarPorEstudiante(Integer idEstudiante);
}
