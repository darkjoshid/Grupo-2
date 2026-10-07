package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.tetutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface tetutorRepository extends JpaRepository<tetutorEntity, Long>{
    boolean existsByUsuario_Idusuario(Long idusuario);

    @Query("SELECT t FROM tetutorEntity t WHERE t.estadoTutor = true")
    List<tetutorEntity> listarActivos();

    @Query("SELECT t FROM tetutorEntity t WHERE t.idtutor = :id AND t.estadoTutor = true")
    Optional<tetutorEntity> buscarActivoPorId(@Param("id") Long id);

}
