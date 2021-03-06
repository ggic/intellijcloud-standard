package com.intellijcloud.standard.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:props/config-${DEPLOY_ENV}.properties")
@ImportResource("classpath:spring/applicationContext.xml")
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        System.setProperty("DEPLOY_ENV", "dev");

        SpringApplication.run(WebApplication.class, args);
    }

}