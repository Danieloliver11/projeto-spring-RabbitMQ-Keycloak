package io.github.danieloliveira11.avaliadorcredito.model.factory;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.vo.DadosCliente;
import io.github.danieloliveira11.avaliadorcredito.model.vo.SituacaoClienteVO;

public class SituacaoClienteFactory {

	public static SituacaoClienteVO convertetClientParaVO(ResponseEntity<ClienteClientVO> cliente, List<ClienteCartaoClientVO> clienteCartoeList) {

		
		return SituacaoClienteVO
				.builder()
				.cliente(cliente.getBody() != null ? DadosCliente
						.builder()
						.id(cliente.getBody().id())
						.nome(cliente.getBody().nome())
						.build() : null) 
				.cartoes(ClienteCartaoClientFactory.converterlist(clienteCartoeList))
				
				.build();
	}

}
