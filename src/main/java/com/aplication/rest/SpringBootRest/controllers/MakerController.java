package com.aplication.rest.SpringBootRest.controllers;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.controllers.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.service.IMakerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")
public class MakerController {
    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker= makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return  ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping ("/findAll")
    public ResponseEntity<?> findAll (){
        List<MakerDTO> responseMaker =makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .name (maker.getName())
                        .id(maker.getId())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(responseMaker);
    }

    @PostMapping("/save")
    public ResponseEntity <?> save ( @RequestBody MakerDTO makerDTO ) throws URISyntaxException {

      if(makerDTO.getId()==null || makerDTO.getName().isBlank() || makerDTO.getProductList().isEmpty() ){
          ResponseEntity.badRequest().body("sdsdsd");
      }

       Maker maker =  Maker.builder()
               .name(makerDTO.getName())
               .build();
       makerService.save(maker);
       return ResponseEntity.created(new URI("api/maker/save")).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete ( @PathVariable Long id){

        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        makerService.deleteById(id);
        return ResponseEntity.ok("Regsitro Eliminado");
    }

    @PutMapping("/update")
    public ResponseEntity <?> update (@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker= Maker.builder()
                    .name(makerDTO.getName())
                    .build();
            makerService.save(maker);
            return ResponseEntity.ok("Atualizacion exitosa");
        }
        return ResponseEntity.badRequest().build();
    }


}
