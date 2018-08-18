package com.repuestos.bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiApplication.class, args);
	}
}
