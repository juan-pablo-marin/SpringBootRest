package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;

import java.util.Optional;

public interface GetByIdUseCase {
    Optional<MakerDTO> getById(Long id);
}
