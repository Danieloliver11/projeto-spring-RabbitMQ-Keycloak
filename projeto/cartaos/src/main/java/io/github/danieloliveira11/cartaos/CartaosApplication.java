package io.github.danieloliveira11.cartaos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CartaosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaosApplication.class, args);
	}

}
