package com.lucas.crudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lucas.crudspring.controller", "/crudspring/src/main/java/com/lucas/crudspring/controller/ProdutoController.java", "com.lucas.crudspring"})
public class CrudspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudspringApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("123"));
	}



}
