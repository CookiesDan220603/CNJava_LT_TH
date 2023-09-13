package com.example.ex01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex01Application {
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("Môn công nghệ java");
    }
    public static void main(String[] args) {
        SpringApplication.run(Ex01Application.class, args);
    }
}
