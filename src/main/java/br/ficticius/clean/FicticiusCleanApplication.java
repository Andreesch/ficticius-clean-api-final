package br.ficticius.clean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = "br.ficticius.clean.model")
public class FicticiusCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicticiusCleanApplication.class, args);
	}
}
