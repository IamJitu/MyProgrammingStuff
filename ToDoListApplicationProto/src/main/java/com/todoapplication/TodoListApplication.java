package com.todoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaAuditing
public class TodoListApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}
