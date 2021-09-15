package com.modeladosemanticos.sistemadebecas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(maxAge = 86400)
@SpringBootApplication
public class SistemaDeBecasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaDeBecasApplication.class, args);
    }

}
