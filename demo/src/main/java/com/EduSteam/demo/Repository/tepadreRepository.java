package com.EduSteam.demo.Repository;

import com.EduSteam.demo.Entity.tepadreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tepadreRepository extends JpaRepository<tepadreEntity, Long> {

}
