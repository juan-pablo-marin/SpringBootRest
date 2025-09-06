package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.configuration.PageResult;

public interface PageFindAllMaker {
    PageResult<MakerDTO> listAll(int page, int size);
}
