package com.api.pythagore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PythagoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PythagoreApplication.class, args);
    }

}
