package com.aplication.rest.SpringBootRest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimAccessor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    @Autowired
    private JwtEncoder jwtEncoder;

    @PostMapping("/token")
    public Map<String,String> generarToken (Authentication authentication){
        Map<String,String>idTokken = new HashMap<>();
        Instant instant = Instant.now(); // obtenemos la hora actual

        String scope = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(authentication.getName()) // Establecemos el nombre del usuario autenticado
                .issuedAt(instant) //Establecemos la hora de emision del token
        // Establecemos la fecha de expiracion del JWT 5 min apartir de la hora actual
                .expiresAt(instant.plus(25, ChronoUnit.MINUTES))
                .issuer("security-service") // Emisor del token
                .claim("scope",scope)
                .build();

        String jwtAccesToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        idTokken.put("accessToken",jwtAccesToken);
        return idTokken;

    }

}
