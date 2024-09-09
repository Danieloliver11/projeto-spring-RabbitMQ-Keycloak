package io.github.danieloliveira11.clientes.service;

import java.util.Optional;

import io.github.danieloliveira11.clientes.domain.ClienteEntity;
import io.github.danieloliveira11.clientes.domain.vo.ClienteVO;

public class ClienteFactory {

	public static ClienteEntity toEntity(ClienteVO vo) {

		ClienteEntity entity = new ClienteEntity();

		entity.setCpf(vo.getCpf());
		entity.setIdade(vo.getIdade());
		entity.setNome(vo.getNome());

		return entity;
	}

	public static Optional<ClienteVO> toVO(Optional<ClienteEntity> save) {

		if (save.isPresent()) {
			
			
			ClienteVO vo = new ClienteVO();
			vo.setId(save.get().getId());
			vo.setCpf(save.get().getCpf());
			vo.setIdade(save.get().getIdade());
			vo.setNome(save.get().getNome());
			return Optional.of(vo);
		}

		return Optional.empty();
	}

}
