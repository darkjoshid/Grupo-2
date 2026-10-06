package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ttprogresoacademicoRepository extends JpaRepository<ttprogresoacademicoEntity, Long> {

    @Query("SELECT p FROM ttprogresoacademicoEntity p WHERE p.estadoProgreso = true")
    List<ttprogresoacademicoEntity> ListaProgresoAcademicoActivos();

    @Query("SELECT p FROM ttprogresoacademicoEntity p WHERE p.idProgreso = :id AND p.estadoProgreso = true")
    ttprogresoacademicoEntity BuscarPorId(@Param("id") Long id);

    @Query("SELECT p FROM ttprogresoacademicoEntity p WHERE p.estudiante.idestudiante = :idEstudiante AND p.estadoProgreso = true")
    List<ttprogresoacademicoEntity> BuscarPorEstudiante (@Param("idEstudiante") Long idEstudiante);

    @Query("SELECT p FROM ttprogresoacademicoEntity p WHERE p.asignatura.idasignatura = :idAsignatura AND p.estadoProgreso = true")
    List<ttprogresoacademicoEntity> BuscarPorAsignatura (@Param("idAsignatura") Long idAsignatura);

}
