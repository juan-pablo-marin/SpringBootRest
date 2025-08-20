package com.aplication.rest.SpringBootRest.controllers.dto;

import com.aplication.rest.SpringBootRest.entities.Product;
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

    /**
     * Se agregan los mismos atributos de la clase sin las anotaciones
     */
    private Long id;
    private String name;
    private List<Product> productList=new ArrayList<>();

}
