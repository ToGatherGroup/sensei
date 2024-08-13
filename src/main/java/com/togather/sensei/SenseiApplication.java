package com.togather.sensei;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "Projeto Sensei",
				version = "1.0",
				description = "Projeto de software para avaliação e controle físicos de alunos de judô do Projeto Sensei Divino",
				contact = @Contact(name = "Equipe ToGather")
		),
		servers = {
				@Server(url = "http://localhost:80", description = "Servidor Local"),
				@Server(url = "https://sensei.squareweb.app/", description = "Servidor de Desenvolvimento")
		}
)
public class SenseiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenseiApplication.class, args);
	}

}
