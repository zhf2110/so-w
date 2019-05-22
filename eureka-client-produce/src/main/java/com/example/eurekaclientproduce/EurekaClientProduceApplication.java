package com.example.eurekaclientproduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProduceApplication.class, args);
	}


	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
