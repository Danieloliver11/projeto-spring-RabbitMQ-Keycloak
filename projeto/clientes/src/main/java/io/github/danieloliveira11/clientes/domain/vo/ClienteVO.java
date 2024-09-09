package io.github.danieloliveira11.clientes.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteVO {
	
	private Long id;
	private String nome;
	private String cpf;
	private Long idade;
	

}
