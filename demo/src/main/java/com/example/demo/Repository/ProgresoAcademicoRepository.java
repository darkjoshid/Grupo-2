package com.example.demo.Repository;

import com.example.demo.Entity.ProgresoAcademicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgresoAcademicoRepository extends JpaRepository<ProgresoAcademicoEntity, Long> {

    @Query("SELECT p FROM ProgresoAcademicoEntity p WHERE p.estadoProgreso = true")
    List<ProgresoAcademicoEntity> ListaProgresoAcademicoActivos();

    @Query("SELECT p FROM ProgresoAcademicoEntity p WHERE p.idProgreso = :id AND p.estadoProgreso = true")
    ProgresoAcademicoEntity BuscarPorId(@Param("id") Long id);

    @Query("SELECT p FROM ProgresoAcademicoEntity p WHERE p.estudiante.idEstudiante = :idEstudiante AND p.estadoProgreso = true")
    List<ProgresoAcademicoEntity> BuscarPorEstudiante (@Param("idEstudiante") Long idEstudiante);

    @Query("SELECT p FROM ProgresoAcademicoEntity p WHERE p.asignatura.idAsignatura = :idAsignatura AND p.estadoProgreso = true")
    List<ProgresoAcademicoEntity> BuscarPorAsignatura (@Param("idAsignatura") Long idAsignatura);

}
