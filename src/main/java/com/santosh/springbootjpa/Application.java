package com.santosh.springbootjpa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(info = @Info(title = "RESTful APIs for Project Management System"))
@EnableJpaRepositories(basePackages = {"com.santosh.springbootjpa.repository"})
@EntityScan(basePackages = {"com.santosh.springbootjpa.model"})
@SpringBootApplication(scanBasePackages = {"com.santosh.springbootjpa"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
