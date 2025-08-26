package com.aplication.rest.SpringBootRest.persistence;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    List<Maker> findAll ();
    Optional<Maker> findById (Long id);
    Maker save(Maker maker);
    void deleteById(Long id);

}
