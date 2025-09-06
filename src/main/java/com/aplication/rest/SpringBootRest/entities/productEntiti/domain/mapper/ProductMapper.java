package com.aplication.rest.SpringBootRest.entities.productEntiti.domain.mapper;


import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface ProductMapper {
    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDto(Product product);
    Product toProduct(ProductDTO dto);
    List<ProductDTO> toDtos(List<Product> products);

}
