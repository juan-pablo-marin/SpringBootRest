package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.dto.ProductDTO;

import java.util.List;

public interface GetAllUseCase {

    List<ProductDTO> finAll();
}


