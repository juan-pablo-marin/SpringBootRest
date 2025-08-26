package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    /**
     *nos traemos los mismos metodos del DAO en este caso IMakerDAO
     */


    List<Maker> findAll ();

    Optional<Maker> findById (Long id);

    void save(Maker maker);

    void deleteById(Long id);

    List<MakerDTO> getAll();

    MakerDTO getById(Long id);

    MakerDTO saveMaker (MakerDTO makerDTO);
}
