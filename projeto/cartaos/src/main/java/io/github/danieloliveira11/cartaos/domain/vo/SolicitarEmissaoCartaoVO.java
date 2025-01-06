package io.github.danieloliveira11.cartaos.domain.vo;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record SolicitarEmissaoCartaoVO(
		Long idCartao,
		String cpf,
		String endereco,
		BigDecimal limiteLiberado) {

}
