package com.aplication.rest.SpringBootRest.security.configsecurity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


// vinculamos propiedades de confuguracion con campos de la clase RsaKeysConfig
@ConfigurationProperties (prefix = "rsa")
public record RsaKeysConfig(RSAPublicKey publicKey, RSAPrivateKey privateKey ) {




}
