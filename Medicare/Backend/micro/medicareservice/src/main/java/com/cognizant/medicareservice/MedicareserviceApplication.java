package com.cognizant.medicareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicareserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicareserviceApplication.class, args);
	}

}
