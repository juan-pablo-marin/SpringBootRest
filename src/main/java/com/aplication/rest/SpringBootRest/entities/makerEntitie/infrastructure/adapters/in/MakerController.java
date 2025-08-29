package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.DeleteByIdUseCase;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.GetAllUseCase;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.GetByIdUseCase;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.SaveMakerUseCase;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out.MakerOutputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")
@RequiredArgsConstructor
public class MakerController {

    private final DeleteByIdUseCase deleteByIdUseCase;
    private final GetAllUseCase getAllUseCase;
    private final GetByIdUseCase getByIdUseCase;
//    private final SaveMakerUseCase saveMakerUseCase;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@Valid @PathVariable Long id){

        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        deleteByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
    }
//
    @GetMapping("/getAll")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  getAllUseCase.getAll();
       return ResponseEntity.ok(list);
    }
//
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id ){
        Maker maker= getByIdUseCase.getById(id);
     return ResponseEntity.ok(maker);
    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateMaker (@Valid @PathVariable Long id, @RequestBody MakerDTO makerDTO){
//        MakerDTO makerOptional = getByIdUseCase.getById(id);
//
//        if(makerOptional != null){
//            MakerDTO update =saveMakerUseCase.saveMaker(makerDTO);
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
//    }
//
//    @PostMapping ("/save")
//    public ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) throws URISyntaxException {
//        MakerDTO create=saveMakerUseCase.saveMaker(makerDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(create);
//    }
}
