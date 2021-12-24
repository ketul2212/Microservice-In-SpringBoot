package com.ketul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ketul.module.dto.EmployeeDto;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClientApplication.class, args);
	}

	@Bean
	public EmployeeDto getemployeeDto() {
		return new EmployeeDto();
	}
}
