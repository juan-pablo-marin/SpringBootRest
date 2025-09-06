package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;

import java.util.Optional;

public interface ProductPortOu {
    Optional<ProductDTO> getbiid (Long id); //paso 3
}
