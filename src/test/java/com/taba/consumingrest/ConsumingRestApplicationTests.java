package com.taba.consumingrest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

// Anotación para indicar que esta clase es una prueba de Spring Boot y que debe cargar el contexto de la aplicación
@SpringBootTest
// Anotación para activar perfiles específicos durante las pruebas; en este caso, el perfil 'test'
@ActiveProfiles("test")
class ConsumingRestApplicationTests {

	// Inyección de dependencia del bean RestTemplate para usarlo en las pruebas
	@Autowired
	private RestTemplate restTemplate;

	// Método de prueba para verificar si el contexto de la aplicación se carga correctamente
	@Test
	public void contextLoads() {
		// Verifica que el bean RestTemplate no sea nulo, lo que indica que se ha inyectado correctamente
		assertThat(restTemplate).isNotNull();
	}

}
