package com.aplication.rest.SpringBootRest.persistence;

import com.aplication.rest.SpringBootRest.entities.productEntiti.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    /** se utiliza el patron de diseño DAO como buena practica      */
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product productDTO);
    void deleteById(Long id);
    /**este metodo es es para usar query metodos **/
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );


}
