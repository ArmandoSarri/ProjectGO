package com.ProjectGO;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArmandoSarrionProjectGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmandoSarrionProjectGoApplication.class, args);
		

		Persistence.generateSchema("jpa", null);
	}

}
