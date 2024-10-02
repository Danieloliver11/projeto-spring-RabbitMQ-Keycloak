package io.github.danieloliveira11.avaliadorcredito;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableFeignClients(basePackages = "io.github.danieloliveira11.avaliadorcredito.infra.clients")
public class AvaliadorcreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliadorcreditoApplication.class, args);
	}

}
