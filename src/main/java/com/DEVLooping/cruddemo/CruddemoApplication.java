package com.DEVLooping.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.DEVLooping.cruddemo.service.EncryptService;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class CruddemoApplication {

	private EncryptService encryptService;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

		EncryptService encryptService = new EncryptService();
		String password = "123456";
		String encrypted = encryptService.encrypt(password);
		System.out.println("Encrypted: " + encrypted);
		String decrypted = encryptService.decrypt(encrypted);
		System.out.println("Decrypted: " + decrypted);
		



	}
	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
		.title("Devlooping | API de Usuarios")
		.version("1.0")
		.description("Documentación para la API de gestión de usuarios de Devlooping"));
	}
}
