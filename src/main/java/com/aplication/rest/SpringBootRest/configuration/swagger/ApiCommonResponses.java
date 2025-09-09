package com.aplication.rest.SpringBootRest.configuration.swagger;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.dto.MakerDTO;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.media.*;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

import static com.aplication.rest.SpringBootRest.configuration.swagger.SwaggerResponseConstants.*;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses({
        @ApiResponse(responseCode = SWAGGER_200_CODE, description = SWAGGER_200_DESCRIPTION, content = @Content),
        @ApiResponse(responseCode = SWAGGER_201_CODE, description = SWAGGER_201_DESCRIPTION, content = @Content),
        @ApiResponse(responseCode = SWAGGER_400_CODE, description = SWAGGER_400_DESCRIPTION, content = @Content),
        @ApiResponse(responseCode = SWAGGER_401_CODE, description = SWAGGER_401_DESCRIPTION, content = @Content),
        @ApiResponse(responseCode = SWAGGER_404_CODE, description = SWAGGER_404_DESCRIPTION, content = @Content),
        @ApiResponse(responseCode = SWAGGER_500_CODE, description = SWAGGER_500_DESCRIPTION, content = @Content),
})
public @interface ApiCommonResponses {
}