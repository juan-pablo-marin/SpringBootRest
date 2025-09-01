package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.out.persistence;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker,Long > {

}
