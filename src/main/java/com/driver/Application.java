package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  //http://localhost:8080/swagger-ui.html#
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
