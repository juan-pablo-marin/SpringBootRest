package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")
@RequiredArgsConstructor
public class MakerController {

    private final DeleteByIdUseCase deleteByIdUseCase;
    private final GetAllUseCase getAllUseCase;
    private final GetByIdUseCase getByIdUseCase;
    private final SaveMakerUseCase saveMakerUseCase;
    private final UpdateMakerUseCase updateMakerUseCase;

    @GetMapping ("/dataTest")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> dataTest (Authentication authentication) {
        return Map.of(
                "message", "Data Test",
                "usernaame", authentication.getName(),
                "authorities", authentication.getAuthorities()
        );
    }

    @GetMapping ("/saveData")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String, Object> saveData (Authentication authentication, @RequestBody String data){
       return  Map.of("dataSaved",data.toUpperCase());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@Valid @PathVariable Long id){
        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        deleteByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
    }

    @GetMapping("/getAll")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  getAllUseCase.getAll();
       return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id ){
        Optional<MakerDTO> makerDTO= getByIdUseCase.getById(id);
     return ResponseEntity.ok(makerDTO);
    }

    @PostMapping("/save")
    public  ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) {
        MakerDTO maker =  saveMakerUseCase.saveMaker(makerDTO);
        return ResponseEntity.ok(maker);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody MakerDTO makerDTO ){
        makerDTO.setId(id);
        MakerDTO makerUpdate = updateMakerUseCase.update(makerDTO);
        return  ResponseEntity.ok(makerUpdate);
    }
}
