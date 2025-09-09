package com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model;


import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "fabricante")
@Schema(description = "Clase que representa un Fabricante")
public class Maker {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nombre")
    private String name;

    @OneToMany (mappedBy = "maker",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Product> productList=new ArrayList<>();

}
