package io.github.danieloliveira11.avaliadorcredito.infra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteClientVO;

//value = micro servico 
@FeignClient(value = "cliente", path = "/clientes")
public interface ClienteClient {
	
	@GetMapping("/recuperar-por-cpf/{cpf}")
	public ResponseEntity<ClienteClientVO> recuperarPorCpf(@PathVariable String cpf);
	
	@GetMapping("/status-services")
	public String statusService();
	
//	@PostMapping
//	public ResponseEntity<ClienteVO> salvarCliente(@RequestBody ClienteVO clienteVO);

}
