package io.github.danieloliveira11.cartaos.domain.vo;

import java.math.BigDecimal;

import io.github.danieloliveira11.cartaos.domain.enumeration.BandeiraCartaoEnum;
import lombok.Builder;

@Builder
public record CartaoVO( 
		Long id,
		String nome,
	    BandeiraCartaoEnum bandeira,
	    BigDecimal renda,
	    BigDecimal limiteBasico
	    
	    ) {

}
