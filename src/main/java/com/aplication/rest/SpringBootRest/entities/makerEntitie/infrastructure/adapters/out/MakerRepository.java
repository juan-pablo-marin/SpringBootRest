package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.out;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker,Long > {

}
