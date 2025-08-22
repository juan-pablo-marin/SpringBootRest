package com.aplication.rest.SpringBootRest.controllers;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.controllers.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.service.IMakerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

 /*   @PostMapping("/save")
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
*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete ( @PathVariable Long id){

        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        makerService.deleteById(id);
        return ResponseEntity.ok("Regsitro Eliminado");
    }

    @GetMapping("/getAll")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  makerService.getAll();
       return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id ){
     MakerDTO makerDTO= makerService.getById(id);
     return ResponseEntity.ok(makerDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker (@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            makerService.saveMaker(makerDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping ("/save")
    public ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) throws URISyntaxException {
        MakerDTO create=makerService.saveMaker(makerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);//.created(new URI("api/maker/save")).build();

    }
}
