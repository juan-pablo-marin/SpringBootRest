package com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.productEntiti.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductPortOut {

//    Optional<Product> findById(Long id);
//    List<Product> findAll();
//    void save(Product product);
//    ProductDTO create(ProductDTO productDTO);
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );
//    ProductDTO getById(Long id);
//    List<ProductDTO> getAll();
//    void deleteById(Long id);
    void otraFuncion ();
//    //ProductDTO updatem (ProductDTO product);

    void deleteById(Long id);
    List<ProductDTO> finAll();
    Optional<ProductDTO> findById (Long id);
    ProductDTO saveProduct (ProductDTO productDTO);
    ProductDTO updateProduct (ProductDTO productDTO);

}
