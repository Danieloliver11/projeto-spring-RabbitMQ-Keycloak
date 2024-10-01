package io.github.danieloliveira11.avaliadorcredito.model.vo;

import java.util.List;

import lombok.Builder;

@Builder
public record DadosAvaliacaoRetornoVO(
		List<CartaoAprovadoVO> cartaos
		) {

}
