package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;

public interface SaveMakerUseCase {
    MakerDTO saveMaker (MakerDTO makerDTO);
}
