package com.aplication.rest.SpringBootRest.service;

import com.aplication.rest.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void save(Product product);

    void deleteById(Long id);

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );

}
