package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;

import java.util.List;

public interface GetAllUseCase {
    List<MakerDTO> getAll();
}
