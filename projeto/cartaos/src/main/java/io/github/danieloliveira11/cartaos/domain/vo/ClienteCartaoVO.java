package io.github.danieloliveira11.cartaos.domain.vo;

import java.math.BigDecimal;

import io.github.danieloliveira11.cartaos.domain.enumeration.BandeiraCartaoEnum;
import lombok.Builder;

@Builder
public record ClienteCartaoVO( 
		String nome,
	    BandeiraCartaoEnum bandeira,
	    BigDecimal limiteBasico,
	    String cpf 
	    ) {

}
