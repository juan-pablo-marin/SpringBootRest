package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.in;

import com.aplication.rest.SpringBootRest.configuration.swagger.ApiCommonResponses;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.configuration.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

import com.aplication.rest.SpringBootRest.configuration.swagger.SwaggerResponseConstants;
import static com.aplication.rest.SpringBootRest.configuration.swagger.SwaggerResponseConstants.*;

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
    private final FilterWordUseCase filterWordUseCase;


    @Operation(summary = "Elimina un registro por parametro",
            description = "Ingrese el Id del Fabricante que va Eliminar -> SCOPE : ADMIN",
            tags ={"Fabricantes","delete" }
    )
    @ApiCommonResponses
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@Valid @PathVariable Long id){
        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        deleteByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
    }

    @Operation(summary = "Genera el listado de todos los Fabricantes con su informacion",
            description = "Se van a listar todos los fabricantes de la base de datos -> SCOPE : USER",
            tags ={"Fabricantes","getAll"})
    @ApiCommonResponses
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/getAll")
    public ResponseEntity <List<MakerDTO>> getAll (){
       List<MakerDTO> list =  getAllUseCase.getAll();
       return ResponseEntity.ok(list);
    }

    @Operation(summary = "Genera la informacion de un Fabricantes segun Id ",
            description = "Se va mostrar el fabricante segun Id ingresado ->SCOPE : USER",
            tags ={"Fabricantes","get/id"})
    @ApiCommonResponses
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<?> getById(@PathVariable Long id ){
        Optional<MakerDTO> makerDTO= getByIdUseCase.getById(id);
     return ResponseEntity.ok(makerDTO);
    }

    @Operation(summary = "Guarda los datos enviados en la base de datos",
            description = "Con el JSON bien estructurado se guarda el registro en la base de datos -> SCOPE : ADMIN",
            tags ={"Fabricantes","save"})
    @ApiCommonResponses
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/save")
    public  ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) {
        MakerDTO maker =  saveMakerUseCase.saveMaker(makerDTO);
        return ResponseEntity.ok(maker);
    }

    @Operation(summary = "Actualiza los datos de un Fabricante",
            description = "Ingrese el Id del Fabricante que va modificar -> SCOPE : ADMIN",
            tags ={"Fabricantes","update" })
    @ApiResponses({
            @ApiResponse(responseCode = SWAGGER_200_CODE, description = SWAGGER_200_DESCRIPTION, content = @Content ), //content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MakerDTO.class))) ,
            @ApiResponse(responseCode = SWAGGER_201_CODE, description = SWAGGER_201_DESCRIPTION, content = @Content ),
            @ApiResponse(responseCode = SWAGGER_400_CODE, description = SWAGGER_400_DESCRIPTION, content = @Content ),
            @ApiResponse(responseCode = SWAGGER_404_CODE, description = SWAGGER_404_DESCRIPTION, content = @Content ),
            @ApiResponse(responseCode = SWAGGER_401_CODE, description = SWAGGER_401_DESCRIPTION, content = @Content )})
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<MakerDTO> update (@Valid  @RequestBody  MakerDTO makerDTO,
           @Parameter( description = "Ingrese el Id del Fabricante que va modificar", required = true )
           @PathVariable  Long id )
    {
        System.out.println(SwaggerResponseConstants.class);
        makerDTO.setId(id);
        MakerDTO makerUpdate = updateMakerUseCase.update(makerDTO);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(makerUpdate);
    }


    @Operation(summary = "Muestra por paginacion la informacion solicitada AUN PENDIENTE...",
            description = "Se lista la informacion segun la paginacion indicada -> SCOPE : ADMIN",
            tags ={"Fabricantes","listAll"})
    @ApiCommonResponses
    @Parameters({
          //  @Parameter(name = "title", description = "Search Tutorials by title"),
            @Parameter(name = "page", description = "Page number, starting from 0", required = true),
            @Parameter(name = "size", description = "Number of items per page", required = true)
    })
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping ("/listAll")
    public ResponseEntity<PageResult<MakerDTO>> listAll( @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "3") Pageable pageable) {

        var result = pageFindAllMaker.listAll(pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(result);
    }
    @Operation(summary = "Filtra por palabra clave",
            description = "Busca en el campo nombre los que tenga parte de la palabra y muestra un listado -> SCOPE: ADMIN",
            tags ={"Fabricantes","filter"})
    @ApiCommonResponses
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/filter/{word}")
    public ResponseEntity<List<MakerDTO>> filter (@PathVariable String word ){
        List<MakerDTO> list = filterWordUseCase.filterWord(word);
        return ResponseEntity.ok(list);
    }
}
