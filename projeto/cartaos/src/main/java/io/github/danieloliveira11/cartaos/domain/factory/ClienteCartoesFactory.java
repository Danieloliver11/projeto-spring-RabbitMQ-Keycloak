package io.github.danieloliveira11.cartaos.domain.factory;

import java.util.List;

import io.github.danieloliveira11.cartaos.domain.entity.CartaoEntity;
import io.github.danieloliveira11.cartaos.domain.entity.ClienteCartaoEntity;
import io.github.danieloliveira11.cartaos.domain.vo.ClienteCartaoVO;
import io.github.danieloliveira11.cartaos.domain.vo.SolicitarEmissaoCartaoVO;

public class ClienteCartoesFactory {

	public static List<ClienteCartaoVO> recuperarListaParaVO(List<ClienteCartaoEntity> clienteCartaoEntity) {
		return clienteCartaoEntity.stream().map(ClienteCartoesFactory::recuperarListaParaVO).toList();
	}
	
	public static ClienteCartaoVO recuperarListaParaVO(ClienteCartaoEntity clienteCartaoEntity) {

		if(clienteCartaoEntity != null) {
			
			return ClienteCartaoVO.builder()
					.nome(clienteCartaoEntity.getCartao() != null ? clienteCartaoEntity.getCartao().getNome() : null)
					.limiteBasico(clienteCartaoEntity.getLimiteBasico())
					.bandeira(clienteCartaoEntity.getCartao().getBandeira())
					.cpf(clienteCartaoEntity.getCpf())
					.build();
		}
		return null;
	}

	public static ClienteCartaoEntity converteSolicitacaoCartaoParaEntity(SolicitarEmissaoCartaoVO emissaoCartoesVO,
			CartaoEntity cartaoEntity) {

		if(emissaoCartoesVO != null && cartaoEntity != null) {
			
			return ClienteCartaoEntity
					.builder()
					.cartao(cartaoEntity)
					.cpf(emissaoCartoesVO.cpf())
					.limiteBasico(emissaoCartoesVO.limiteLiberado())
					.build();
		}
		
		
		
		return null;
	}

}
