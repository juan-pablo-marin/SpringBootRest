package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.in;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.configuration.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Fabricantes", description = "Controlador que ejecuta el CRUD para los Fabricantes")
@RestController
@RequestMapping("api/maker")
@RequiredArgsConstructor
public class MakerController {

    private final DeleteByIdUseCase deleteByIdUseCase;
    private final GetAllUseCase getAllUseCase;
    private final GetByIdUseCase getByIdUseCase;
    private final SaveMakerUseCase saveMakerUseCase;
    private final UpdateMakerUseCase updateMakerUseCase;
    private final PageFindAllMaker pageFindAllMaker;

    @Operation(summary = "Elimina un registro por parametro -> SCOPE : USER ")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<?> delete (@Valid @PathVariable Long id){
        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        deleteByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
    }

    @Operation(summary = "Genera el listado de todos los Fabricantes con su informacion -> SCOPE : USER")
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  getAllUseCase.getAll();
       return ResponseEntity.ok(list);
    }

    @Operation(summary = "Genera la informacion de un Fabricantes segun Id -> SCOPE : USER")
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<?> getById(@PathVariable Long id ){
        Optional<MakerDTO> makerDTO= getByIdUseCase.getById(id);
     return ResponseEntity.ok(makerDTO);
    }

    @Operation(summary = "Guarda los datos enviados en la base de datos-> SCOPE : ADMIN")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public  ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) {
        MakerDTO maker =  saveMakerUseCase.saveMaker(makerDTO);
        return ResponseEntity.ok(maker);
    }


    @Operation(summary = "Actualiza los datos de un Fabricante -> SCOPE : ADMIN")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> update ( @Parameter(description = "Ingrese el Id del Fabricante que va modificar")
                                          @PathVariable  Long id,
                                      @RequestBody  MakerDTO makerDTO ){
        makerDTO.setId(id);
        MakerDTO makerUpdate = updateMakerUseCase.update(makerDTO);
        return  ResponseEntity.ok(makerUpdate);
    }


    @Operation(summary = "Muestra por paginacion la informacion solicitada-> SCOPE : ADMIN")
    @GetMapping ("/listAll")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<PageResult<MakerDTO>> listAll(Pageable pageable) {
        var result = pageFindAllMaker.listAll(pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(result);
    }

}
