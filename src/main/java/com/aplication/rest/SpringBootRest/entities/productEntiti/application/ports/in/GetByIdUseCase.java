package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import com.aplication.rest.SpringBootRest.entities.productEntiti.dto.ProductDTO;
import com.sun.source.tree.OpensTree;

import java.util.Optional;

public interface GetByIdUseCase {

   Optional<ProductDTO> findById (Long id);
}
