package io.github.danieloliveira11.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder build) {
		return build
				.routes()
				.route(r -> r.path("/clientes/**").uri("lb://cliente"))
				
				.route(r -> r.path("/cartoes/**").uri("lb://cartoes"))
				.route(r -> r.path("/cliente-cartoes/**").uri("lb://cartoes"))

				
				.route(r -> r.path("/avaliador-credito/**").uri("lb://avaliadorcredito"))
				
				
				.build();
		
		//cliente-cartoes
	}

}
