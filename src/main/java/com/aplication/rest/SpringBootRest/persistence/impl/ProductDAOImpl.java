package com.aplication.rest.SpringBootRest.persistence.impl;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import com.aplication.rest.SpringBootRest.persistence.IProductDAO;
import com.aplication.rest.SpringBootRest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
       return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPricel) {
        return productRepository.findProductByPriceInRange(minPrice, maxPricel);
    }

}
