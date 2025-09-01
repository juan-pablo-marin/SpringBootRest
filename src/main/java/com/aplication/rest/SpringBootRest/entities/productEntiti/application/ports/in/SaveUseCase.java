package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.dto.ProductDTO;

public interface SaveUseCase {
   ProductDTO saveProduct (ProductDTO productDTO);
}
