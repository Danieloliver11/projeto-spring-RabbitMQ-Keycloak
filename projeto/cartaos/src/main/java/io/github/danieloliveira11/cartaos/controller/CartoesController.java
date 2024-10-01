package io.github.danieloliveira11.cartaos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danieloliveira11.cartaos.domain.vo.CartaoVO;
import io.github.danieloliveira11.cartaos.service.CartoesService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesController {
	
	private final CartoesService cartoesService;
	
	@GetMapping("/status-services")
	public String statusService() {
		return "api-cartoes: OK";
	}
	
	@PostMapping()
	public CartaoVO salvarCartao(@RequestBody CartaoVO cartao) {
		return cartoesService.salvarCartao(cartao);
	}
	
	@GetMapping("/{renda}")
	public List<CartaoVO> recuperarRendaMenorOuIgual(@PathVariable Long renda) {
		return cartoesService.recuperarRendaMenorOuIgual(renda);
	}

}
