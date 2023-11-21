package com.youcode.marjanv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
public class MarjanV2Application {
    public static void main(String[] args) {
        SpringApplication.run(MarjanV2Application.class, args);
    }
}