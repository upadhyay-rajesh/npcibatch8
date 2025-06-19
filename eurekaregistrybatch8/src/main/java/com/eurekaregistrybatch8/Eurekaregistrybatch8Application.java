package com.eurekaregistrybatch8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaregistrybatch8Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaregistrybatch8Application.class, args);
	}

}
