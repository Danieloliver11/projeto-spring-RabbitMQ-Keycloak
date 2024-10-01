package io.github.danieloliveira11.cartaos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.danieloliveira11.cartaos.domain.factory.ClienteCartoesFactory;
import io.github.danieloliveira11.cartaos.domain.vo.ClienteCartaoVO;
import io.github.danieloliveira11.cartaos.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartoesService {
	
	private final ClienteCartaoRepository clienteCartaoRepository;
	
	public List<ClienteCartaoVO> recuperarCartoesPorCpf(String cpf) {
		
		return  ClienteCartoesFactory.recuperarListaParaVO(clienteCartaoRepository.findByCpf(cpf));
		
	}

}
