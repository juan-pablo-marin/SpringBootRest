package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;

public interface UpdateByIdUseCase {
    ProductDTO updateProduct (ProductDTO productDTO);
}
