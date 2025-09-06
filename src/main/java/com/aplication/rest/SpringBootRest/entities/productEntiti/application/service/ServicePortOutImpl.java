package com.aplication.rest.SpringBootRest.entities.productEntiti.application.service;

import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in.GetBiIdUseCase;
import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.out.ProductPortOu;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePortOutImpl implements GetBiIdUseCase {

    public final ProductPortOu productPortOu;

    @Override  //paso 4
    public Optional<ProductDTO> getbiid(Long id) {
        return productPortOu.getbiid(id);
    }
 }
