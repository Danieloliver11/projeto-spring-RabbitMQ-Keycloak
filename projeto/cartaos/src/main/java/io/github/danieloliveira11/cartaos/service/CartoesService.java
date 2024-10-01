package io.github.danieloliveira11.cartaos.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.danieloliveira11.cartaos.domain.entity.CartaoEntity;
import io.github.danieloliveira11.cartaos.domain.factory.Cartaofactory;
import io.github.danieloliveira11.cartaos.domain.vo.CartaoVO;
import io.github.danieloliveira11.cartaos.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartoesService {
	
	private final CartaoRepository cartaoRepository;
	

	public CartaoVO salvarCartao(CartaoVO cartao) {
		
		CartaoEntity cartaoEntity = cartaoRepository.save(Cartaofactory.converterParaEntity(cartao));
		
		return Cartaofactory.converterParaVO(cartaoEntity);
	}
	
	
	public List<CartaoVO> recuperarRendaMenorOuIgual(Long renda){
		
		List<CartaoEntity> cartoesList = cartaoRepository.findByRendaLessThanEqual(BigDecimal.valueOf(renda));
		
		return Cartaofactory.converterListEntityParaListVO(cartoesList);
	}

}
