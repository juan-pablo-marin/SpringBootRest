package com.aplication.rest.SpringBootRest;

import com.aplication.rest.SpringBootRest.config.RsaKeysConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//habilita la carga de propiedades
@EnableConfigurationProperties(RsaKeysConfig.class)
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

}
