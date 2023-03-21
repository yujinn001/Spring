package com.sist.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.board.controller","com.sist.board.entity","com.sist.board.dao"})
@SpringBootApplication
public class SpringBootJpaProject21Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject21Application.class, args);
	}

}
