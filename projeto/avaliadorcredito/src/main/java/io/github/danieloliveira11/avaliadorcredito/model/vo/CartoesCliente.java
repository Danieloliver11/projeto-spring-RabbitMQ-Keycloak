package io.github.danieloliveira11.avaliadorcredito.model.vo;

import java.math.BigDecimal;

public record CartoesCliente(
		Long id,
		String nome,
		String bandeira,
		BigDecimal limiteLiberado
		
		) {

}
