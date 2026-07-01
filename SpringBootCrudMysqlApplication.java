package com.jbm.spring_boot_crud_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Emp API By PARWEZ",
		description = "This is API is used for Personal Uses and Sum CRUD Operation",
		version = "5.0",
		
		contact=@Contact(name = "M PARWEZ",
		                 email ="musarrafparwez7@gmail.com",
		                 url = "https://en.wikipedia.org/wiki/Novel")
		))
public class SpringBootCrudMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudMysqlApplication.class, args);
	}

}
