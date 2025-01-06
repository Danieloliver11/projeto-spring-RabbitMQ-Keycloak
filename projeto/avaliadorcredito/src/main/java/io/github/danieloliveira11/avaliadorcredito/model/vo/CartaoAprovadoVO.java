package io.github.danieloliveira11.avaliadorcredito.model.vo;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CartaoAprovadoVO(
		Long idCartao,
		String cartao,
		String bandeira,
		BigDecimal limiteAprovado) {

}
