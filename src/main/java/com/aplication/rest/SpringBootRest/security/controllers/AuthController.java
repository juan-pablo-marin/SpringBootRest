package com.aplication.rest.SpringBootRest.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping("/token")
    public ResponseEntity<Map<String,String>> generarToken (String grantType, String username,String password, boolean withRefreshToken, String refreshToken){
       String subject = null;
       String scope = null;

       if(grantType.equals("password")){
           Authentication authentication= authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(username,password)
           );
           // obtenemos los datos del usuario autenticado
           subject = authentication.getName();
           scope= authentication.getAuthorities()
                   .stream().map(aut ->aut.getAuthority())
                   .collect(Collectors.joining(" "));
           
       } else if (grantType.equals("refreshToken")) {
           if (refreshToken==null){
               return new ResponseEntity<>(Map.of("errorMessage","El refresh token es requerido"), HttpStatus.UNAUTHORIZED);
           }
           Jwt decodeJWT= null;
           try{
               //extraemos informacion del refresh token
               decodeJWT= jwtDecoder.decode(refreshToken);
           }catch (JwtException exception){
               return new ResponseEntity<>(Map.of("ErrorMessage", exception.getMessage()), HttpStatus.UNAUTHORIZED);
           }
           subject = decodeJWT.getSubject();
           UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
           Collection<? extends GrantedAuthority> authorities= userDetails.getAuthorities();
           scope = authorities.stream()
                   .map(auth->auth.getAuthority()).collect(Collectors.joining(" "));
       }

        Map<String,String>idToken = new HashMap<>();
        Instant instant = Instant.now(); // obtenemos la hora actual

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject) // Establecemos el nombre del usuario autenticado
                .issuedAt(instant) //Establecemos la hora de emision del token
        // Establecemos la fecha de expiracion del JWT en min apartir de la hora actual
                .expiresAt(instant.plus(withRefreshToken?19:20, ChronoUnit.MINUTES))
                .issuer("security-service") // Emisor del token
                .claim("scope",scope)
                .build();

        String jwtAccesToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        idToken.put("accessToken",jwtAccesToken);

        if(withRefreshToken){
            JwtClaimsSet jwtClaimsSetRefresh = JwtClaimsSet.builder()
                    .subject(subject) // Establecemos el nombre del usuario autenticado
                    .issuedAt(instant) //Establecemos la hora de emision del token
                    // Establecemos la fecha de expiracion del JWT 5 min apartir de la hora actual
                    .expiresAt(instant.plus( 5, ChronoUnit.MINUTES))
                    .issuer("security-service") // Emisor del token
                    .claim("scope",scope)
                    .build();

            String jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            idToken.put("refreshToken",jwtRefreshToken);
        }
        return new ResponseEntity<>(idToken,HttpStatus.OK);
    }
}
