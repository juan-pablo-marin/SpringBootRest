package com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto;

import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    private Long id;
    @NotNull(message = "El campo 'nombre' es obligatorio")
    private String name;
    private List<Product> productList=new ArrayList<>();

}
