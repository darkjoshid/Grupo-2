package com.example.demo.Repository;

import com.example.demo.Entity.SesionTutoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionTutoriaRepository extends JpaRepository<SesionTutoriaEntity, Long> {

    @Query("SELECT s FROM SesionTutoriaEntity s WHERE s.estado = true")
    List<SesionTutoriaEntity> ListaSesionesTutoriasActivas();

    @Query("SELECT s FROM SesionTutoriaEntity s WHERE s.idSesionTutoria = :id AND s.estado = true")
    SesionTutoriaEntity BuscarPorId(@Param("id") Long id);

    @Query("SELECT s FROM SesionTutoriaEntity s WHERE s.estudiante.idEstudiante = :idEstudiante AND s.estado = true")
    List<SesionTutoriaEntity> BuscarPorIdEstudiante(@Param("idEstudiante") Long idEstudiante);


    @Query("SELECT s FROM SesionTutoriaEntity s WHERE s.tutor.idTutor = :idTutor AND s.estado = true")
    List<SesionTutoriaEntity> BuscarPorIdTutor(@Param("idTutor") Long idTutor);

    @Query("SELECT s FROM SesionTutoriaEntity s WHERE s.asignatura.idAsignatura = :idAsignatura AND s.estado = true")
    List<SesionTutoriaEntity> BuscarPorIdAsignatura(@Param("idAsignatura") Long idAsignatura);
}
