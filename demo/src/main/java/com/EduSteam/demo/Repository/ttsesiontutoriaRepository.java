package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ttsesiontutoriaRepository extends JpaRepository<ttsesiontutoriaEntity, Long> {

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.estado = true")
    List<ttsesiontutoriaEntity> ListaSesionesTutoriasActivas();

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.idSesionTutoria = :id AND s.estado = true")
    ttsesiontutoriaEntity BuscarPorId(@Param("id") Long id);

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.estudiante.idestudiante = :idEstudiante AND s.estado = true")
    List<ttsesiontutoriaEntity> BuscarPorIdEstudiante(@Param("idEstudiante") Long idEstudiante);


    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.tutor.idtutor = :idTutor AND s.estado = true")
    List<ttsesiontutoriaEntity> BuscarPorIdTutor(@Param("idTutor") Long idTutor);

    @Query("SELECT s FROM ttsesiontutoriaEntity s WHERE s.asignatura.idasignatura = :idAsignatura AND s.estado = true")
    List<ttsesiontutoriaEntity> BuscarPorIdAsignatura(@Param("idAsignatura") Long idAsignatura);
}
