package com.example.bamboo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.bamboo.mapper"})
public class SpringBootIdempotentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIdempotentApplication.class, args);
	}

}
