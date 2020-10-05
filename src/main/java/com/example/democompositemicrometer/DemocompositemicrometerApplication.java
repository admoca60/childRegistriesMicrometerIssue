package com.example.democompositemicrometer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemocompositemicrometerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemocompositemicrometerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
    }
}
