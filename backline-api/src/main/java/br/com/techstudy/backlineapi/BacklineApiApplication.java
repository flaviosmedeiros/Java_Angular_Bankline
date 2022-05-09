package br.com.techstudy.backlineapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Anotation responsavel por desabilitar auto configuração do datasource
// @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
public class BacklineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacklineApiApplication.class, args);
	}

}
