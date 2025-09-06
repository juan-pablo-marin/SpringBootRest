package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductPortOut {

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );
    void deleteById(Long id);
    List<ProductDTO> finAll();
    Optional<ProductDTO> findById (Long id);
    ProductDTO saveProduct (ProductDTO productDTO);
    ProductDTO updateProduct (ProductDTO productDTO);

}
