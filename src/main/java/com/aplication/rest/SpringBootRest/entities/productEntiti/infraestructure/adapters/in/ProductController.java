package com.aplication.rest.SpringBootRest.entities.productEntiti.infraestructure.adapters.in;

import com.aplication.rest.SpringBootRest.entities.productEntiti.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController  {

    private final GetByIdUseCase getByIdUseCase;
    private final GetAllUseCase getAllUseCase;
    private final DeleteByIdUseCase deleteByIdUseCase;
    private final SaveUseCase saveUseCase;
    private final UpdateByIdUseCase updateByIdUseCase;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
       List<ProductDTO> productDTOList =  getAllUseCase.finAll();
       return ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO  productDTO) throws URISyntaxException {
        ProductDTO product = saveUseCase.saveProduct(productDTO);
        return ResponseEntity.created(new URI("api/product/save")).build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<ProductDTO>> getByid(@PathVariable Long id) {
         Optional<ProductDTO> productDTOOptional=  getByIdUseCase.findById(id);
         return ResponseEntity.ok(productDTOOptional);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        ProductDTO product = saveUseCase.saveProduct(productDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id) {
        deleteByIdUseCase.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
            productDTO.setId(id);   
            ProductDTO product = updateByIdUseCase.updateProduct(productDTO);
            return ResponseEntity.ok(product);
    }
}


