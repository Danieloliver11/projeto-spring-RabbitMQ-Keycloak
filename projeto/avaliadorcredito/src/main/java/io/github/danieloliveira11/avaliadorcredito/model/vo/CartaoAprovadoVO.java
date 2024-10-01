package io.github.danieloliveira11.avaliadorcredito.model.vo;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CartaoAprovadoVO(
		String cartao,
		String bandeira,
		BigDecimal limiteAprovado) {

}
