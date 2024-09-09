package io.github.danieloliveira11.clientes.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danieloliveira11.clientes.domain.vo.ClienteVO;
import io.github.danieloliveira11.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@GetMapping("/status-services")
	public String statusService() {
		return "api-cliente: OK";
	}
	
	@PostMapping
	public ResponseEntity<ClienteVO> salvarCliente(@RequestBody ClienteVO clienteVO) {
	
		return ResponseEntity.status(HttpStatus.SC_CREATED).body(clienteService.salvarCliente(clienteVO).get());
	}
	
	@GetMapping("/recuperar-por-cpf/{cpf}")
	public ResponseEntity<ClienteVO> recuperarPorCpf(@PathVariable String cpf){
		return clienteService.recuperarPorCpf(cpf).map(vo ->  
		ResponseEntity.ok(vo)).orElse(ResponseEntity.notFound().build());

	}

}
