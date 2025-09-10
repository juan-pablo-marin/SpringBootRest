package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.out.persistence;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakerRepository extends JpaRepository<Maker,Long > {

    @Query("SELECT p FROM Maker p WHERE LOWER(p.name)  LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Maker> filterword (@Param("word") String word);
}
