package io.github.danieloliveira11.avaliadorcredito.model.factory;

import java.util.List;

import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;

public class ClienteCartaoClientFactory {

	public static List<ClienteCartaoClientVO> converterlist(List<ClienteCartaoClientVO> clienteCartoeList) {
		return clienteCartoeList.stream().map(ClienteCartaoClientFactory::converter).toList();
	}
	
	public static ClienteCartaoClientVO converter(ClienteCartaoClientVO clienteCartao) {
		if(clienteCartao != null) {
			return clienteCartao
					.builder()
					.bandeira(clienteCartao.bandeira())
					.cpf(clienteCartao.cpf())
					.limiteBasico(clienteCartao.limiteBasico())
					.nome(clienteCartao.nome())
					.build();
		}
		return null;
	}

}
