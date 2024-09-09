package io.github.danieloliveira11.clientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.danieloliveira11.clientes.domain.vo.ClienteVO;
import io.github.danieloliveira11.clientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	
	public Optional<ClienteVO> salvarCliente(ClienteVO vo) {	
			
		return ClienteFactory.toVO(Optional.of(clienteRepository.save(ClienteFactory.toEntity(vo))));
	}


	public  Optional<ClienteVO> recuperarPorCpf(String cpf) {
		
		return ClienteFactory.toVO(clienteRepository.findByCpf(cpf));
	}
	
	

}
