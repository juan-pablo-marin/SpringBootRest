package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;

import java.util.Optional;

public interface GetByIdUseCase {

    Optional<ProductDTO> findById(Long id); // paso 2
}
