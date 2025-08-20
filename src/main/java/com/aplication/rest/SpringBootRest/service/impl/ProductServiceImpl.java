package com.aplication.rest.SpringBootRest.service.impl;

import com.aplication.rest.SpringBootRest.entities.Product;
import com.aplication.rest.SpringBootRest.persistence.impl.ProductDAOImpl;
import com.aplication.rest.SpringBootRest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDAOImpl productDAO;

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id) ;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal) {
        return productDAO.findByPriceInRange(minPrice, maxDecimal);
    }
}
