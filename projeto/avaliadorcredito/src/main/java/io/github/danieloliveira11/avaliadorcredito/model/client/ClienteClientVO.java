package io.github.danieloliveira11.avaliadorcredito.model.client;

import lombok.Builder;

@Builder
public record ClienteClientVO(
		 Long id,
		 String nome,
		 String cpf,
		 Long idade
		) {

}
