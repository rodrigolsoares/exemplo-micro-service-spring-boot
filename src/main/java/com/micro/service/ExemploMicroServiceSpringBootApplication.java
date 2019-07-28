package com.micro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ExemploMicroServiceSpringBootApplication implements CommandLineRunner{
	
	Logger LOG = LoggerFactory.getLogger(ExemploMicroServiceSpringBootApplication.class);
	
	@Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExemploMicroServiceSpringBootApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		LOG.info("Aplicação iniciada com sucesso!!!");
	}

}
