package com.aplication.rest.SpringBootRest.configuration.swagger;


public final class SwaggerResponseConstants {

    private SwaggerResponseConstants() {}

    // Códigos de estado HTTP (como String para usar en @ApiResponse)
    public static final String SWAGGER_200_CODE = "200";
    public static final String SWAGGER_201_CODE = "201";
    public static final String SWAGGER_400_CODE = "400";
    public static final String SWAGGER_401_CODE = "401";
    public static final String SWAGGER_403_CODE = "403";
    public static final String SWAGGER_404_CODE = "404";
    public static final String SWAGGER_422_CODE = "422";
    public static final String SWAGGER_500_CODE = "500";

    // Descripciones para Swagger
    public static final String SWAGGER_200_DESCRIPTION = "Operación exitosa";
    public static final String SWAGGER_201_DESCRIPTION = "Recurso creado correctamente";
    public static final String SWAGGER_400_DESCRIPTION = "Solicitud inválida";
    public static final String SWAGGER_401_DESCRIPTION = "No autorizado";
    public static final String SWAGGER_403_DESCRIPTION = "Prohibido";
    public static final String SWAGGER_404_DESCRIPTION = "Recurso no encontrado";
    public static final String SWAGGER_422_DESCRIPTION = "Entidad no procesable (error de validación)";
    public static final String SWAGGER_500_DESCRIPTION = "Error interno del servidor";
}