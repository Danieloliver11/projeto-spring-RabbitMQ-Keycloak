package io.github.danieloliveira11.avaliadorcredito.model.queue;

import java.math.BigDecimal;

public record SolicitacaoEmissaoCartaoVO(
		Long idCartao,
		String cpf,
		String endereco,
		BigDecimal limiteLiberado) {

}
