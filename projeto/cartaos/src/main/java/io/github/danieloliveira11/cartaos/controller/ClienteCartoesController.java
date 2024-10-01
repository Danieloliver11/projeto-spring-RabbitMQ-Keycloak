package io.github.danieloliveira11.cartaos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danieloliveira11.cartaos.domain.vo.ClienteCartaoVO;
import io.github.danieloliveira11.cartaos.service.ClienteCartoesService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("cliente-cartoes")
@RequiredArgsConstructor
public class ClienteCartoesController {
	
	private final ClienteCartoesService clienteCartoesService;
	
	@GetMapping("/status-services")
	public String statusService() {
		return "api-cartoes: OK";
	}
	
	
	@GetMapping("/{cpf}")
	public List<ClienteCartaoVO> recuperarCartoesPorCpf(@PathVariable String cpf) {
		return clienteCartoesService.recuperarCartoesPorCpf(cpf);
	}

}
