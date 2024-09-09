package io.github.danieloliveira11.cartaos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cartoes")
//@RequiredArgsConstructor
public class CartoesController {
	
	
	
	@GetMapping("/status-services")
	public String statusService() {
		return "api-cartoes: OK";
	}

}
