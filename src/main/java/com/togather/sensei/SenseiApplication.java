package com.togather.sensei;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Projeto Sensei",
				version = "1.0",
				description = "Projeto de software para avaliação e controle físicos de alunos de judô do Projeto Sensei Divino",
				contact = @Contact(name = "Equipe ToGather")
		)
)
public class SenseiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenseiApplication.class, args);
	}

}
