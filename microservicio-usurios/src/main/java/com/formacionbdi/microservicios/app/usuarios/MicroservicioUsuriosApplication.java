package com.formacionbdi.microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EnableEurekaClient
@SpringBootApplication
public class MicroservicioUsuriosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioUsuriosApplication.class, args);
	}

}
