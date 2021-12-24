package com.ketul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DiscoveryClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClient1Application.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate geTemplate() {
		return new RestTemplate();
	}
}
