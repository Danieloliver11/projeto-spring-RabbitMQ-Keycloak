package io.github.danieloliveira11.avaliadorcredito.infra.clients.mscartoes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;

@FeignClient(value = "cartoes", contextId = "cartoesClient", path = "/cartoes")
public interface CartoesClient {
    
    @GetMapping("/{renda}")
    List<ClienteCartaoClientVO> recuperarRendaMenorOuIgual(@PathVariable Long renda);
    
    
}
