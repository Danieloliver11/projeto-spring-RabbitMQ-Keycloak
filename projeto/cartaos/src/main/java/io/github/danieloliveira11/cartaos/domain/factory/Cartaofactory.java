package io.github.danieloliveira11.cartaos.domain.factory;

import java.util.List;

import io.github.danieloliveira11.cartaos.domain.entity.CartaoEntity;
import io.github.danieloliveira11.cartaos.domain.vo.CartaoVO;

public class Cartaofactory {

	public static CartaoEntity converterParaEntity(CartaoVO cartao) {

		return CartaoEntity
				.builder()
				.bandeira(cartao.bandeira())
				.limiteBasico(cartao.limiteBasico())
				.nome(cartao.nome())
				.renda(cartao.renda())
				.build();
	}

	public static CartaoVO converterParaVO(CartaoEntity cartaoEntity) {
		if(cartaoEntity != null) {
			return CartaoVO.builder()
					.id(cartaoEntity.getId())
					.bandeira(cartaoEntity.getBandeira())
					.limiteBasico(cartaoEntity.getLimiteBasico())
					.nome(cartaoEntity.getNome())
					.renda(cartaoEntity.getRenda())
					.build();
			}
		return null; 
	
	}

	public static List<CartaoVO> converterListEntityParaListVO(List<CartaoEntity> cartoesList) {
		return cartoesList.stream().map(Cartaofactory::converterParaVO).toList();
	}

}
