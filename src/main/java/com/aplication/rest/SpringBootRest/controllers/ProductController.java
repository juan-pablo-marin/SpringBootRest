package com.aplication.rest.SpringBootRest.controllers;

import com.aplication.rest.SpringBootRest.controllers.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.Product;
import com.aplication.rest.SpringBootRest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductDTO productDTO = ProductDTO.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker((product.getMaker()))
                    .id(product.getId())
                    .build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTO = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO  productDTO) throws URISyntaxException {
        if(productDTO.getName().isBlank() || productDTO.getPrice()==null || productDTO.getMaker()==null ){
            return ResponseEntity.badRequest().build();
        }
       Product product= Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();
        productService.save(product);
        return ResponseEntity.created(new URI("api/product/save")).build();
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity <?> deleteById (@PathVariable Long id){

        if (id != null && productService.findById(id).isPresent()){
            productService.deleteById(id);
            return ResponseEntity.ok("Regsitro Eliminado");
        }
        return ResponseEntity.badRequest().body("la solicitud esta Mal generada ");
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
         Optional<Product> productOptional = productService.findById(id);

         if(productOptional.isPresent() ){
             Product product = productOptional.get();
             product.setName(productDTO.getName());
             productService.save(product);
             return ResponseEntity.ok("Registro Actualizado");
         }
         return ResponseEntity.notFound().build();
    }

}
