package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;

public interface GetUseCase {
    MakerDTO getId (Long id);
}
