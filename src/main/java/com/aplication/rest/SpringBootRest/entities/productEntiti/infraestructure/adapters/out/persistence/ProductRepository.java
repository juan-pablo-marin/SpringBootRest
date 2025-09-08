package com.aplication.rest.SpringBootRest.entities.productEntiti.infraestructure.adapters.out.persistence;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository  <Product, Long> {
    /**
     * utiliza la anotacion Query porque JPA no conoce InRange,se parece q SQL pero no lo es
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    /**
     * esta forma de solicitar informacion la conoce JPA se llaman QUERY METODOS
     * @param minPrice
     * @param maxPrice
     * @return
     */
    List<Product> findProductByPriceBetween(BigDecimal minPrice,BigDecimal maxPrice) ;

}
