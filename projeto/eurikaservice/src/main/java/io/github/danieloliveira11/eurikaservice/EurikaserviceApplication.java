package io.github.danieloliveira11.eurikaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurikaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurikaserviceApplication.class, args);
	}

}
