package com.taba.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {
	// Definición de un logger para registrar información en la consola
	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		// Inicio de la aplicación Spring Boot
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	// Bean para crear una instancia de RestTemplate, que se utilizará para hacer solicitudes REST
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	// Bean CommandLineRunner, que se ejecutará al iniciar la aplicación
	@Bean
	// Este método se ejecuta solo cuando el perfil activo no es 'test'
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate){
		return args -> {
			try {
				// Hace una solicitud GET al servicio REST y obtiene un objeto Quote
				Quote quote = restTemplate.getForObject(
						"http://localhost:8080/api/random", Quote.class);
				// Registra la cita obtenida en el registro (consola)
				log.info(quote.toString());
			} catch (Exception e){
				// Manejo de la excepcion: registra el error en el registro (consola)
				log.error("Error al obtener la cita: " + e.getMessage(), e);
			}
		};
	}
}

