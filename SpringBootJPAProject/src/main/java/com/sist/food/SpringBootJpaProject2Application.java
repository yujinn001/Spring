package com.sist.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.food.controller","com.sist.food.dao","con.sist.food.entity"})
@SpringBootApplication
public class SpringBootJpaProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject2Application.class, args);
	}

}
