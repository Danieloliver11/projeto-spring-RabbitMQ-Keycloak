package io.github.danieloliveira11.cartaos.infa.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.danieloliveira11.cartaos.domain.entity.CartaoEntity;
import io.github.danieloliveira11.cartaos.domain.entity.ClienteCartaoEntity;
import io.github.danieloliveira11.cartaos.domain.factory.ClienteCartoesFactory;
import io.github.danieloliveira11.cartaos.domain.vo.SolicitarEmissaoCartaoVO;
import io.github.danieloliveira11.cartaos.repository.CartaoRepository;
import io.github.danieloliveira11.cartaos.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmissaoCartaoSubscriber {
	
	private final ClienteCartaoRepository clienteCartaoRepository ;
	private final CartaoRepository cartaoRepository;


	
	@RabbitListener(queues = "${mq.queues.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) {

		ObjectMapper mapper = new ObjectMapper();
		
		SolicitarEmissaoCartaoVO emissaoCartoesVO = null;
		
		try {
			
			emissaoCartoesVO = mapper.readValue(payload, SolicitarEmissaoCartaoVO.class );
			
		} catch (JsonProcessingException e) {
			log.error("Erro ao receber solicitaçõ da emissão de cartão da fila {}", e.getMessage());
		}
		
		CartaoEntity cartaoEntity = cartaoRepository.findById(emissaoCartoesVO.idCartao()).orElseThrow(); //TODO TRATAR EXCEPTION

		
		ClienteCartaoEntity clienteCartaoEntitiy = ClienteCartoesFactory.converteSolicitacaoCartaoParaEntity(emissaoCartoesVO,cartaoEntity);

		clienteCartaoRepository.save(clienteCartaoEntitiy);
	}

}
