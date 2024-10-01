package io.github.danieloliveira11.avaliadorcredito.model.vo;

import java.util.List;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;
import lombok.Builder;

@Builder
public record SituacaoClienteVO(
		DadosCliente cliente,
		List<ClienteCartaoClientVO> cartoes
		
		) {

}
