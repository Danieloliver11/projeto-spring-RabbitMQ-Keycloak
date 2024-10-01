package io.github.danieloliveira11.avaliadorcredito.controller;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danieloliveira11.avaliadorcredito.model.exception.RetornoNotFoundException;
import io.github.danieloliveira11.avaliadorcredito.model.vo.SituacaoClienteVO;
import io.github.danieloliveira11.avaliadorcredito.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avaliador-credito")
@RequiredArgsConstructor
@EnableFeignClients
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	@GetMapping("/status-services")
	public String statusService() {
		return "api-avaliador-credito-controller: OK";
	}
	
	@GetMapping("situacao-cliente/{cpf}")
	public SituacaoClienteVO consultaSituacaoCliente(@PathVariable String cpf) throws RetornoNotFoundException  {
		return avaliadorCreditoService.consultaSituacaoCliente(cpf);
		
	}

}
