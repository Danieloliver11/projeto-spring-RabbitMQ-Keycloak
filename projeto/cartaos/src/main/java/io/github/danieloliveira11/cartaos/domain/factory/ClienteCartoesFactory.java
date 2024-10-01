package io.github.danieloliveira11.cartaos.domain.factory;

import java.util.List;

import io.github.danieloliveira11.cartaos.domain.entity.ClienteCartaoEntity;
import io.github.danieloliveira11.cartaos.domain.vo.ClienteCartaoVO;

public class ClienteCartoesFactory {

	public static List<ClienteCartaoVO> recuperarListaParaVO(List<ClienteCartaoEntity> clienteCartaoEntity) {
		return clienteCartaoEntity.stream().map(ClienteCartoesFactory::recuperarListaParaVO).toList();
	}
	
	public static ClienteCartaoVO recuperarListaParaVO(ClienteCartaoEntity clienteCartaoEntity) {

		if(clienteCartaoEntity != null) {
			
			return ClienteCartaoVO.builder()
					.limiteBasico(clienteCartaoEntity.getLimiteBasico())
					.bandeira(clienteCartaoEntity.getCartao().getBandeira())
					.cpf(clienteCartaoEntity.getCpf())
					.build();
		}
		return null;
	}

}
