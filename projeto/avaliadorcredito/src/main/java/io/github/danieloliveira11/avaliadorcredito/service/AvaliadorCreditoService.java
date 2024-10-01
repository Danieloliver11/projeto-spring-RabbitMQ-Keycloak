package io.github.danieloliveira11.avaliadorcredito.service;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException;
import io.github.danieloliveira11.avaliadorcredito.infra.clients.ClienteCartoesClient;
import io.github.danieloliveira11.avaliadorcredito.infra.clients.ClienteClient;
import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.exception.RetornoNotFoundException;
import io.github.danieloliveira11.avaliadorcredito.model.exception.RetornoNotFoundException;
import io.github.danieloliveira11.avaliadorcredito.model.factory.SituacaoClienteFactory;
import io.github.danieloliveira11.avaliadorcredito.model.vo.SituacaoClienteVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {
	
	private final ClienteClient clienteClient;
	private final ClienteCartoesClient clienteCartoesClient;

	
	public SituacaoClienteVO consultaSituacaoCliente(String cpf) throws RetornoNotFoundException {
		
		ResponseEntity<ClienteClientVO>	cliente = null;
		List<ClienteCartaoClientVO> clienteCartoeList = null;

		
		try {
			
			cliente = clienteClient.recuperarPorCpf(cpf);	
			
			clienteCartoeList = clienteCartoesClient.recuperarCartoesPorCpf(cpf);		

			
		} catch (FeignException e) {
			int statur = e.status();
			if(HttpStatus.SC_NOT_FOUND == statur)
				throw new RetornoNotFoundException("Dados do cliente não encontrados para o cpf informado");
			
		}
		
		return SituacaoClienteFactory.convertetClientParaVO(cliente,clienteCartoeList);
	}

}
