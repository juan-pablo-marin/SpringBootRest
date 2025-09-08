package com.aplication.rest.SpringBootRest.entities.productEntiti.infraestructure.adapters.out.persistence;

import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out.ProductPortOu;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class PersistenceAdapter implements ProductPortOu {

    @Autowired
    public final ProductRepository productRepository;
    public final ProductMapper productMapper;

    @Override
    public Optional<ProductDTO> getbiid(Long id) {
           return productRepository.findById(id).map(productMapper::toProductDto);
    }
}
