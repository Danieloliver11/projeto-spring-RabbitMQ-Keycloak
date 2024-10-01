package io.github.danieloliveira11.avaliadorcredito.infra.clients.mscartoes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;


@FeignClient(value = "cartoes", contextId = "clienteCartoesClient",path = "/cliente-cartoes")
public interface ClienteCartoesClient {
	
	
	@GetMapping("/{cpf}")
	public List<ClienteCartaoClientVO> recuperarCartoesPorCpf(@PathVariable String cpf);


}
