package io.github.danieloliveira11.avaliadorcredito.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;


@FeignClient(value = "cartoes", path = "/cliente-cartoes")
public interface CartoesClient {
	
	
	@GetMapping("/{cpf}")
	public List<ClienteCartaoClientVO> recuperarCartoesPorCpf(@PathVariable String cpf);


}
