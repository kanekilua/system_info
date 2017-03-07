package com.sanmina.sys_i;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by kane on 17-3-6.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.sanmina.sys_i.controller")
@ComponentScan(basePackages = "com.sanmina.sys_i.service")
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }
}
