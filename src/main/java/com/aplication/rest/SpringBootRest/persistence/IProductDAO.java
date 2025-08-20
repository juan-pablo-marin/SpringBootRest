package com.aplication.rest.SpringBootRest.persistence;

import com.aplication.rest.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    /**
     * aqui se definen los metodos a utilizar
     * se utiliza el patron de diseño DAO como buena practica
     *
      */

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void save(Product product);

    void deleteById(Long id);

/**
 * este metodo es es para usar query metodos
 **/
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );

}
