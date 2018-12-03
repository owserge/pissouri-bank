package com.pissouri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("WeakerAccess")
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
