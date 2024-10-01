package io.github.danieloliveira11.avaliadorcredito.model.vo;

import lombok.Builder;

@Builder
public record DadosAvaliacaoVO(
		String cpf,
		Long renda
		) {

}
