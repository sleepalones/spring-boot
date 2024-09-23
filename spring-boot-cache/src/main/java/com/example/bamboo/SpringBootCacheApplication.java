package com.example.bamboo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@EnableCaching
@MapperScan(basePackages = {"com.example.bamboo.mapper"})
@SpringBootApplication
public class SpringBootCacheApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootCacheApplication.class, args);
		System.out.println(run.getBean(CacheManager.class));
	}

}
