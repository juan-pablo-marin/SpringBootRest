package com.aplication.rest.SpringBootRest.entities.productEntiti.application.service;

import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out.ProductPortOut;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductPortOutImpl implements DeleteByIdUseCase, GetByIdUseCase, GetAllUseCase, SaveUseCase, UpdateByIdUseCase {

    public final ProductPortOut productPortOut;

    @Override
    public List<ProductDTO> finAll() {
        return productPortOut.finAll();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productPortOut.findById(id);
    }

     @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return productPortOut.saveProduct(productDTO);
    }

    @Override
    public ProductDTO updateProduct( ProductDTO productDTO) {
        return productPortOut.updateProduct(productDTO);
    }

    @Override
    public void deleteById(Long id) {
        productPortOut.deleteById(id);
    }
}
