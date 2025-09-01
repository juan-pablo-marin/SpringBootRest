package com.aplication.rest.SpringBootRest.entities.productEntiti.infraestructure.adapters.out.persistence;

import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out.ProductPortOut;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import com.aplication.rest.SpringBootRest.entities.productEntiti.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductPersistenceAdapter implements ProductPortOut {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal) {
        return List.of();
    }

    @Override
    public void otraFuncion() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ProductDTO> finAll() {
     return productRepository.findAll()
             .stream()
             .map(productMapper::toProductDto)
             .toList();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return null;
    }
}


