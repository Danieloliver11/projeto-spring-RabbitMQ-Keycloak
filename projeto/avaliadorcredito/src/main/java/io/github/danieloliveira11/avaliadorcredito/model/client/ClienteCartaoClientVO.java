package io.github.danieloliveira11.avaliadorcredito.model.client;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ClienteCartaoClientVO(
		String nome,
	    String bandeira,
	    BigDecimal limiteBasico,
	    String cpf ) {

}
