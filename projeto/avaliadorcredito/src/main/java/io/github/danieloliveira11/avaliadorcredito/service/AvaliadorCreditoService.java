package io.github.danieloliveira11.avaliadorcredito.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import feign.FeignException;
import io.github.danieloliveira11.avaliadorcredito.infra.clients.mscartoes.CartoesClient;
import io.github.danieloliveira11.avaliadorcredito.infra.clients.mscartoes.ClienteCartoesClient;
import io.github.danieloliveira11.avaliadorcredito.infra.clients.mscliente.ClienteClient;
import io.github.danieloliveira11.avaliadorcredito.infra.queue.EmissaoCartaoPublisher;
import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteCartaoClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.client.ClienteClientVO;
import io.github.danieloliveira11.avaliadorcredito.model.exception.ErroPublisher;
import io.github.danieloliveira11.avaliadorcredito.model.exception.RetornoNotFoundException;
import io.github.danieloliveira11.avaliadorcredito.model.factory.SituacaoClienteFactory;
import io.github.danieloliveira11.avaliadorcredito.model.queue.SolicitacaoEmissaoCartaoVO;
import io.github.danieloliveira11.avaliadorcredito.model.vo.CartaoAprovadoVO;
import io.github.danieloliveira11.avaliadorcredito.model.vo.DadosAvaliacaoRetornoVO;
import io.github.danieloliveira11.avaliadorcredito.model.vo.DadosAvaliacaoVO;
import io.github.danieloliveira11.avaliadorcredito.model.vo.ProtocoloSolicitacaoCartao;
import io.github.danieloliveira11.avaliadorcredito.model.vo.SituacaoClienteVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {
	
	private final ClienteClient clienteClient;
	private final ClienteCartoesClient clienteCartoesClient;
	private final CartoesClient cartoesClient;
	
	private final EmissaoCartaoPublisher emissaoCartaoPublisher;


	
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


	public DadosAvaliacaoRetornoVO realizarAvaliazaco(DadosAvaliacaoVO dados) throws RetornoNotFoundException {

		ResponseEntity<ClienteClientVO>	clienteResponse = null;
		List<ClienteCartaoClientVO> clienteCartaoClientList = null;
		
		List<CartaoAprovadoVO> cartoesAprovados = null;

		
		try {
			
			clienteResponse = clienteClient.recuperarPorCpf(dados.cpf());	
			clienteCartaoClientList = cartoesClient.recuperarRendaMenorOuIgual(dados.renda());	
			
			if(clienteCartaoClientList != null) {
				cartoesAprovados = gerarCartoesAprovados(clienteCartaoClientList, clienteResponse.getBody());
			}

			
		} catch (FeignException e) {
			int statur = e.status();
			if(HttpStatus.SC_NOT_FOUND == statur)
				throw new RetornoNotFoundException("Dados do cliente não encontrados para o cpf informado");
			
		}
		
		DadosAvaliacaoRetornoVO dadosAvaliacaoVO = DadosAvaliacaoRetornoVO.builder()
		.cartaos(cartoesAprovados)
		.build();
		

		return dadosAvaliacaoVO;
	}

	private List<CartaoAprovadoVO> gerarCartoesAprovados(List<ClienteCartaoClientVO> clienteCartaoClientList, ClienteClientVO clienteResponse) {
		return clienteCartaoClientList.stream().map(cartao -> {
			
			
			BigDecimal limiteBasico = cartao.limiteBasico();
			BigDecimal idadeBD = BigDecimal.valueOf(clienteResponse.idade());
			BigDecimal fator = idadeBD.divide(BigDecimal.valueOf(10));
			
			BigDecimal limiteAprovado = fator.multiply(limiteBasico);
			
			return CartaoAprovadoVO.builder()
					.idCartao(cartao.id())
					.cartao(cartao.nome())
					.bandeira(cartao.bandeira())
					.limiteAprovado(limiteAprovado)
					.build();
			
		}).collect(Collectors.toList());
	}
	


	public ProtocoloSolicitacaoCartao solicitarCartao(SolicitacaoEmissaoCartaoVO dadosAvaliacaoVO) {

		try {
			emissaoCartaoPublisher.solicitarCartao(dadosAvaliacaoVO);

			String protocolo = UUID.randomUUID().toString();
			
			return ProtocoloSolicitacaoCartao.builder().protocolo(protocolo).build();

		} catch (JsonProcessingException e) {
			throw new ErroPublisher(e.getMessage());
		}

	}



}
